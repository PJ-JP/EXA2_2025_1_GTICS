package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "juegos")
@Getter
@Setter
//@JsonIgnoreProperties(value = {"image"})
@JsonIgnoreProperties(value = {"id"})

public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "image", nullable = false, length = 255)
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "idgenero", nullable = false)
    private Generos genero;
    @ManyToOne
    @JoinColumn(name = "idplataforma", nullable = false)
    private Plataformas plataforma;
    @ManyToOne
    @JoinColumn(name = "ideditora", nullable = false)
    private Editoras editora;
    @ManyToOne
    @JoinColumn(name = "iddistribuidora", nullable = false)
    private Distribuidoras distribuidora;

}
