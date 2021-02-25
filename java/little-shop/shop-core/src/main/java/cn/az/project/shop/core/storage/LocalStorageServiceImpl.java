package cn.az.project.shop.core.storage;

import cn.az.project.shop.core.storage.config.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * @author az
 * @since 09/16/20
 */
@Service
//@ConditionalOnProperty(prefix = "cn.az.storage.active", value = "local")
public class LocalStorageServiceImpl implements StorageService {

    private String address;
    private Path rootLocation;

    @Autowired
    private StorageProperties properties;

    @PostConstruct
    public void init() {
        String storagePath = properties.getLocal().getStoragePath();
        this.address = properties.getLocal().getAddress();
        this.rootLocation = Paths.get(storagePath);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException ignored) {
        }
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param keyName       文件名
     */
    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        try {
            Files.copy(inputStream, rootLocation.resolve(keyName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + keyName, e);
        }
    }

    /**
     * 加载所有资源
     *
     * @return 资源
     */
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(rootLocation, 1)
                    .filter(path -> !path.equals(rootLocation))
                    .map(path -> rootLocation.relativize(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files", e);
        }
    }

    /**
     * 加载指定资源
     *
     * @param keyName keyName
     * @return 路径
     */
    @Override
    public Path load(String keyName) {
        return rootLocation.resolve(keyName);
    }

    /**
     * 以资源载入
     *
     * @param keyName keyName
     * @return 资源
     */
    @Override
    public Resource loadAsResource(String keyName) {
        try {
            Path file = load(keyName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /**
     * 删除资源
     *
     * @param keyName 删除
     */
    @Override
    public void delete(String keyName) {
        Path file = load(keyName);
        try {
            Files.delete(file);
        } catch (IOException ignored) {
        }
    }

    /**
     * 生成URL
     *
     * @param keyName keyName
     * @return URL
     */
    @Override
    public String generateUrl(String keyName) {
        return address + keyName;
    }
}
