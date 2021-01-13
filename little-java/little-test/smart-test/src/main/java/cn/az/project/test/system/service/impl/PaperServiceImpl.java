package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Paper;
import cn.az.project.test.system.mapper.PaperMapper;
import cn.az.project.test.system.service.IPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service("paperService")
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements IPaperService {

}
