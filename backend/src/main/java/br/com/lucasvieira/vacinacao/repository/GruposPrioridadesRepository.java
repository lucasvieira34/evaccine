package br.com.lucasvieira.vacinacao.repository;

import br.com.lucasvieira.vacinacao.domain.GruposPrioridades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruposPrioridadesRepository extends JpaRepository<GruposPrioridades, Long> {
}
