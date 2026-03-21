package com.weg.pedagogico.service;

import com.weg.pedagogico.dto.request.DepartamentoRequestDto;
import com.weg.pedagogico.dto.response.DepartamentoResponseDto;
import com.weg.pedagogico.mapper.DepartamentoMapper;
import com.weg.pedagogico.model.Departamento;
import com.weg.pedagogico.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoMapper mapper;

    public DepartamentoResponseDto cadastrar(DepartamentoRequestDto dto) {
        Departamento departamento = mapper.toEntity(dto);
        Departamento salvo = repository.save(departamento);
        return mapper.toResponseDto(salvo);
    }

    public List<DepartamentoResponseDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<DepartamentoResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }
}
