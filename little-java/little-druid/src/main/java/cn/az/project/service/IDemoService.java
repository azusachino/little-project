package cn.az.project.service;

import cn.az.project.entity.Demo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author az
 * @since 11/17/20
 */
public interface IDemoService extends IService<Demo> {

    List<Demo> getFirst();


    List<Demo> getSecond();
}
