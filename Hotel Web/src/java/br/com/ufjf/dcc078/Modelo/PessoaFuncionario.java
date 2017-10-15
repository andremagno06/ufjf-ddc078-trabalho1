/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Modelo;

import br.com.ufjf.dcc078.Actions.GravarCheckoutAction;
import com.sun.xml.xsom.impl.scd.Iterators;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Davi
 */
public class PessoaFuncionario  extends Pessoa implements Observer{
 
    
   private  QuartoEstado novoEstado;
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String tipo_pessoa;
    private String email;
    private List<String> lista= new ArrayList<String>();
    
    
    
    
    public PessoaFuncionario() {
             
               this.novoEstado= null;
    }

    public PessoaFuncionario(int id, String nome, String cpf, String endereco, String tipo_pessoa, String email,Observable quarto) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.tipo_pessoa = tipo_pessoa;
        this.email = email;
        novoEstado=null;
    } 

    public PessoaFuncionario(String nome, String cpf, String endereco, String tipo_pessoa, String email,Observable quarto) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.tipo_pessoa = tipo_pessoa;
        this.email = email;

        this.novoEstado= null;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public QuartoEstado getNovoEstado() {
        return novoEstado;
    }

 
        @Override
    public void update(Observable quartoSubject, Object arg) {
        if(quartoSubject instanceof Quarto){
   
           Quarto quarto = (Quarto)quartoSubject;
           novoEstado =quarto.getEstado();
           lista.add("Atenção "+getNome()+" o quarto "+quarto.getDescricao()+ "esta com estado " +novoEstado.getNome()); 
           System.out.println("Atenção"+getNome()+" o quarto "+quarto.getDescricao()+ "esta com estado " +novoEstado.getNome());
        }
    }
    public List<String> Mensagemup(){
        lista.add("Teste1");
        lista.add("Teste2");
       return lista;
    }
    
       
}