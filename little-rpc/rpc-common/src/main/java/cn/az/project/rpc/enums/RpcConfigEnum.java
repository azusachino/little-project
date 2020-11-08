package cn.az.project.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author az
 * @since 11/08/20
 */
@Getter
@ToString
@AllArgsConstructor
public enum RpcConfigEnum {

    /**
     * RPC CONFIG PATH
     */
    RPC_CONFIG_PATH("rpc.properties"),
    /**
     * zk地址
     */
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyValue;
    
}
