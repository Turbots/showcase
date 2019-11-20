package nl.politie.showcase.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends ReactiveCrudRepository<Sensor, Long> {

}
