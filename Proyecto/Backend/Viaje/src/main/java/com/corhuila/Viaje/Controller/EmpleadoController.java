package com.corhuila.Viaje.Controller;

import com.corhuila.Viaje.Entity.Empleado;
import com.corhuila.Viaje.IService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService service;

    @PostMapping("")
    public Empleado save(@RequestBody Empleado empleado) {
        return service.save(empleado);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Empleado empleado, @PathVariable Integer id) {
        service.update(empleado, id);
    }

    @GetMapping
    public List<Empleado> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Empleado> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
