package cn.az.project.service;

import cn.az.project.entity.Demo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collections;
import java.util.List;

/**
 * @author az
 * @since 11/18/20
 */
public interface IDemoService extends IService<Demo> {

    default List<Demo> getFirst() {
        return Collections.emptyList();
    }

    default List<Demo> getSecond() {
        return Collections.emptyList();
    }

}
