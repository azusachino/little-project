package cn.az.project.alg;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * @author az
 * @since 11/17/20
 */
public class DatabasePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        Long curValue = preciseShardingValue.getValue();
        return (curValue > 0 && curValue < 200) ? "sale_order_01" : "sale_order_02";
    }
}
