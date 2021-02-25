package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.SearchHistory;
import cn.az.project.shop.db.mapper.SearchHistoryMapper;
import cn.az.project.shop.db.service.ISearchHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class SearchHistoryServiceImpl extends ServiceImpl<SearchHistoryMapper, SearchHistory> implements ISearchHistoryService {

}
