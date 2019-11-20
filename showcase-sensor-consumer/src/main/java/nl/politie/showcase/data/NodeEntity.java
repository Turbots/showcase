package nl.politie.showcase.data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NodeEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String network;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<SensorEntity> sensors;

    public NodeEntity() {
    }

    public NodeEntity(String name, String network, Set<SensorEntity> sensors) {
        this.name = name;
        this.network = network;
        this.sensors = sensors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Set<SensorEntity> getSensors() {
        return sensors;
    }

    public void setSensors(Set<SensorEntity> sensors) {
        this.sensors = sensors;
    }
}
