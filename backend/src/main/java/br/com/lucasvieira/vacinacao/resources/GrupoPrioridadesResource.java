package br.com.lucasvieira.vacinacao.resources;

import br.com.lucasvieira.vacinacao.domain.GruposPrioridades;
import br.com.lucasvieira.vacinacao.repository.GruposPrioridadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupos-prioridades")
public class GrupoPrioridadesResource {

    @Autowired
    GruposPrioridadesRepository gruposPrioridadesRepository;

    @GetMapping
    public List<GruposPrioridades> listarTodos() {
        return gruposPrioridadesRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public GruposPrioridades buscarPeloCodigo(@PathVariable Long codigo) {
        return gruposPrioridadesRepository.findById(codigo).orElse(null);
    }

}
