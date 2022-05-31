package br.com.banco.agencia.model;

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

    public Titular(Integer idTitular, String nome, String cpf, String nomeDaMae) {
        this.idTitular = idTitular;
        this.nome = nome;
        this.cpf = cpf;
        this.nomeDaMae = nomeDaMae;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }
}
