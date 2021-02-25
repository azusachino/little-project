package cn.az.replica.mall.util;

import cn.az.replica.mall.exception.MallException;
import cn.hutool.log.Log;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文件处理工具类
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @since 2020-03-24
 */
public class FileUtil {

    private FileUtil() {
        throw new Error("not allowed");
    }

    private static final Log log = Log.get();

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    /**
     * 删除文件
     *
     * @param filePath 文件
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            if (!file.delete()) {
                log.error("file delete failed");
            }
        }
    }

    /**
     * 文件上传帮助类
     */
    public static String uploadFile(MultipartFile file, String filePath) throws IOException {
        if (Objects.isNull(file)) {
            throw new MallException("文件不存在");
        }
        int fileNameLength = Objects.requireNonNull(file.getOriginalFilename()).length();
        int fileMaxSize = 100;
        if (fileNameLength > fileMaxSize) {
            throw new MallException("文件名称过长");
        }
        String fileName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(fileName);
        if (StringUtils.isEmpty(extension)) {
            extension = MimeTypeUtils.parseMimeType(Objects.requireNonNull(file.getContentType())).getType();
        }
        String encodingFilename = encodeFileName(fileName);
        fileName = DateUtil.datePath() + "/" + encodingFilename + "." + extension;
        File desc = new File(filePath, fileName);
        if (!desc.getParentFile().exists()) {
            if (!desc.getParentFile().mkdirs()) {
                throw new MallException("文件夹 " + desc.getParentFile().getName() + " 创建失败");
            }
        }
        if (!desc.exists()) {
            if (!desc.createNewFile()) {
                throw new MallException("文件 " + desc.getName() + " 创建失败");
            }
        }
        file.transferTo(desc);
        return fileName;
    }

    /**
     * 下载文件名重新编码
     *
     * @param request  请求对象
     * @param fileName 文件名
     * @return 编码后的文件名
     */
    public static String setFileDownloadHeader(HttpServletRequest request, String fileName) {
        final String agent = request.getHeader("USER-AGENT");
        final String ie = "MSIE", firefox = "Firefox", chrome = "Chrome";
        String filename = fileName;
        if (agent.contains(ie)) {
            // IE浏览器
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            filename = filename.replace("+", " ");
        } else if (agent.contains(firefox)) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), StandardCharsets.ISO_8859_1);
        } else if (agent.contains(chrome)) {
            // google浏览器
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        }
        return filename;
    }

    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename) {
        String fileNamePattern = "[a-zA-Z0-9_\\-|.\\u4e00-\\u9fa5]+";
        return filename.matches(fileNamePattern);
    }

    /**
     * 输出指定文件的byte数组
     *
     * @param filePath 文件路径
     * @param res      输出流
     */
    public static void writeBytes(String filePath, HttpServletResponse res) {
        File file = new File(filePath);
        if (!file.exists()) {
            log.error("file is not exist");
            return;
        }
        try (FileInputStream fis = new FileInputStream(file); OutputStream os = res.getOutputStream()) {
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    public static String encodeFileName(String fileName) {
        fileName = fileName.replaceAll("_", " ");
        fileName = Md5Util.hash(fileName + System.nanoTime() + COUNTER.getAndIncrement());
        return fileName;
    }
}
