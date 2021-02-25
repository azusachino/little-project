package cn.az.project.service.impl;

import cn.az.project.entity.Demo;
import cn.az.project.mapper.second.DemoMapper;
import cn.az.project.service.IDemoService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author az
 * @since 11/18/20
 */
@Service("secondDemoService")
public class SecondDemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

    @Override
    public List<Demo> getSecond() {
        return baseMapper.selectList(Wrappers.emptyWrapper());
    }

}