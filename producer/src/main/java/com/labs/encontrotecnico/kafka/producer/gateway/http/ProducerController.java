package com.labs.encontrotecnico.kafka.producer.gateway.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/topics/{topic}/messages")
    public void sendToTopic(@PathVariable String topic, @RequestBody String message) {
        kafkaTemplate.send(topic, message)
//                .addCallback(
//                new ListenableFutureCallback<>() {
//                    @Override
//                    public void onSuccess(final SendResult<String, String> result) {
//                        log.info("Message successfully sent =[{}] topic=[{}] offset=[{}] ",
//                                message, result.getRecordMetadata().topic(), result.getRecordMetadata().offset());
//                    }
//
//                    @Override
//                    public void onFailure(final Throwable ex) {
//                        log.info("Failed to send message with content=[{}]", message, ex);
//                    }
//                })
        ;
    }

    @PostMapping("/topics/{topic}/keys/{key}/messages")
    public void sendToTopicAtKey(@PathVariable String topic,
                                 @PathVariable String key,
                                 @RequestBody String message) {
        kafkaTemplate.send(topic, key, message);
    }

    @PostMapping("/topics/{topic}/keys/{key}/partitions/{partition}/messages")
    public void sendToTopicAtKeyAndPartition(@PathVariable String topic,
                                             @PathVariable String key,
                                             @PathVariable Integer partition,
                                             @RequestBody String message) {
        kafkaTemplate.send(topic, partition, key, message);
    }

}