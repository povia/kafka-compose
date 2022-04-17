package com.tistory.povia.kafkaproducer.push;

import com.tistory.povia.kafkaproducer.push.request.KafkaRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventPusher {

  private final KafkaTemplate<String, KafkaRequest> kafkaTemplate;

  public EventPusher(KafkaTemplate<String, KafkaRequest> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(String topic, KafkaRequest kafkaRequest) {
    Message<KafkaRequest> message = MessageBuilder.withPayload(kafkaRequest).setHeader(KafkaHeaders.TOPIC, topic).build();
    kafkaTemplate.send(message);
  }
}
