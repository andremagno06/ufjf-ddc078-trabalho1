/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Modelo;

/**
 *
 * @author Davi
 */
public class PessoaCliente extends Pessoa{
 
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String tipo_pessoa;
  

    public PessoaCliente() {
    }

    public PessoaCliente(int id, String nome, String cpf, String endereco, String tipo_pessoa) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.tipo_pessoa = tipo_pessoa;
   
    } 

    public PessoaCliente(String nome, String cpf, String endereco, String tipo_pessoa) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.tipo_pessoa = tipo_pessoa;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

 
    
    
    
    
}
