package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Log;
import cn.az.project.shop.db.mapper.LogMapper;
import cn.az.project.shop.db.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
