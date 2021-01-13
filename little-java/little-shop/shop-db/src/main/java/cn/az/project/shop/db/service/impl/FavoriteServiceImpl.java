package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Favorite;
import cn.az.project.shop.db.mapper.FavoriteMapper;
import cn.az.project.shop.db.service.IFavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements IFavoriteService {

}
