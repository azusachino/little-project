package cn.az.project.news.admin.service.impl;

import cn.az.project.news.admin.service.ILogService;
import cn.az.project.news.core.annotation.Log4j;
import cn.az.project.news.core.utils.AddressUtil;
import cn.az.project.news.db.entity.Log;
import cn.az.project.news.db.mapper.LogMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Liz
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * Find logs page.
     *
     * @param page  the page
     * @param param the param
     * @param qw Wrapper
     * @return the page
     */
    @Override
    public IPage<Log> findLogs(Wrapper<Log> qw) {
        try {
            QueryWrapper<Log> queryWrapper = Wrappers.query();
/*
            if (StringUtils.isNotBlank(qw..getUsername())) {
                queryWrapper.lambda().eq(Log::getUsername, param.getUsername().toLowerCase());
            }
            if (StringUtils.isNotBlank(param.getOperation())) {
                queryWrapper.lambda().like(Log::getOperation, param.getOperation());
            }
            if (StringUtils.isNotBlank(param.getLocation())) {
                queryWrapper.lambda().like(Log::getLocation, param.getLocation());
            }
            if (StringUtils.isNotBlank(param.getCreateTimeFrom()) && StringUtils.isNotBlank(param.getCreateTimeTo())) {
                queryWrapper.lambda()
                        .ge(Log::getCreateTime, param.getCreateTimeFrom())
                        .le(Log::getCreateTime, param.getCreateTimeTo());
            }

            Page<Log> page = new Page<>(param.getPageNo(), param.getPageSize());*/
            queryWrapper.orderByAsc("CREATE_TIME");

            return page(new Page<>(1,2), queryWrapper);
        } catch (Exception e) {
            log.error("获取系统日志失败", e);
            return null;
        }
    }

    /**
     * Delete logs.
     *
     * @param logIds the log ids
     */
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void deleteLogs(String[] logIds) {
        baseMapper.deleteBatchIds(Arrays.asList(logIds));
    }

    /**
     * Save log.
     *
     * @param point the point
     * @param log   the log
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLog(ProceedingJoinPoint joinPoint, Log log) throws JsonProcessingException {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log4j logAnnotation = method.getAnnotation(Log4j.class);
        if (logAnnotation != null) {
            // 注解上的描述
            log.setOperation(logAnnotation.value());
        }
        // 请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            log.setParams(params.toString());
        }
        log.setLocation(AddressUtil.getCityInfo(log.getIp()));
        log.setCreateTime(LocalDateTime.now());
        save(log);
    }

    private StringBuilder handleParams(StringBuilder params, Object[] args, List<?> paramNames) throws JsonProcessingException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Map) {
                Set<?> set = ((Map<?, ?>) args[i]).keySet();
                List<Object> list = new ArrayList<>();
                List<Object> paramList = new ArrayList<>();
                for (Object key : set) {
                    list.add(((Map<?, ?>) args[i]).get(key));
                    paramList.add(key);
                }
                return handleParams(params, list.toArray(), paramList);
            } else {
                if (args[i] instanceof Serializable) {
                    Class<?> aClass = args[i].getClass();
                    try {
                        aClass.getDeclaredMethod("toString", new Class[]{null});
                        // 如果不抛出 NoSuchMethodException 异常则存在 toString 方法 ，安全的 writeValueAsString ，否则 走 Object的 toString方法
                        params.append(" ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        params.append(" ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
                    }
                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    params.append(" ").append(paramNames.get(i)).append(": ").append(file.getName());
                } else {
                    params.append(" ").append(paramNames.get(i)).append(": ").append(args[i]);
                }
            }
        }
        return params;
    }
}
