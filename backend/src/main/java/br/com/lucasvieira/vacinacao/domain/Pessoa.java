package br.com.lucasvieira.vacinacao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Slf4j
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Integer idade;
    private String dataNascimento;
    private Boolean isVacinada;

    @ManyToOne
    @JoinColumn(name = "codigo_grupo_prioridade")
    private GruposPrioridades grupo;

}
