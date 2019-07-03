package pl.rbudner.study.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BusinessProducer
 */
@Component
public class BusinessProducer {

    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    //@Scheduled(fixedDelay = 5000)
    public void work() {
        kafkaProducer.send(null);
    }
    
}
