package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.ProductCollection;
import cn.az.project.shop.db.mapper.CollectionMapper;
import cn.az.project.shop.db.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, ProductCollection> implements ICollectionService {

}
