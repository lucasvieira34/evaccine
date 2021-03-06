package br.com.lucasvieira.vacinacao.repository;

import br.com.lucasvieira.vacinacao.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
