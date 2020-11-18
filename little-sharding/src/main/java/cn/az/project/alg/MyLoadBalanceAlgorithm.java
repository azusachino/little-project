package cn.az.project.alg;

import io.shardingsphere.api.algorithm.masterslave.MasterSlaveLoadBalanceAlgorithm;

import java.util.List;

/**
 * @author az
 * @since 11/18/20
 */
public class MyLoadBalanceAlgorithm implements MasterSlaveLoadBalanceAlgorithm {

    /**
     * Get data source.
     *
     * @param name                 master-slave logic data source name
     * @param masterDataSourceName name of master data sources
     * @param slaveDataSourceNames names of slave data sources
     * @return name of selected data source
     */
    @Override
    public String getDataSource(String name, String masterDataSourceName, List<String> slaveDataSourceNames) {
        return null;
    }
}
