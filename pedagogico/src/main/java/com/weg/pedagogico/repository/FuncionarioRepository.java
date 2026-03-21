package com.weg.pedagogico.repository;

import com.weg.pedagogico.model.Funcionario;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    Optional<Funcionario> findByIdAndNomeContainingIgnoreCase(Long id, String nome);

    List<Funcionario> findByDepartamentoId(Long departamentoId);
}
