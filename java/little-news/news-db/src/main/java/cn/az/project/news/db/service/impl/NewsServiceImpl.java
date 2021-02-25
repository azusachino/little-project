package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.entity.News;
import cn.az.project.news.db.mapper.NewsMapper;
import cn.az.project.news.db.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * The type News service.
 *
 * @author Liz
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
