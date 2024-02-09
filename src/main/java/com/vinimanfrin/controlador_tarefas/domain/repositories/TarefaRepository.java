package com.vinimanfrin.controlador_tarefas.domain.repositories;

import com.vinimanfrin.controlador_tarefas.domain.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
