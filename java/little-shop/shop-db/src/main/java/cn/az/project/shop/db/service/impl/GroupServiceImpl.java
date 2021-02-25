package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Group;
import cn.az.project.shop.db.mapper.GroupMapper;
import cn.az.project.shop.db.service.IGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

}
