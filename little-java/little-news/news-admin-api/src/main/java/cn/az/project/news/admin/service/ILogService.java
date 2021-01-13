package cn.az.project.news.admin.service;

import cn.az.project.news.db.entity.Log;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
 * The interface Log service.
 *
 * @author Liz
 */
public interface ILogService extends IService<Log> {

    /**
     * Find logs page.
     *
     * @param param the param
     * @return the page
     */
    IPage<Log> findLogs(Wrapper<Log> qw);

    /**
     * Delete logs.
     *
     * @param logIds the log ids
     */
    void deleteLogs(String[] logIds);

    /**
     * Save log.
     *
     * @param point the point
     * @param log   the log
     * @throws JsonProcessingException the json processing exception
     */
    @Async
    void saveLog(ProceedingJoinPoint point, Log log) throws JsonProcessingException;

}
