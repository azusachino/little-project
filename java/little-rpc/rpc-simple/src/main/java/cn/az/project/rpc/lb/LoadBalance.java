package cn.az.project.rpc.lb;

import cn.az.project.rpc.extension.SPI;

import java.util.List;

/**
 * @author az
 * @since 12/09/20 23:06
 */
@SPI
public interface LoadBalance {

    /**
     * Choose one from the list of existing service addresses list
     *
     * @param serviceAddresses Service address list
     * @return target service address
     */
    String selectServiceAddress(List<String> serviceAddresses, String rpcServiceName);
}
