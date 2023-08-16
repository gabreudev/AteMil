package com.GabreuDev.AteMil.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Correcao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String redacao;

    private String comentario;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
