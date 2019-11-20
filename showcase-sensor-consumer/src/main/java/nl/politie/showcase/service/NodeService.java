package nl.politie.showcase.service;

import nl.politie.showcase.data.NodeEntity;
import nl.politie.showcase.data.NodeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NodeService {

    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Transactional
    public void save(NodeEntity nodeEntity) {
        this.nodeRepository.save(nodeEntity);
    }
}
