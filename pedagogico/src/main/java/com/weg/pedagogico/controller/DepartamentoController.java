package com.weg.pedagogico.controller;

import com.weg.pedagogico.dto.request.DepartamentoRequestDto;
import com.weg.pedagogico.dto.response.DepartamentoResponseDto;
import com.weg.pedagogico.mapper.DepartamentoMapper;
import com.weg.pedagogico.repository.DepartamentoRepository;
import com.weg.pedagogico.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> cadastrar(@RequestBody DepartamentoRequestDto dto) {
        return ResponseEntity.status(201).body(service.cadastrar(dto));
    }
}
