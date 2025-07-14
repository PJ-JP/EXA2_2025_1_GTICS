package com.example.demo.entity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class JuegoxusuarioId implements Serializable {
    @Column(name = "idjuegosxusuario", nullable = false)
    private Integer idjuegosxusuario;
}
