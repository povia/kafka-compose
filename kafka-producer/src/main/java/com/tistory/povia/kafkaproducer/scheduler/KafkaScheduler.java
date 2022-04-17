package com.tistory.povia.kafkaproducer.scheduler;

import com.tistory.povia.kafkaproducer.push.EventPusher;
import com.tistory.povia.kafkaproducer.push.request.TimeRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class KafkaScheduler {

  private final EventPusher eventPusher;

  public KafkaScheduler(EventPusher eventPusher) {
    this.eventPusher = eventPusher;
  }

  @Scheduled(fixedDelay = 1000)
  public void sendToKafka(){
    Long timestamp = System.currentTimeMillis();
    String producer = "test";

    TimeRequest timeRequest = new TimeRequest(timestamp, producer);
    eventPusher.send("private", timeRequest);
  }
}
