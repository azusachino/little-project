package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Cart;
import cn.az.project.shop.db.mapper.CartMapper;
import cn.az.project.shop.db.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
