package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Issue;
import cn.az.project.shop.db.mapper.IssueMapper;
import cn.az.project.shop.db.service.IIssueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IIssueService {

}
