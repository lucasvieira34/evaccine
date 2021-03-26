package br.com.lucasvieira.vacinacao.resources;

import br.com.lucasvieira.vacinacao.domain.Pessoa;
import br.com.lucasvieira.vacinacao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa payload) {
        Pessoa pessoaCadastrada = pessoaRepository.save(payload);
        pessoaCadastrada.setIsVacinada(false);
        return pessoaRepository.save(payload);
    }

    @PutMapping(value = "/{codigo}")
    public Pessoa atualizar(@PathVariable("codigo") Long codigo,
                                    @RequestBody Pessoa payload) {
        return pessoaRepository.findById(codigo).map(
                record -> {
                    record.setCpf(payload.getCpf());
                    record.setDataNascimento(payload.getDataNascimento());
                    record.setEmail(payload.getEmail());
                    record.setIdade(payload.getIdade());
                    record.setNome(payload.getNome());
                    record.setTelefone(payload.getTelefone());
                    record.setIsVacinada(payload.getIsVacinada());
                    return pessoaRepository.save(record);
                }
        ).orElse(null);
    }

    @GetMapping(value = "/{codigo}")
    public Pessoa buscarPeloCodigo(@PathVariable("codigo") Long codigo) {
        return pessoaRepository.findById(codigo).orElse(null);
    }

}
