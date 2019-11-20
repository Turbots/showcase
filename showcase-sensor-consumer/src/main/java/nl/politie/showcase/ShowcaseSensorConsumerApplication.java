package nl.politie.showcase;

import nl.politie.showcase.data.NodeEntity;
import nl.politie.showcase.data.SensorEntity;
import nl.politie.showcase.data.SensorType;
import nl.politie.showcase.messaging.InputChannels;
import nl.politie.showcase.service.NodeService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableBinding(InputChannels.class)
public class ShowcaseSensorConsumerApplication implements ApplicationRunner {

    public ShowcaseSensorConsumerApplication(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShowcaseSensorConsumerApplication.class, args);
    }

    private final NodeService nodeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Set<SensorEntity> sensors = new HashSet<>();

        sensors.add(new SensorEntity(SensorType.TEMP, "12%"));
        sensors.add(new SensorEntity(SensorType.VOLTAGE, "5"));
        sensors.add(new SensorEntity(SensorType.HUMIDITY, "80%"));

        this.nodeService.save(new NodeEntity("node1", "kpn", sensors));
    }
}
