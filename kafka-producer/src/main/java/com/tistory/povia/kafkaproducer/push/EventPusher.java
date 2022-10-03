package com.tistory.povia.kafkaproducer.push;

import com.tistory.povia.kafkaproducer.push.request.KafkaRequest;

public interface EventPusher {
  void send(String topic, KafkaRequest kafkaRequest);
}
