package com.muhikira.springbootkafkatutorial.controller;
import com.muhikira.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    @Autowired
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    // http://localhost:8080/api/v1/kafka/publish?message= hello World this is my Kafka Test
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        String message1 = message;
        kafkaProducer.sendMessage(message1);
        return ResponseEntity.ok("Message sent to the topic, This is my Kafka Test Message");
    }
}
