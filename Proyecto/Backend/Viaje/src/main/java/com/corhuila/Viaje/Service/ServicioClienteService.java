package com.corhuila.Viaje.Service;

import com.corhuila.Viaje.Entity.ServicioCliente;
import com.corhuila.Viaje.IRepository.IServicioClienteRepository;
import com.corhuila.Viaje.IService.IServicioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioClienteService implements IServicioClienteService {
    @Autowired
    private IServicioClienteRepository repository;

    @Override
    public ServicioCliente save(ServicioCliente servicioCliente) {
        return repository.save(servicioCliente);
    }

    @Override
    public void update(ServicioCliente servicioCliente, Integer id) {
        // Validar si el id existe
        Optional<ServicioCliente> up = repository.findById(id);

        if (up.isPresent()) {
            ServicioCliente existingServicioCliente = up.get();
            // Actualizar los valores del objeto existente
            existingServicioCliente.setClienteId(servicioCliente.getClienteId());
            existingServicioCliente.setServicioId(servicioCliente.getServicioId());
            existingServicioCliente.setFecha(servicioCliente.getFecha());
            existingServicioCliente.setEstado(servicioCliente.getEstado());
            existingServicioCliente.setMontoTotal(servicioCliente.getMontoTotal());
            // Guardar el objeto existente actualizado
            repository.save(existingServicioCliente);
        } else {
            System.out.println("No existe el registro con ID: " + id);
        }
    }


    @Override
    public List<ServicioCliente> all() {
        return repository.findAll();
    }

    @Override
    public Optional<ServicioCliente> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
