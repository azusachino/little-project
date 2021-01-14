package cn.az.replica.mall.service;

import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.entity.IndexConfig;
import cn.az.replica.mall.enums.IndexConfigType;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author az
 */
public interface IndexConfigService extends IService<IndexConfig> {

    List<IndexConfig> selectPage(Page<IndexConfig> page);

    List<GoodsInfo> listIndexConfig(IndexConfigType type, int limit);
}
