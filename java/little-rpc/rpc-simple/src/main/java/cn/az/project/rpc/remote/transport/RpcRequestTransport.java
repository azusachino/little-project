package cn.az.project.rpc.remote.transport;

import cn.az.project.rpc.extension.SPI;
import cn.az.project.rpc.remote.dto.RpcRequest;

/**
 * @author az
 * @since 12/09/20 22:53
 */
@SPI
public interface RpcRequestTransport {

    /**
     * send rpc request to server and get result
     *
     * @param rpcRequest message body
     * @return data from server
     */
    Object sendRpcRequest(RpcRequest rpcRequest);

}
