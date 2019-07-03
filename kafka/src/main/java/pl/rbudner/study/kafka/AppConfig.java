package pl.rbudner.study.kafka;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@EnableScheduling
public class AppConfig {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    DataSource realDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
        return dataSource;
    }

    @Bean
    @Primary
    DataSource dataSource() {
        return new DataSourceSpy(realDataSource());
    }

    @Bean
    Properties kafkaProperties(
        @Value("${kafka.bootStrapServers}") String bootStrapServers,
        @Value("${kafka.keySerializer}") String keySerializer,
        @Value("${kafka.valueSerializer}") String valueSerializer) {

        Properties properties = new Properties();
        properties.setProperty(BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        properties.setProperty(KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        properties.setProperty(VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return properties;
    }

    @Bean
    KafkaProducer<String, String> kafkaProducer(Properties kafkaProperties) {
        return new KafkaProducer<>(kafkaProperties);
    }

    @Bean
    BusinessProducer businessProducer() {
        return new BusinessProducer();
    }
}
