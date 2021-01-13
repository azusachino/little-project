package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Test;
import cn.az.project.test.system.mapper.TestMapper;
import cn.az.project.test.system.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
