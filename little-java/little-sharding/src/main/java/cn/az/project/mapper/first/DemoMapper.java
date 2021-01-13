package cn.az.project.mapper.first;

import cn.az.project.entity.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author az
 * @since 11/17/20
 */
@Repository("firstDemoMapper")
public interface DemoMapper extends BaseMapper<Demo> {

}
