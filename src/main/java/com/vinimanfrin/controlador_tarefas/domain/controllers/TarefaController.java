package com.vinimanfrin.controlador_tarefas.domain.controllers;

import com.vinimanfrin.controlador_tarefas.domain.repositories.TarefaRepository;
import com.vinimanfrin.controlador_tarefas.domain.tarefa.Tarefa;
import com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos.DadosAdicionarTarefa;
import com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos.DadosAtualizacaoTarefa;
import com.vinimanfrin.controlador_tarefas.domain.tarefa.dtos.DadosDetalhamentoTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTarefa>> buscarTodos(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosDetalhamentoTarefa::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTarefa> buscarPeloId(@PathVariable Long id){
        var tarefa = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTarefa> adicionarTarefa(@RequestBody DadosAdicionarTarefa dados, UriComponentsBuilder uriBuilder){
        var tarefa = repository.save(new Tarefa(dados));
        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTarefa(tarefa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagarTarefa(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTarefa> atualizarTarefa(@PathVariable Long id, @RequestBody DadosAtualizacaoTarefa dados){
        var tarefa = repository.getReferenceById(id);
        tarefa.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }
}
