package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.demo.entity.Paises;

@Entity
@Table(name = "distribuidoras")
@Getter
@Setter
@JsonIgnoreProperties(value = {"id"})
public class Distribuidoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistribuidora", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fundacion", nullable = false, length = 255)
    private Integer fundacion;

    @Column(name = "web", nullable = false, length = 255)
    private String web;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Paises pais;
}
