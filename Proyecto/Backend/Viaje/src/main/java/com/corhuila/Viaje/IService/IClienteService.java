package com.corhuila.Viaje.IService;

import com.corhuila.Viaje.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Cliente save(Cliente cliente);
    void update(Cliente cliente, Integer id);
    List<Cliente> all();
    Optional<Cliente> findById(Integer id);
    void delete (Integer id);
}
