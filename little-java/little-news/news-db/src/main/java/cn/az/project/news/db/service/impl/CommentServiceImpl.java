package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.entity.Comment;
import cn.az.project.news.db.mapper.CommentMapper;
import cn.az.project.news.db.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
