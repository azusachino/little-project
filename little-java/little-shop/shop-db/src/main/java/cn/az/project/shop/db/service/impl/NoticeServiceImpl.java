package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Notice;
import cn.az.project.shop.db.mapper.NoticeMapper;
import cn.az.project.shop.db.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
