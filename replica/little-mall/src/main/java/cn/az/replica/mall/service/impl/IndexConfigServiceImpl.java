package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.entity.IndexConfig;
import cn.az.replica.mall.enums.IndexConfigType;
import cn.az.replica.mall.mapper.IndexConfigMapper;
import cn.az.replica.mall.service.IGoodsInfoService;
import cn.az.replica.mall.service.IndexConfigService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author az
 */
@Service
public class IndexConfigServiceImpl extends ServiceImpl<IndexConfigMapper, IndexConfig> implements IndexConfigService {

    @Resource
    private IGoodsInfoService goodsInfoService;

    @Override
    public List<IndexConfig> selectPage(Page<IndexConfig> page) {
        return baseMapper.selectPage(page, Wrappers.emptyWrapper()).getRecords();
    }

    @Override
    public List<GoodsInfo> listIndexConfig(IndexConfigType type, int limit) {
        List<IndexConfig> list = list(Wrappers.<IndexConfig>query()
                .eq("config_type", type.getType())
                .last("limit" + limit)
                .orderByDesc("config_rank"));
        List<Long> ids = list.stream().map(IndexConfig::getGoodsId).collect(Collectors.toList());
        return goodsInfoService.listByIds(ids);
    }
}
