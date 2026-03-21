package com.weg.pedagogico.mapper;

import com.weg.pedagogico.dto.request.FuncionarioRequestDto;
import com.weg.pedagogico.dto.response.FuncionarioResponseDto;
import com.weg.pedagogico.model.Departamento;
import com.weg.pedagogico.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario toEntity(FuncionarioRequestDto dto, Departamento departamento) {
        return new Funcionario(
                dto.nome(),
                departamento
        );
    }

    public FuncionarioResponseDto toResponseDto(Funcionario funcionario) {
        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getDepartamento().getId(),
                funcionario.getDepartamento().getNome()
        );
    }
}
