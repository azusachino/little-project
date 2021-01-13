package cn.az.project.mapper.second;

import cn.az.project.entity.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author az
 * @since 11/17/20
 */
@Repository("secondDemoMapper")
public interface DemoMapper extends BaseMapper<Demo> {

}
