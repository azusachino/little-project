package cn.az.project.mall.service;

import cn.az.project.mall.nosql.mongo.document.MemberReadHistory;

import java.util.List;

/**
 * The interface Member read history service.
 *
 * @author Liz
 */
public interface IMemberReadHistoryService {
    /**
     * 生成浏览记录
     *
     * @param memberReadHistory the member read history
     * @return the int
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     *
     * @param ids the ids
     * @return the int
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     *
     * @param memberId the member id
     * @return the list
     */
    List<MemberReadHistory> list(Long memberId);
}
