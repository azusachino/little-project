# little-docker

## some docker practices

* docker-boot 2020.01.04

执行 mvn clean package docker:build, 需在maven的conf/setting.xml中加入以下配置

```xml
<pluginGroups>  
    <pluginGroup>com.spotify</pluginGroup>  
</pluginGroups>
```
