package com.corhuila.Viaje.Service;

import com.corhuila.Viaje.Entity.Empleado;
import com.corhuila.Viaje.IRepository.IEmpleadoRepository;
import com.corhuila.Viaje.IService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository repository;

    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public void update(Empleado empleado, Integer id) {
        // Validar si el id existe
        Optional<Empleado> up = repository.findById(id);

        if (up.isPresent()) {
            Empleado existingEmpleado = up.get();
            // Actualizar los valores del objeto existente
            existingEmpleado.setNombre(empleado.getNombre());
            existingEmpleado.setApellido(empleado.getApellido());
            existingEmpleado.setCargo(empleado.getCargo());
            existingEmpleado.setEmail(empleado.getEmail());
            existingEmpleado.setTelefono(empleado.getTelefono());
            existingEmpleado.setSalario(empleado.getSalario());

            // Guardar el objeto existente actualizado
            repository.save(existingEmpleado);
        } else {
            System.out.println("No existe el registro con ID: " + id);
        }
    }

    @Override
    public List<Empleado> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
