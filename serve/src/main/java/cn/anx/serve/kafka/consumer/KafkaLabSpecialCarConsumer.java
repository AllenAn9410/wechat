package cn.anx.serve.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


/**
 * @author 安鑫(anx @ microvideo.cn)
 * @since 2022/03/03 11:49
 */
@Component
@Slf4j
public class KafkaLabSpecialCarConsumer {

    final String TOPIC = "mvlabNBTDvehAlert";

    @KafkaListener(topics = {TOPIC}, containerFactory = "kafkaLabSpecialCarConsumerFactory")
    public void listenerLabSpecialCar(final ConsumerRecord<String, String> record, final Acknowledgment ack) {
        log.info(" kafka listenerLabSpecialCar 接收到消息：{}", record.value());
        ack.acknowledge();
    }
}
