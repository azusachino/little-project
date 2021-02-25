package cn.az.project.test.system.manager;

import cn.az.project.test.common.service.CacheService;
import cn.az.project.test.common.utils.CommonUtil;
import cn.az.project.test.system.domain.Code;
import cn.az.project.test.system.service.ICodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liz
 */
@Service("codeManager")
public class CodeManager {

    @Resource
    private CacheService cacheService;

    @Resource
    private ICodeService codeService;

    public List<Code> getTypes() {
        return CommonUtil.selectCacheByTemplate(
            () -> cacheService.getTypes(),
            () -> codeService.getTypes()
        );
    }

    public List<Code> getSubjects() {
        return CommonUtil.selectCacheByTemplate(
            () -> cacheService.getSubjects(),
            () -> codeService.getSubjects()
        );
    }

    public List<Code> getGrades() {
        return CommonUtil.selectCacheByTemplate(
            () -> cacheService.getGrades(),
            () -> codeService.getGrades()
        );
    }

    public void saveCodeRedisCache() throws Exception {
        cacheService.saveTypes();
        cacheService.saveSubjects();
        cacheService.saveGrades();
    }
}
