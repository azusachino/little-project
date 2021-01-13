package cn.az.project.rpc.lb.loadbalancer;

import cn.az.project.rpc.lb.AbstractLoadBalance;
import cn.hutool.core.util.RandomUtil;

import java.util.List;

/**
 * @author az
 * @since 12/09/20 23:07
 */
public class RandomLoadBalancer extends AbstractLoadBalance {

    @Override
    protected String doSelect(List<String> serviceAddresses, String rpcServiceName) {
        return serviceAddresses.get(RandomUtil.randomInt(serviceAddresses.size()));
    }
}
