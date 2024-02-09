package com.vinimanfrin.controlador_tarefas.domain.tarefa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "tarefas")
@Table(name = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private boolean concluida;
    private LocalDateTime dataCriacaoTarefa;
    private LocalDateTime dataRealizacaoTarefa;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
