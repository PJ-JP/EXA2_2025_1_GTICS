package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paises")
@Getter
@Setter
@JsonIgnoreProperties(value = {"id"})
public class Paises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais", nullable = false)
    private Integer id;
    @Column(name = "iso", nullable = false, length = 2)
    private String iso;
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;
}
