package cn.az.project.shop.core.storage;

import cn.az.project.shop.db.entity.Storage;
import cn.az.project.shop.db.service.IStorageService;
import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 物流服务委派类
 *
 * @author az
 * @since 09/16/20
 */
@Service
public class StorageServiceDelegate {

    private StorageService storageService;
    private IStorageService dbStorageService;

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    public void setDbStorageService(IStorageService dbStorageService) {
        this.dbStorageService = dbStorageService;
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public Storage store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = generateKey(fileName);
        storageService.store(inputStream, contentLength, contentType, key);

        String url = generateUrl(key);
        Storage storageInfo = new Storage();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setType(contentType);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        dbStorageService.save(storageInfo);

        return storageInfo;
    }

    private String generateKey(String originalFileName) {
        int index = originalFileName.lastIndexOf('.');
        String suffix = originalFileName.substring(index);

        String key;
        Storage storageInfo;

        do {
            key = RandomUtil.randomString(20) + suffix;
            storageInfo = dbStorageService.getById(key);
        }
        while (storageInfo != null);

        return key;
    }

    public Stream<Path> loadAll() {
        return storageService.loadAll();
    }

    public Path load(String keyName) {
        return storageService.load(keyName);
    }

    public Resource loadAsResource(String keyName) {
        return storageService.loadAsResource(keyName);
    }

    public void delete(String keyName) {
        storageService.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storageService.generateUrl(keyName);
    }
}
