package com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos;

import com.vinimanfrin.controlador_tarefas.domain.tarefa.Categoria;
import com.vinimanfrin.controlador_tarefas.domain.tarefa.Tarefa;
import java.time.LocalDateTime;

public record DadosDetalhamentoTarefa(Long id,
                                      String descricao,
                                      boolean concluida,
                                      LocalDateTime dataCriacaoTarefa,
                                      LocalDateTime dataRealizacaoTarefa,
                                      Categoria categoria) {
    public DadosDetalhamentoTarefa(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getDescricao(), tarefa.isConcluida(), tarefa.getDataCriacaoTarefa(),tarefa.getDataConclusaoTarefa(),tarefa.getCategoria());
    }
}
