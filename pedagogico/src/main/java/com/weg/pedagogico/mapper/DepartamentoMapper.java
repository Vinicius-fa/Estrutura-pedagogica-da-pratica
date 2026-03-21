package com.weg.pedagogico.mapper;

import com.weg.pedagogico.dto.request.DepartamentoRequestDto;
import com.weg.pedagogico.dto.response.DepartamentoResponseDto;
import com.weg.pedagogico.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(DepartamentoRequestDto dto) {
        return new Departamento(
                dto.nome()
        );
    }

    public DepartamentoResponseDto toResponseDto(Departamento departamento) {
        return new DepartamentoResponseDto(
                departamento.getId(),
                departamento.getNome()
        );
    }
}
