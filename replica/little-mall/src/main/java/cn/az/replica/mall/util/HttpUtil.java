package cn.az.replica.mall.util;

import cn.hutool.log.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * HttpUtil
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see cn.az.replica.mall.util
 * @since 2020-03-24
 */
public class HttpUtil {

    private HttpUtil() {
        throw new Error("not allowed");
    }

    private static final Log log = Log.get();

    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    /**
     * 获取当前项目路径，<br>
     *
     * @param request HttpServletRequest
     * @return {@link HttpServletRequest}
     */
    public static String getRequestContext(HttpServletRequest request) {
        // 请求协议 http,https
        return request.getScheme() + "://" +
                request.getHeader("host") +
                request.getContextPath();
    }

    /**
     * <p>判断请求是否为 AJAX</p>
     *
     * @param request 当前请求
     */
    public static boolean isAjax(HttpServletRequest request) {
        return XML_HTTP_REQUEST.equals(request.getHeader("X-Requested-With"));
    }

    /**
     * <p>
     * AJAX 设置 response 返回状态
     * </p>
     *
     * @param res HttpServletResponse
     * @param status   HTTP 状态码
     * @param tip      tip
     */
    public static void ajaxStatus(HttpServletResponse res, int status, String tip) {
        try {
            res.setContentType("text/html;charset=" + StandardCharsets.UTF_8);
            res.setStatus(status);
            PrintWriter out = res.getWriter();
            out.print(tip);
            out.flush();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * <p>
     * 获取当前 URL 包含查询条件
     * </p>
     *
     * @param request HttpServletRequest
     * @param encode  URLEncoder编码格式
     * @return QueryString
     * @throws IOException e
     */
    public static String getQueryString(HttpServletRequest request, String encode) throws IOException {
        StringBuilder sb = new StringBuilder(request.getRequestURL());
        String query = request.getQueryString();
        if (Objects.nonNull(query) && query.length() > 0) {
            sb.append("?").append(query);
        }
        return URLEncoder.encode(sb.toString(), encode);
    }

    /**
     * <p>
     * getRequestURL是否包含在URL之内
     * </p>
     *
     * @param request HttpServletRequest
     * @param url     参数为以';'分割的URL字符串
     */
    public static boolean containUrlCheck(HttpServletRequest request, String url) {
        boolean result = false;
        if (url != null && !"".equals(url.trim())) {
            String[] urlArr = url.split(";");
            StringBuilder reqUrl = new StringBuilder(request.getRequestURL());
            for (String s : urlArr) {
                if (reqUrl.indexOf(s) > 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * <p>
     * URLEncoder 返回地址
     * </p>
     *
     * @param url      跳转地址
     * @param retParam 返回地址参数名
     * @param returnUrl   返回地址
     */
    public static String encodeReturnUrl(String url, String retParam, String returnUrl) {
        return encodeRetUrl(url, retParam, returnUrl, null);
    }

    /**
     * <p>
     * URLEncoder 返回地址
     * </p>
     *
     * @param url      跳转地址
     * @param retParam 返回地址参数名
     * @param retUrl   返回地址
     * @param data     携带参数
     */
    public static String encodeRetUrl(String url, String retParam, String retUrl, Map<String, String> data) {
        if (url == null) {
            return null;
        }

        StringBuilder retStr = new StringBuilder(url);
        retStr.append("?");
        retStr.append(retParam);
        retStr.append("=");
        retStr.append(URLEncoder.encode(retUrl, StandardCharsets.UTF_8));

        if (data != null) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                retStr.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }

        return retStr.toString();
    }

    /**
     * <p>
     * URLDecoder 解码地址
     * </p>
     *
     * @param url 解码地址
     */
    public static String decodeUrl(String url) {
        if (url == null) {
            return null;
        }
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

    /**
     * <p>
     * GET 请求
     * </p>
     *
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isGet(HttpServletRequest request) {
        return "GET".equalsIgnoreCase(request.getMethod());
    }

    /**
     * <p>
     * POST 请求
     * </p>
     *
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isPost(HttpServletRequest request) {
        return "POST".equalsIgnoreCase(request.getMethod());
    }

    /**
     * <p>
     * 请求重定向至地址 location
     * </p>
     *
     * @param response 请求响应
     * @param location 重定向至地址
     */
    public static void sendRedirect(HttpServletResponse response, String location) {
        try {
            response.sendRedirect(location);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * <p>
     * 获取Request PlayLoad 内容
     * </p>
     *
     * @param request HttpServletRequest
     * @return Request PlayLoad 内容
     */
    public static String requestPlayLoad(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try (InputStream inputStream = request.getInputStream()) {
            if (Objects.nonNull(inputStream)) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * <p>
     * 获取当前完整请求地址
     * </p>
     *
     * @param request HttpServletRequest
     * @return 请求地址
     */
    public static String getRequestUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder(request.getScheme());
        // 请求协议 http,https
        url.append("://");
        // 请求服务器
        url.append(request.getHeader("host"));
        // 工程名
        url.append(request.getRequestURI());
        if (request.getQueryString() != null) {
            // 请求参数
            url.append("?").append(request.getQueryString());
        }
        return url.toString();
    }


    public static String getValueByCookie(HttpServletRequest request) {
        String value = "", token = "token";
        Cookie[] cookies = request.getCookies();
        if (Objects.nonNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (token.equals(cookie.getName())) {
                    value = cookie.getValue();
                    break;
                }
            }
        }
        return value;
    }
}
