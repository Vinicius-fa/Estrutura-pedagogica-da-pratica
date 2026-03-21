package com.weg.pedagogico.dto.response;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        Long departamentoId,
        String departamentoNome
) {
}
