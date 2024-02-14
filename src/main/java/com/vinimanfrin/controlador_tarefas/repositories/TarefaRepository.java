package com.vinimanfrin.controlador_tarefas.repositories;

import com.vinimanfrin.controlador_tarefas.domain.tarefa.Tarefa;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {

}
