package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Knowledge;
import cn.az.project.test.system.mapper.KnowledgeMapper;
import cn.az.project.test.system.service.IKnowledgeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service("IKnowledgeService")
public class KnowledgeServiceImpl extends ServiceImpl<KnowledgeMapper, Knowledge> implements IKnowledgeService {

}
