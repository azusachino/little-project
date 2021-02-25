package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Topic;
import cn.az.project.shop.db.mapper.TopicMapper;
import cn.az.project.shop.db.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

}
