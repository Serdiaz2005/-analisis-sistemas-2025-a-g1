package com.corhuila.Viaje.Service;

import com.corhuila.Viaje.Entity.Cliente;
import com.corhuila.Viaje.IRepository.IClienteRepository;
import com.corhuila.Viaje.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente, Integer id) {
        // Validar si el id existe
        Optional<Cliente> up = repository.findById(id);

        if (up.isPresent()) {
            Cliente existingCliente = up.get();
            // Actualizar los valores del objeto existente
            existingCliente.setDocumento(cliente.getDocumento());
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setApellido(cliente.getApellido());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setTelefono(cliente.getTelefono());
            // Guardar el objeto existente actualizado
            repository.save(existingCliente);
        } else {
            System.out.println("No existe el registro con ID: " + id);
        }
    }

    @Override
    public List<Cliente> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
