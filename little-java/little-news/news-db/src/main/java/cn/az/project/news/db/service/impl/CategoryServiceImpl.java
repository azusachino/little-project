package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.entity.Category;
import cn.az.project.news.db.mapper.CategoryMapper;
import cn.az.project.news.db.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
