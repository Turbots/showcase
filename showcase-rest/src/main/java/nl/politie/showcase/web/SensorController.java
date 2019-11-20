package nl.politie.showcase.web;

import nl.politie.showcase.data.Sensor;
import nl.politie.showcase.data.SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private static final Logger logger = LoggerFactory.getLogger(SensorController.class);

    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @GetMapping
    public Flux<Sensor> getSensors() {
        logger.info("Fetching all Sensor data");
        return this.sensorRepository.findAll();
    }
}
