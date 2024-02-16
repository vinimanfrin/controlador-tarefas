package com.vinimanfrin.controlador_tarefas.repositories;

import com.vinimanfrin.controlador_tarefas.domain.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {

}
