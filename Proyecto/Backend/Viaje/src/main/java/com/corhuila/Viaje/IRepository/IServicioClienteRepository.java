package com.corhuila.Viaje.IRepository;

import com.corhuila.Viaje.Entity.Cliente;
import com.corhuila.Viaje.Entity.ServicioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioClienteRepository extends JpaRepository<ServicioCliente, Integer> {
}
