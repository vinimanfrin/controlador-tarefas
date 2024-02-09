package com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos;

import com.vinimanfrin.controlador_tarefas.domain.tarefa.Categoria;

public record DadosAtualizacaoTarefa(String descricao, Categoria categoria) {
}
