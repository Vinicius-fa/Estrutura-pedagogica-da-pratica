package com.weg.pedagogico.controller;

import com.weg.pedagogico.dto.request.FuncionarioRequestDto;
import com.weg.pedagogico.dto.response.DepartamentoResponseDto;
import com.weg.pedagogico.dto.response.FuncionarioResponseDto;
import com.weg.pedagogico.mapper.FuncionarioMapper;
import com.weg.pedagogico.repository.FuncionarioRepository;
import com.weg.pedagogico.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<FuncionarioResponseDto>> buscarPorDepartamento(@PathVariable Long departamentoId) {
        return ResponseEntity.ok(service.buscarPorDepartamentoId(departamentoId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<FuncionarioResponseDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNomes(nome));
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> cadastrar(@RequestBody FuncionarioRequestDto dto) {
        return ResponseEntity.status(201).body(service.cadastrar(dto));
    }
}