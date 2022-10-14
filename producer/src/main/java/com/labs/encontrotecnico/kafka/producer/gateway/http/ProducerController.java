package com.labs.encontrotecnico.kafka.producer.gateway.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;
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
    public ResponseEntity<Void> sendToTopic(@PathVariable final String topic, @RequestBody final String message) {
        kafkaTemplate
                .send(topic, message)
                .addCallback(handleSuccess(), handleFailure());
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/topics/{topic}/keys/{key}/messages")
    public ResponseEntity<Void> sendToTopicAtKey(@PathVariable final String topic,
                                                 @PathVariable final String key,
                                                 @RequestBody final String message) {
        kafkaTemplate
                .send(topic, key, message)
                .addCallback(handleSuccess(), handleFailure());
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/topics/{topic}/keys/{key}/partitions/{partition}/messages")
    public ResponseEntity<Void> sendToTopicAtKeyAndPartition(@PathVariable final String topic,
                                                             @PathVariable final String key,
                                                             @PathVariable final Integer partition,
                                                             @RequestBody final String message) {
        kafkaTemplate.send(topic, partition, key, message);
        return ResponseEntity.accepted().build();
    }

    private SuccessCallback<? super SendResult<String, String>> handleSuccess() {
        return (SuccessCallback<SendResult<String, String>>) successResult ->
                log.info("Message successfully sent: {}", successResult.getProducerRecord());
    }

    private FailureCallback handleFailure() {
        return throwable -> log.error("Fail to send message:", throwable);
    }

}
