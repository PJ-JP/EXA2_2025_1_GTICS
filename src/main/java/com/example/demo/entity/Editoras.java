package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editoras")
@Getter
@Setter
@JsonIgnoreProperties(value = {"id"})
public class Editoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideditora", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;
}
