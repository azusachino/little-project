package cn.az.project.mq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author az
 * @since 2020-04-15
 */
public class MyProducer {

    public static void main(String[] args) {
        MQProducer producer = new DefaultMQProducer("");

        try {
            producer.send(new Message("mq-topic", "hello".getBytes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            producer.shutdown();
        }

    }
}
