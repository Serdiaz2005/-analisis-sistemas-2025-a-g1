package com.corhuila.Viaje.Service;

import com.corhuila.Viaje.Entity.Servicio;
import com.corhuila.Viaje.IRepository.IServicioRepository;
import com.corhuila.Viaje.IService.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements IServicioService {
    @Autowired
    private IServicioRepository repository;

    @Override
    public Servicio save(Servicio servicio) {
        return repository.save(servicio);
    }

    @Override
    public void update(Servicio servicio, Integer id) {
        // Validar si el id existe
        Optional<Servicio> up = repository.findById(id);

        if (up.isPresent()) {
            Servicio existingServicio = up.get();
            // Actualizar los valores del objeto existente
            existingServicio.setNombreServicio(servicio.getNombreServicio());
            existingServicio.setDescripcion(servicio.getDescripcion());
            existingServicio.setCosto(servicio.getCosto());
            // Guardar el objeto existente actualizado
            repository.save(existingServicio);
        } else {
            System.out.println("No existe el registro con ID: " + id);
        }
    }

    @Override
    public List<Servicio> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Servicio> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
