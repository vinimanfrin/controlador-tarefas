package com.vinimanfrin.controlador_tarefas.domain.tarefa;

import com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos.DadosAdicionarTarefa;
import com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos.DadosAtualizacaoTarefa;
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
    private LocalDateTime dataConclusaoTarefa;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Tarefa(DadosAdicionarTarefa dados) {
        this.descricao = dados.descricao();
        this.concluida = false;
        this.dataCriacaoTarefa = LocalDateTime.now();
        this.categoria = dados.categoria();
    }

    public void atualizar(DadosAtualizacaoTarefa dados) {
        if (dados.descricao() != null) this.descricao = dados.descricao();
        if (dados.categoria() != null) this.categoria = dados.categoria();
    }

    public void concluir(){
        this.concluida = true;
        this.dataConclusaoTarefa = LocalDateTime.now();
    }
}
