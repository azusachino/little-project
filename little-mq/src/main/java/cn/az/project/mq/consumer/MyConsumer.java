package cn.az.project.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MQConsumer;
import org.apache.rocketmq.client.consumer.MQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.Set;

/**
 * @author az
 * @since 2020-04-15
 */
public class MyConsumer {

    public static void main(String[] args) throws MQClientException {
        MQPushConsumer consumer = new DefaultMQPushConsumer();

        try {
            Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues("mq-topic");
            messageQueues.forEach(mq -> {
                System.out.println(mq.getBrokerName());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        consumer.start();
    }
}
