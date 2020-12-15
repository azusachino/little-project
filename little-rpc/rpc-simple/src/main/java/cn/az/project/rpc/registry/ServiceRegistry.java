package cn.az.project.rpc.registry;

import java.net.InetSocketAddress;

/**
 * @author az
 * @since 12/09/20 22:56
 */
public interface ServiceRegistry {

    /**
     * register service
     *
     * @param rpcServiceName    rpc service name
     * @param inetSocketAddress service address
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);
}
