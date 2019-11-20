package nl.politie.showcase.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannels {

    @Input("sensor-data")
    SubscribableChannel sensorData();
}
