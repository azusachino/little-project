package cn.az.project.test.common.service;

import cn.az.project.test.system.domain.Code;
import cn.az.project.test.system.entity.Permission;
import cn.az.project.test.system.entity.Role;
import cn.az.project.test.system.entity.User;

import java.util.List;

/**
 * The interface Cache service.
 *
 * @author Liz
 */
public interface CacheService {

    /**
     * 测试 Redis是否连接成功
     *
     * @throws Exception the exception
     */
    void testConnect() throws Exception;

    /**
     * Gets user.
     *
     * @param loginId the login id
     * @return the user
     * @throws Exception the exception
     */
    User getUser(String loginId) throws Exception;

    /**
     * 从缓存中获取用户角色
     *
     * @param loginId the login id
     * @return 角色集 roles
     * @throws Exception the exception
     */
    List<Role> getRoles(String loginId) throws Exception;

    /**
     * 从缓存中获取用户权限
     *
     * @param loginId the login id
     * @return 权限集 permissions
     * @throws Exception the exception
     */
    List<Permission> getPermissions(String loginId) throws Exception;

    /**
     * Gets types.
     *
     * @return the types
     * @throws Exception the exception
     */
    List<Code> getTypes() throws Exception;

    /**
     * Gets grades.
     *
     * @return the grades
     * @throws Exception the exception
     */
    List<Code> getGrades() throws Exception;

    /**
     * Gets subjects.
     *
     * @return the subjects
     * @throws Exception the exception
     */
    List<Code> getSubjects() throws Exception;

    /**
     * 缓存用户信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    void saveUser(String loginId) throws Exception;

    /**
     * 缓存用户角色信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    void saveRoles(String loginId) throws Exception;

    /**
     * 缓存用户权限信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    void savePermissions(String loginId) throws Exception;

    /**
     * Save types.
     *
     * @throws Exception the exception
     */
    void saveTypes() throws Exception;

    /**
     * Save grades.
     *
     * @throws Exception the exception
     */
    void saveGrades() throws Exception;

    /**
     * Save subjects.
     *
     * @throws Exception the exception
     */
    void saveSubjects() throws Exception;


    /**
     * 删除用户信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    void deleteUser(String loginId) throws Exception;

    /**
     * 删除用户角色信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    void deleteRoles(String loginId) throws Exception;

    /**
     * 删除用户权限信息
     *
     * @param loginId 用户名
     * @throws Exception the exception
     */
    void deletePermissions(String loginId) throws Exception;

    /**
     * Delete types.
     *
     * @throws Exception the exception
     */
    void deleteTypes() throws Exception;

    /**
     * Delete grades.
     *
     * @throws Exception the exception
     */
    void deleteGrades() throws Exception;

    /**
     * Delete subjects.
     *
     * @throws Exception the exception
     */
    void deleteSubjects() throws Exception;
}
