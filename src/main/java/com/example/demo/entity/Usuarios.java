package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@JsonIgnoreProperties(value = {"id"})
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Column(name = "apellidos", nullable = false, length = 45)
    private String apellidos;

    @Column(name = "nombres", nullable = false, length = 45)
    private String nombres;

    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    @Column(name = "password", nullable = false, length = 65)
    private String password;

    @Column(name = "autorizacion", nullable = false, length = 20)
    private  String autorizacion;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
}
