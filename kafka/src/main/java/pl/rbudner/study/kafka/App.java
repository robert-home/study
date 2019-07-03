package pl.rbudner.study.kafka;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws UnknownHostException{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getCanonicalHostName());
        SpringApplication.run(App.class, args);
    }
}
