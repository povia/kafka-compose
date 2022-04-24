package com.tistory.povia.kafkaconsumer.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TimeRequest implements Serializable {
  @JsonProperty("timestamp")
  private Long timestamp;

  @JsonProperty("producer")
  private String producer;

  public TimeRequest() {}

  public TimeRequest(Long timestamp, String producer) {
    this.timestamp = timestamp;
    this.producer = producer;
  }

  @Override
  public String toString() {
    return "TimeRequest{" +
      "timestamp=" + timestamp +
      ", producer='" + producer + '\'' +
      '}';
  }
}
