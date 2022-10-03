package com.tistory.povia.kafkaproducer.push.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeRequest implements KafkaRequest {
  @JsonProperty("timestamp")
  private final Long timestamp;

  @JsonProperty("producer")
  private final String producer;

  public TimeRequest(Long timestamp, String producer) {
    this.timestamp = timestamp;
    this.producer = producer;
  }

  @Override
  public String toString() {
    return "{" +
      "timestamp=" + timestamp +
      ", producer='" + producer + '}';
  }
}
