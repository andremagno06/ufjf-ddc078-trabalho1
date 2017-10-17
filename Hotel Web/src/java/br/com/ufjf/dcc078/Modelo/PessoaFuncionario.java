package br.com.ufjf.dcc078.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PessoaFuncionario extends Pessoa implements Observer {

    private Observable reserva;
    private List<String> lista = new ArrayList<>();

    public PessoaFuncionario() {

    }

    public PessoaFuncionario(Observable reserva) {
        this.reserva = reserva;
        reserva.addObserver(this);
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
    
    public List<String> getLista() {
        return lista;
    }

    @Override
    public void update(Observable reservaSubjetc, Object arg) {
        if (reservaSubjetc instanceof Reserva) {
            Reserva reserva1 = (Reserva) reservaSubjetc;
            String msg = "Checkout:" + reserva1.getData_checkout() + " - Status: " + reserva1.getQuarto().getEstado().getNome() + " - Quarto" + reserva1.getQuarto().getDescricao();
            lista.add(msg);
            lista.add(msg);
        }
    }
    
   public List<String> Mensagemup(){
       lista.add( "Checkout:  - Status: - Quarto Funcinario:");
      return lista;
   }

}
