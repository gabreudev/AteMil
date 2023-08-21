package com.GabreuDev.AteMil.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Correcao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String redacao;

    private String comentario;

    private int nota;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
