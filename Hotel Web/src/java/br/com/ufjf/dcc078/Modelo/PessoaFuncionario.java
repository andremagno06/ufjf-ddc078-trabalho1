package br.com.ufjf.dcc078.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PessoaFuncionario extends Pessoa implements Observer {

    private QuartoEstado novoEstado;
    private List<String> lista = new ArrayList<>();

    public PessoaFuncionario() {
    }

    public PessoaFuncionario(int id, String nome, String cpf, String endereco, String email) {
        super(id, nome, cpf, endereco, email);
    }

    public PessoaFuncionario(String nome, String cpf, String endereco, String email) {
        super(nome, cpf, endereco, email);
    }

    @Override
    public String getTipo() {
        return "F";
    }

    public QuartoEstado getNovoEstado() {
        return novoEstado;
    }

    @Override
    public void update(Observable quartoSubject, Object arg) {
        if (quartoSubject instanceof Quarto) {

            Quarto quarto = (Quarto) quartoSubject;
            novoEstado = quarto.getEstado();
            lista.add("Atenção " + getNome() + " o quarto " + quarto.getDescricao() + "esta com estado " + novoEstado.getNome());
            System.out.println("Atenção" + getNome() + " o quarto " + quarto.getDescricao() + "esta com estado " + novoEstado.getNome());
        }
    }

    public List<String> Mensagemup() {
        lista.add("Teste1");
        lista.add("Teste2");
        return lista;
    }

}
