package com.corhuila.Viaje.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_servicio", length = 100, nullable = false)
    private String nombreServicio;

    @Column(name = "descripcion", length = 150, nullable = true)
    private String descripcion;

    @Column(name = "costo", length = 50, nullable = false, scale = 10, precision = 2)
    private BigDecimal costo;

    //CREO GETTER AND SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
