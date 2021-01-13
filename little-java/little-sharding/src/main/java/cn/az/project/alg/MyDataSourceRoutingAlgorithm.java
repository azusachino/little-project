package cn.az.project.alg;

import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author az
 * @since 11/18/20
 */
public class MyDataSourceRoutingAlgorithm implements HintShardingAlgorithm {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyDataSourceRoutingAlgorithm.class);

    /**
     * Sharding.
     *
     * <p>sharding value injected by hint, not in SQL.</p>
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding result for data sources or tables's names
     */
    @Override
    @SuppressWarnings("unchecked")
    public Collection<String> doSharding(Collection<String> availableTargetNames, ShardingValue shardingValue) {
        LOGGER.info("shardingValue=" + shardingValue);
        LOGGER.info("availableTargetNames=" + availableTargetNames);
        List<String> shardingResult = new ArrayList<>();
        ListShardingValue<String> tmpSharding = (ListShardingValue<String>) shardingValue;
        for (String value : tmpSharding.getValues()) {
            if (availableTargetNames.contains(value)) {
                shardingResult.add(value);
            }
        }
        return shardingResult;
    }
}
