package com.corhuila.Viaje.IService;

import com.corhuila.Viaje.Entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    Empleado save(Empleado empleado);
    void update(Empleado empleado, Integer id);
    List<Empleado> all();
    Optional<Empleado> findById(Integer id);
    void delete (Integer id);
}
