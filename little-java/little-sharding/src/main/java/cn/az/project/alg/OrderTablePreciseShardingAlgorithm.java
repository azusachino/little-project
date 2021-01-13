package cn.az.project.alg;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * @author az
 * @since 11/17/20
 */
public class OrderTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        Long curValue = preciseShardingValue.getValue();
        String curTable;
        if (curValue > 0 && curValue <= 100) {
            curTable = "t_order_1";
        } else if (curValue > 100 && curValue <= 200) {
            curTable = "t_order_2";
        } else if (curValue > 200 && curValue <= 300) {
            curTable = "t_order_3";
        } else {
            curTable = "t_order_4";
        }
        return curTable;
    }
}
