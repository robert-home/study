package pl.rbudner.study.testcontainers;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.GenericContainer;

@Slf4j
public class Application {

    static {
        System.setProperty("DOCKER_TLS_VERIFY", "0");
        System.setProperty("DOCKER_HOST", "tcp://10.230.101.181:2376");
        System.setProperty("DOCKER_CERT_PATH", "C:\\Users\\rtbr\\.docker\\machine\\machines\\mars");
        System.setProperty("logback.configurationFile", "c:\\prj\\logback.xml");
    }

    public static void main(String[] args) throws InterruptedException {
        log.info("Study started");
        Thread containerThread = getContainerThread();
        containerThread.start();
        containerThread.join();
        log.info("Study finished");
    }

    private static Thread getContainerThread() {
        return new Thread() {
            @Override
            public void run() {
                super.run();
                GenericContainer container = new GenericContainer("alpine:latest")
                        .withExposedPorts(80)
                        .withEnv("MAGIC_NUMBER", "42")
                        .withCommand("/bin/sh", "-c",
                                "while true; do echo \"$MAGIC_NUMBER\" | nc -l -p 80; done");
                container.start();
            }
        };
    }
}