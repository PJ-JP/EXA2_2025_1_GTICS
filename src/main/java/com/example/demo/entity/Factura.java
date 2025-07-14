package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@JsonIgnoreProperties(value = {"id"})
@Entity
@Table(name = "factura")
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura", nullable = false)
    private Integer id;
    @Column(name = "fechaEnvio", nullable = false, length = 50)
    private  String fechaEnvio;
    @Column(name = "tarjeta", nullable = false, length = 50)
    private String tarjeta;
    @Column(name = "codigoVerificacion", length = 5)
    private String codigoVerificacion;
    @Column(name = "direccion", length = 500)
    private String direccion;
    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;
    @ManyToOne
    @JoinColumn(name = "idjuegosxusuario", nullable = false)
    private Juegosxusuario juegosXUsuario;

}
