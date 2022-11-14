package app.epiboard.controller;

import app.epiboard.model.Service;
import app.epiboard.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository repo;

    @GetMapping("/services")
    public List<Service> findAllServices() {
        return repo.findAll();
    }

    @PostMapping("service/enable/{id}")
    public void enable(@PathVariable Long id, Service service) {
        service.setEnable(1);
        repo.save(service);
    }
    @PostMapping("service/disable/{id}")
    public void disable(@PathVariable Long id, Service service) {
        service.setEnable(0);
        repo.save(service);
    }
}
