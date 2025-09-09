package com.corhuila.Viaje.IRepository;

import com.corhuila.Viaje.Entity.Cliente;
import com.corhuila.Viaje.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
}
