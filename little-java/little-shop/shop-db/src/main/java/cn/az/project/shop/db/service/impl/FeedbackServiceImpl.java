package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Feedback;
import cn.az.project.shop.db.mapper.FeedbackMapper;
import cn.az.project.shop.db.service.IFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

}
