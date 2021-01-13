package cn.az.project.shop.core.storage;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author az
 * @since 09/16/20
 */
public interface StorageService {

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param keyName       文件名
     */
    void store(InputStream inputStream, long contentLength, String contentType, String keyName);

    /**
     * 加载所有资源
     *
     * @return 资源
     */
    Stream<Path> loadAll();

    /**
     * 加载指定资源
     *
     * @param keyName keyName
     * @return 路径
     */
    Path load(String keyName);

    /**
     * 以资源载入
     *
     * @param keyName keyName
     * @return 资源
     */
    Resource loadAsResource(String keyName);

    /**
     * 删除资源
     *
     * @param keyName 删除
     */
    void delete(String keyName);

    /**
     * 生成URL
     *
     * @param keyName keyName
     * @return URL
     */
    String generateUrl(String keyName);

}
