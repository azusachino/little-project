package cn.az.project.test.common.service.impl;

import cn.az.project.test.common.constant.Setting;
import cn.az.project.test.common.service.CacheService;
import cn.az.project.test.common.service.RedisService;
import cn.az.project.test.system.domain.Code;
import cn.az.project.test.system.entity.Permission;
import cn.az.project.test.system.entity.Role;
import cn.az.project.test.system.entity.User;
import cn.az.project.test.system.service.ICodeService;
import cn.az.project.test.system.service.IPermissionService;
import cn.az.project.test.system.service.IRoleService;
import cn.az.project.test.system.service.IUserService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Cache service.
 *
 * @author Liz
 */
@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    @Resource
    private RedisService redisService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IPermissionService permissionService;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private IUserService userService;
    @Resource
    private ICodeService codeService;

    /**
     * 测试 Redis是否连接成功
     */
    @Override
    public void testConnect() {
        redisService.exists("test");
    }

    /**
     * Gets user.
     *
     * @param loginId the loginId
     * @return the user
     */
    @Override
    public User getUser(String loginId) throws Exception {
        String userString = redisService.get(Setting.USER_CACHE_PREFIX + loginId);
        if (StringUtils.isBlank(userString)) {
            throw new Exception("缓存中还没有登录信息");
        } else {
            return this.objectMapper.readValue(userString, User.class);
        }
    }

    /**
     * 从缓存中获取用户角色
     *
     * @param loginId the login id
     * @return 角色集 roles
     * @throws Exception the exception
     */
    @Override
    public List<Role> getRoles(String loginId) throws Exception {
        String roleListString = this.redisService.get(Setting.USER_ROLE_CACHE_PREFIX + loginId);
        if (StringUtils.isBlank(roleListString)) {
            throw new Exception("缓存中还没有登录信息");
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Role.class);
            return this.objectMapper.readValue(roleListString, type);
        }
    }

    /**
     * 从缓存中获取用户权限
     *
     * @param loginId the login id
     * @return 权限集 permissions
     * @throws Exception the exception
     */
    @Override
    public List<Permission> getPermissions(String loginId) throws Exception {
        String permissionListString = redisService.get(Setting.USER_PERMISSION_CACHE_PREFIX + loginId);
        if (StringUtils.isBlank(permissionListString)) {
            throw new Exception("缓存中还没有登录信息");
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Permission.class);
            return this.objectMapper.readValue(permissionListString, type);
        }
    }

    /**
     * Get types.
     *
     * @return the types
     * @throws Exception the exception
     */
    @Override
    public List<Code> getTypes() throws Exception {
        String typeListString = redisService.get(Setting.CODE_PREFIX + Setting.TYPE);
        if (StringUtils.isBlank(typeListString)) {
            throw new Exception("缓存中还没有登录信息");
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Code.class);
            return objectMapper.readValue(typeListString, type);
        }
    }

    /**
     * Gets grades.
     *
     * @return the grades
     * @throws Exception the exception
     */
    @Override
    public List<Code> getGrades() throws Exception {
        String gradeListString = redisService.get(Setting.CODE_PREFIX + Setting.GRADE);
        if (StringUtils.isBlank(gradeListString)) {
            throw new Exception("缓存中还没有登录信息");
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Code.class);
            return objectMapper.readValue(gradeListString, type);
        }
    }

    /**
     * Get subjects.
     *
     * @return the subjects
     * @throws Exception the exception
     */
    @Override
    public List<Code> getSubjects() throws Exception {
        String subjectListString = redisService.get(Setting.CODE_PREFIX + Setting.SUBJECT);
        if (StringUtils.isBlank(subjectListString)) {
            throw new Exception("缓存中还没有登录信息");
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Code.class);
            return objectMapper.readValue(subjectListString, type);
        }
    }

    /**
     * 缓存用户信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    @Override
    public void saveUser(String loginId) throws Exception {
        User user = userService.findByLoginId(loginId);
        deleteUser(loginId);
        redisService.set(Setting.USER_CACHE_PREFIX + loginId, objectMapper.writeValueAsString(user));
    }

    /**
     * 缓存用户角色信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    @Override
    public void saveRoles(String loginId) throws Exception {
        List<Role> roleList = roleService.getUserRoles(loginId);
        if (!roleList.isEmpty()) {
            this.deleteRoles(loginId);
            redisService.set(Setting.USER_ROLE_CACHE_PREFIX + loginId, objectMapper.writeValueAsString(roleList));
        }
    }

    /**
     * 缓存用户权限信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    @Override
    public void savePermissions(String loginId) throws Exception {
        List<Permission> permissionList = permissionService.getUserPermissions(loginId);
        if (!permissionList.isEmpty()) {
            this.deletePermissions(loginId);
            redisService.set(Setting.USER_PERMISSION_CACHE_PREFIX + loginId, objectMapper.writeValueAsString(permissionList));
        }
    }

    @Override
    public void saveTypes() throws Exception {
        List<Code> typeList = codeService.getTypes();
        if (!typeList.isEmpty()) {
            deleteTypes();
            redisService.set(Setting.CODE_PREFIX + Setting.TYPE, objectMapper.writeValueAsString(typeList));
        }
    }

    /**
     * Save grades.
     *
     * @throws Exception the exception
     */
    @Override
    public void saveGrades() throws Exception {
        List<Code> gradeList = codeService.getGrades();
        if (!gradeList.isEmpty()) {
            deleteSubjects();
            redisService.set(Setting.CODE_PREFIX + Setting.GRADE, objectMapper.writeValueAsString(gradeList));
        }
    }

    @Override
    public void saveSubjects() throws Exception {
        List<Code> subjectList = codeService.getSubjects();
        if (!subjectList.isEmpty()) {
            deleteSubjects();
            redisService.set(Setting.CODE_PREFIX + Setting.SUBJECT, objectMapper.writeValueAsString(subjectList));
        }
    }

    /**
     * 删除用户信息
     *
     * @param loginId 用户名
     */
    @Override
    public void deleteUser(String loginId) {
        redisService.del(Setting.USER_CACHE_PREFIX + loginId);
    }

    /**
     * 删除用户角色信息
     *
     * @param loginId 用户名
     */
    @Override
    public void deleteRoles(String loginId) {
        redisService.del(Setting.USER_ROLE_CACHE_PREFIX + loginId);
    }

    /**
     * 删除用户权限信息
     *
     * @param loginId 用户名
     */
    @Override
    public void deletePermissions(String loginId) {
        redisService.del(Setting.USER_PERMISSION_CACHE_PREFIX + loginId);
    }

    @Override
    public void deleteTypes() {
        redisService.del(Setting.CODE_PREFIX + Setting.TYPE);
    }

    @Override
    public void deleteGrades() {
        redisService.del(Setting.CODE_PREFIX + Setting.GRADE);
    }

    @Override
    public void deleteSubjects() {
        redisService.del(Setting.CODE_PREFIX + Setting.SUBJECT);
    }
}
