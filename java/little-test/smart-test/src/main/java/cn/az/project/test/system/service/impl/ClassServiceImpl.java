package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Class;
import cn.az.project.test.system.mapper.ClassMapper;
import cn.az.project.test.system.service.IClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements IClassService {

}
