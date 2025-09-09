package com.corhuila.Viaje.Controller;

import com.corhuila.Viaje.Entity.Cliente;
import com.corhuila.Viaje.Entity.ServicioCliente;
import com.corhuila.Viaje.IService.IServicioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/servicioCliente")
public class ServicioClienteController{

    @Autowired
    private IServicioClienteService service;

    @PostMapping("")
    public ServicioCliente save(@RequestBody ServicioCliente servicioCliente) {
        return service.save(servicioCliente);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ServicioCliente servicioCliente, @PathVariable Integer id) {
        service.update(servicioCliente, id);
    }
    @GetMapping
    public List<ServicioCliente> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<ServicioCliente> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
