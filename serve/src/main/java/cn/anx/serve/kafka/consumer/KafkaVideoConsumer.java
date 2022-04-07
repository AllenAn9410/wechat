package cn.anx.serve.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

/**
 * @author 安鑫(anx @ microvideo.cn)
 * @since 2022/03/03 11:49
 */
//@Component
@Slf4j
public class KafkaVideoConsumer {

    final String TOPIC = "test_kafka_topic_2";

    @KafkaListener(topics = {TOPIC}, containerFactory = "kafkaVideoConsumerFactory")
    public void listenerQingYun(final ConsumerRecord<String, String> record, final Acknowledgment ack) {
        log.info(" kafka listenerQingYun 接收到消息:{}", record.value());
        ack.acknowledge();
    }
}
