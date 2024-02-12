package com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosAdicionarTarefa(
        @NotBlank(message = "A descrição da tarefa deve ser informada")
        String descricao,

        @NotNull(message = "A categoria deve ser informada")
        @Pattern(regexp = "CASA|ESTUDOS|GERAL", message = "A categoria precisa ser informada corretamente com algum dos valores : GERAL, ESTUDOS, CASA")
        String categoria) {
}
