package cn.az.project.rpc.registry;

import cn.az.project.rpc.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @author az
 * @since 12/09/20 23:03
 */
@SPI
public interface ServiceDiscovery {

    /**
     * lookup service by rpcServiceName
     *
     * @param rpcServiceName rpc service name
     * @return service address
     */
    InetSocketAddress lookupService(String rpcServiceName);
}
