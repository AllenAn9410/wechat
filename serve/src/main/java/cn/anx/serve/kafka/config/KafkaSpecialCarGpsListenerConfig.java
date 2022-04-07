 package cn.anx.serve.kafka.config;

 import org.apache.kafka.clients.consumer.ConsumerConfig;
 import org.apache.kafka.clients.producer.ProducerConfig;
 import org.apache.kafka.common.serialization.StringDeserializer;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.kafka.annotation.EnableKafka;
 import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
 import org.springframework.kafka.config.KafkaListenerContainerFactory;
 import org.springframework.kafka.core.ConsumerFactory;
 import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
 import org.springframework.kafka.core.DefaultKafkaProducerFactory;
 import org.springframework.kafka.core.KafkaTemplate;
 import org.springframework.kafka.core.ProducerFactory;
 import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
 import org.springframework.kafka.listener.ContainerProperties;

 import java.util.HashMap;
 import java.util.Map;

 /**
  * 实验室 特殊车辆gps kafka.
  * @author 安鑫(anx @ microvideo.cn)
  * @since 2022/03/03 11:00
  */
 @EnableKafka
 @Configuration
 public class KafkaSpecialCarGpsListenerConfig {

     @Value("${spring.kafka.special-car-gps.bootstrap-servers}")
     private String bootstrapServers;

     @Value("${spring.kafka.special-car-gps.consumer.group-id}")
     private String groupId;

     @Value("${spring.kafka.special-car-gps.consumer.enable-auto-commit}")
     private boolean enableAutoCommit;


     /**
      * 提供一个kafka生产者工厂.
      * @return KafkaTemplate
      */
     @Bean
     public KafkaTemplate<String, String> kafkaSpecialCarGpsProducerFactory() {
         return new KafkaTemplate<>(producerFactory());
     }

     /**
      * 获取kafka监听者容器工厂.
      * @return KafkaListenerContainerFactory
      */
     @Bean
     KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> kafkaSpecialCarGpsConsumerFactory() {
         ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
         factory.setConsumerFactory(consumerFactory());
         /* 配置并发消费 与topic分区有关 如果没有分区则不需要配置并发消费没有意义 */
         factory.setConcurrency(1);
         factory.getContainerProperties().setPollTimeout(3000);
         factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
         return factory;
     }

     /**
      * 配置生产者工厂.
      * @return ProducerFactory
      */
     private ProducerFactory<String, String> producerFactory() {
         return new DefaultKafkaProducerFactory<>(producerConfigs());
     }

     /**
      * 配置消费者工厂.
      * @return ConsumerFactory
      */
     public ConsumerFactory<Integer, String> consumerFactory() {
         return new DefaultKafkaConsumerFactory<>(consumerConfigs());
     }

     private Map<String, Object> producerConfigs() {
         Map<String, Object> props = new HashMap<>();
         props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
         props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         return props;
     }

     private Map<String, Object> consumerConfigs() {
         Map<String, Object> props = new HashMap<>();
         /* 配置服务器 */
         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
         /* 配置kafka组名称 */
         props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
         /* 配置是否自动提交偏移量 */
         props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
         /* 配置消费者接收key值类型 */
         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         /* 配置消费者接收value值类型 */
         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         return props;
     }
 }
