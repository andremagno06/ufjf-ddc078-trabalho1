package br.com.ufjf.dcc078.Modelo;

public class PessoaCliente extends Pessoa {

    public PessoaCliente() {
    }

    public PessoaCliente(int id, String nome, String cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public PessoaCliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String getTipo() {
        return "C";
    }
}
