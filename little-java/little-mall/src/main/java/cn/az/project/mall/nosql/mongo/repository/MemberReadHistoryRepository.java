package cn.az.project.mall.nosql.mongo.repository;

import cn.az.project.mall.nosql.mongo.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface Member read history repository.
 *
 * @author Liz
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     *
     * @param memberId 会员id
     * @return the list
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
