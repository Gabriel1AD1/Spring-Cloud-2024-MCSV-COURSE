package com.gabo.microservicecourse.clients;


import com.gabo.microservicecourse.entity.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-user", url = "localhost:8001")
public interface UserClientRest {

    @GetMapping("/{id}")
    User detalle(@PathVariable Long id);

    @PostMapping("/")
    User crear(@RequestBody User User);

}
