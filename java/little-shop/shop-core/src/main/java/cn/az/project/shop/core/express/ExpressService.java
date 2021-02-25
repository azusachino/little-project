package cn.az.project.shop.core.express;

import cn.az.project.shop.core.express.config.ExpressProperties;
import cn.az.project.shop.core.express.entity.ExpressInfo;
import cn.az.project.shop.core.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author az
 * @since 09/09/20
 */
@Service
public class ExpressService {

    /**
     * 请求url
     */
    private final static String REQ_URL = "http://api.kdniao.com/Ebusiness/EbusinessOrderHandle.aspx";

    /**
     * 日志插件
     */
    private final Log logger = LogFactory.getLog(ExpressService.class);

    /**
     * 快递API相关信息
     */
    @Resource
    private ExpressProperties properties;

    /**
     * 获取物流供应商名
     */
    public String getVendorName(String vendorCode) {
        for (Map<String, String> item : properties.getVendors()) {
            if (item.get("code").equals(vendorCode)) {
                return item.get("name");
            }
        }
        return null;
    }

    public List<Map<String, String>> getVendors() {
        return properties.getVendors();
    }

    /**
     * 获取物流信息
     */
    public ExpressInfo getExpressInfo(String expCode, String expNo) {
        if (!properties.isEnable()) {
            return null;
        }

        try {
            String result = getOrderTracesByJson(expCode, expNo);
            ObjectMapper objMap = new ObjectMapper();
            ExpressInfo ei = objMap.readValue(result, ExpressInfo.class);
            ei.setShipperName(getVendorName(expCode));
            return ei;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * Json方式 查询订单物流轨迹
     *
     * @throws Exception e
     */
    private String getOrderTracesByJson(String expCode, String expNo) throws Exception {
        String requestData = "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<>(16);
        params.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));
        params.put("EBusinessID", properties.getAppId());
        params.put("RequestType", "1002");
        String dataSign = encrypt(requestData, properties.getAppKey());
        Assert.notNull(dataSign, "dataDesign不应该为空");
        params.put("DataSign", URLEncoder.encode(dataSign, "UTF-8"));
        params.put("DataType", "2");

        //根据公司业务处理返回的信息......

        return HttpUtil.sendPost(REQ_URL, params);
    }

    /**
     * MD5加密
     *
     * @param str 内容
     * @throws Exception e
     */
    private String md5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest();
        StringBuilder sb = new StringBuilder(32);
        for (byte b : result) {
            int val = b & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * Sign签名生成
     *
     * @param content  内容
     * @param keyValue Appkey
     * @return DataSign签名
     */
    private String encrypt(String content, String keyValue) {
        if (keyValue != null) {
            content = content + keyValue;
        }
        byte[] src;
        try {
            src = md5(content).getBytes(StandardCharsets.UTF_8);
            return Base64Utils.encodeToString(src);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }


}
