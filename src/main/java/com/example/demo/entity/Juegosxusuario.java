package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@JsonIgnoreProperties(value = {"id"})
public class Juegosxusuario {

    @EmbeddedId
    private JuegoxusuarioId id;

    @ManyToOne
    @JoinColumn(name = "idjuego", nullable = false, insertable = false, updatable = false)
    private Juegos juegos;
    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false, insertable = false, updatable = false)
    private Usuarios usuarios;
    @Column(name="cantidad", nullable = false)
    private Integer cantidad;
}
