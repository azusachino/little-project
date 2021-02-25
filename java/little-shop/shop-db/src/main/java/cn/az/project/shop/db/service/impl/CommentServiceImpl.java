package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Comment;
import cn.az.project.shop.db.mapper.CommentMapper;
import cn.az.project.shop.db.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
