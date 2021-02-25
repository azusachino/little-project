package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Address;
import cn.az.project.shop.db.mapper.AddressMapper;
import cn.az.project.shop.db.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
