package br.com.banco.agencia.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Conta {
    private Integer idConta;

    @ToString.Exclude
    private Titular idTitular;
    private Integer agencia;
    private Integer numero;
    private Double saldo;


    public Conta(Integer agencia, Integer numero, Double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(Integer idConta, Integer agencia, Integer numero, Double saldo) {
        this.idConta = idConta;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }
//    public void adicionar(Double valor) {
//        this.setSaldo(this.saldo + valor);
//    }

}
