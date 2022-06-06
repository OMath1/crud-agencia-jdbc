package br.com.banco.agencia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Titular {

    private Integer idTitular;
    private String nome;
    private String cpf;
    private String nomeDaMae;

    public Titular(String nome, String cpf, String nomeDaMae) {
        this.nome = nome;
        this.cpf = cpf;
        this.nomeDaMae = nomeDaMae;
    }
}
