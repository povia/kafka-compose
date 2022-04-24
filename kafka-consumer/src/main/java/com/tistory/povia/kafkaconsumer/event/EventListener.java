package com.tistory.povia.kafkaconsumer.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class EventListener {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @KafkaListener(topics = "${spring.kafka.consumer.topic.test}", containerFactory = "pushConsumer")
  public void listenEvent(TimeRequest request) {
    logger.info("[listenEvent] got message. {}", request);
  }
}
