package cn.az.replica.mall.controller;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.exception.MallException;
import cn.az.replica.mall.util.FileUtil;
import cn.az.replica.mall.util.HttpUtil;
import cn.hutool.log.Log;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * CommonController
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see BaseController
 * @since 2020-03-24
 */
@Controller
@RequestMapping("common")
public class CommonController extends BaseController {

    @Value("${upload.dir}")
    private String filePath;

    private static final Log log = Log.get();

    @Resource
    private Producer producer;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse res) {
        try {
            String uploadDir = filePath;
            if (!FileUtil.isValidFilename(fileName)) {
                throw new MallException("文件名称(" + fileName + ")非法，不允许下载。 ");
            }

            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = uploadDir + File.separatorChar + fileName;

            res.setCharacterEncoding("utf-8");
            res.setContentType("multipart/form-data");
            res.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtil.setFileDownloadHeader(request, realFileName));
            FileUtil.writeBytes(filePath, res);
            if (delete) {
                FileUtil.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/upload")
    @ResponseBody
    public R<?> uploadFile(MultipartFile file, HttpServletRequest request) {
        try {
            // 上传文件路径
            String fileName = FileUtil.uploadFile(file, filePath);
            String requestUrl = HttpUtil.getRequestContext(request);
            String url = requestUrl + "/upload/" + fileName;
            return R.success(Map.of("url", url, "fileName", fileName));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return R.fail(e.getMessage(), null);
        }
    }

    /**
     * 通用captcha请求
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse res) {
        try (ServletOutputStream out = res.getOutputStream()) {
            res.setDateHeader("Expires", 0);
            res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            res.addHeader("Cache-Control", "post-check=0, pre-check=0");
            res.setHeader("Pragma", "no-cache");
            res.setContentType("image/jpeg");

            String capText = producer.createText();
            HttpSession session = request.getSession();
            //将验证码存入shiro 登录用户的session
            session.setAttribute(Constants.MALL_VERIFY_CODE_KEY, capText);
            BufferedImage image = producer.createImage(capText);
            ImageIO.write(image, "jpg", out);
            out.flush();
        } catch (IOException e) {
            log.error("验证码生成失败", e);
        }
    }
}
