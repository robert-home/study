package pl.rbudner.study;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Application {

    private static final String BROKER = "tcp://demo.thingsboard.io";
    private static final String CLINET_ID = MqttClient.generateClientId();
    private static final String TOPIC = "v1/devices/me/telemetry";

    public static void main(String[] args) {
        try {
            MqttClient sampleClient = new MqttClient(BROKER, CLINET_ID, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("");
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + BROKER);
            sampleClient.connect(connOpts);
            System.out.println("Connected");

            MqttMessage message = new MqttMessage("{\"temperature\":14.5}".getBytes());
            message.setQos(0);
            sampleClient.publish(TOPIC, message);
            System.out.println("Message published");

            sampleClient.disconnect();
            System.out.println("Disconnected");

            System.exit(0);
        } catch (MqttException me) {
            System.out.println("Exception:" + me.getReasonCode() + " " + me.getMessage());
            System.exit(1);
        }
    }
}
