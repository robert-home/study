package pl.rbudner.study.kafka;

import lombok.Data;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    @Value("${kafka.sourceTopic}")
    private String sourceTopic;

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @Data
    static class Result {
        private final int left;
        private final int right;
        private final long answer;
    }

    // SQL sample
    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        MapSqlParameterSource source = new MapSqlParameterSource()
                .addValue("left", left)
                .addValue("right", right);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    }

    @RequestMapping("send")
    @ResponseStatus(HttpStatus.OK)
    public void produce(@RequestParam String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(sourceTopic, message);
        kafkaProducer.send(record);
        kafkaProducer.flush();
    }
}
