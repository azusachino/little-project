package cn.az.project.shop.core.task;

import cn.hutool.core.thread.ExecutorBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;

/**
 * @author Liz
 * @date 1/18/2020
 */
@Component
public class TaskService {

    private final DelayQueue<Task> delayQueue = new DelayQueue<>();

    @PostConstruct
    private void init() {
        TaskService taskService = this;
        ExecutorService service = ExecutorBuilder.create().build();
        service.execute(() -> {
            while (true) {
                try {
                    Task task = delayQueue.take();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addTask(Task task) {
        if (!delayQueue.contains(task)) {
            delayQueue.add(task);
        }
    }

    public void removeTask(Task task) {
        delayQueue.remove(task);
    }
}
