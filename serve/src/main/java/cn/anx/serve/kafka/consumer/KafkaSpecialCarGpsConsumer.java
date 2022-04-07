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
public class KafkaSpecialCarGpsConsumer {

    final String TOPIC = "microvideo_tpod_gps_topic";

    @KafkaListener(topics = {TOPIC}, containerFactory = "kafkaSpecialCarGpsConsumerFactory")
    public void listenerSpecialCarGps(final ConsumerRecord<String, String> record, final Acknowledgment ack) {
        log.info(" kafka listenerSpecialCarGps 接收到消息：{}", record.value());
        ack.acknowledge();
    }
}
