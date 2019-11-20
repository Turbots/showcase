package nl.politie.showcase.messaging;

import nl.politie.showcase.data.NodeEntity;
import nl.politie.showcase.service.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class SensorDataHandler {

    private static final Logger logger = LoggerFactory.getLogger(SensorDataHandler.class);

    private final NodeService nodeService;

    public SensorDataHandler(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @StreamListener("sensor-data")
    public void handleSensorData(NodeEntity nodeEntity) {
        logger.info("Saving the node data");

        this.nodeService.save(nodeEntity);
    }
}
