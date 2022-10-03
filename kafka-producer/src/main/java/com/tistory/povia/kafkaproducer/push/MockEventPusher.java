package com.tistory.povia.kafkaproducer.push;

import com.tistory.povia.kafkaproducer.push.request.KafkaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockEventPusher implements EventPusher{
  private static final Logger LOGGER = LoggerFactory.getLogger(MockEventPusher.class);

  @Override
  public void send(String topic, KafkaRequest kafkaRequest) {
    LOGGER.info("topic: {}, message = {}", topic, kafkaRequest);
  }
}
