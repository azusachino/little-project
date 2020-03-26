package cn.az.project.csv.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * @author az
 * @date 2020/3/19
 */
@Slf4j
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("process running complete!");
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
