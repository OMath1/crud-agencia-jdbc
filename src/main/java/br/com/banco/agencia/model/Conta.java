package br.com.banco.agencia.model;

public class Conta {
    private Integer idConta;
    private Titular idTitular;
    private Integer agencia;
    private Integer numero;
    private Double saldo;


    public Conta(Titular idTitular, Integer agencia, Integer numero, Double saldo) {
        this.idTitular = idTitular;
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

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Titular getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void adicional(Double valor) {
        this.setSaldo(this.saldo + valor);
    }

    @Override
    public String toString() {
        return "Conta" +
                "\n-----------------------" +
                "\n idConta= " + idConta +
                "\n idTitular= " + idTitular +
                "\n agencia= " + agencia +
                "\n numero= " + numero +
                "\n saldo= " + saldo;
    }
}
