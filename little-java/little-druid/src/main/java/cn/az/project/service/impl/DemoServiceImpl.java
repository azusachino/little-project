package cn.az.project.service.impl;

import cn.az.project.annotation.DataSource;
import cn.az.project.common.DataSourceType;
import cn.az.project.entity.Demo;
import cn.az.project.mapper.DemoMapper;
import cn.az.project.service.IDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author az
 * @since 11/17/20
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

    @Override
    @DataSource(type = DataSourceType.FIRST)
    public List<Demo> getFirst() {
        return list();
    }

    @Override
    @DataSource(type = DataSourceType.SECOND)
    public List<Demo> getSecond() {
        return list();
    }
}
