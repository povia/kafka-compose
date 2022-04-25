package com.tistory.povia.kafkaconsumer.configuration;

import com.tistory.povia.kafkaconsumer.event.TimeRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {
  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapServers;

  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;

  @Value("${spring.kafka.consumer.auto-offset-reset}")
  private String offsetReset;

  @Bean(name = "pushConsumer")
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TimeRequest>> kafkaListenerContainerFactory(){
    ConsumerFactory<String, TimeRequest> consumerFactory = new DefaultKafkaConsumerFactory<>(
      consumerConfigs(),
      new StringDeserializer(),
      new ErrorHandlingDeserializer(new JsonDeserializer<>(TimeRequest.class))
    );
    ConcurrentKafkaListenerContainerFactory<String, TimeRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    return factory;
  }

  private Map<String, Object> consumerConfigs() {
    HashMap<String, Object> configs  = new HashMap<>();
    configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    configs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetReset);
    return configs;
  }



}
