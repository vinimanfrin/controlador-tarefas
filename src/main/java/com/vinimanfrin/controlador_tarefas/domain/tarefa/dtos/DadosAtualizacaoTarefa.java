package com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoTarefa(
        @NotBlank(message = "A descrição da tarefa deve ser informada")
        String descricao,

        @NotNull
        @Pattern(regexp = "GERAL|ESTUDOS|CASA", message = "A categoria precisa ser informada corretamente com algum dos valores : GERAL, ESTUDOS, CASA")
        String categoria) {
}
