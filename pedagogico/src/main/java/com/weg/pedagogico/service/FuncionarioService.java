package com.weg.pedagogico.service;

import com.weg.pedagogico.dto.request.FuncionarioRequestDto;
import com.weg.pedagogico.dto.response.FuncionarioResponseDto;
import com.weg.pedagogico.mapper.FuncionarioMapper;
import com.weg.pedagogico.model.Departamento;
import com.weg.pedagogico.model.Funcionario;
import com.weg.pedagogico.repository.DepartamentoRepository;
import com.weg.pedagogico.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final DepartamentoRepository departamentoRepository;
    private final FuncionarioMapper mapper;

    public FuncionarioResponseDto cadastrar(FuncionarioRequestDto dto) {
        Departamento departamento = departamentoRepository.findById(dto.departamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado com o id: " + dto.departamentoId()));
        Funcionario funcionario = mapper.toEntity(dto, departamento);
        Funcionario salvo = repository.save(funcionario);
        return mapper.toResponseDto(salvo);
    }

    public List<FuncionarioResponseDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<FuncionarioResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }

    public List<FuncionarioResponseDto> buscarPorDepartamentoId(Long departamentoId) {
        return repository.findByDepartamentoId(departamentoId)
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<FuncionarioResponseDto> buscarPorNomes(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public FuncionarioResponseDto buscarPorIdENome(Long id, String nome) {
        Funcionario funcionario = repository.findByIdAndNomeContainingIgnoreCase(id, nome)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return mapper.toResponseDto(funcionario);
    }
}
