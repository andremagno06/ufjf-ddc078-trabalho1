package br.com.ufjf.dcc078.Memento;

import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import java.util.ArrayList;

public class QuartoMemento {

    private int quarto;
    private ArrayList<QuartoEstado> estados;

    public QuartoMemento(int quarto) {
        this.quarto = quarto;
        this.estados = new ArrayList<>();
    }

    public QuartoMemento() {
    }

    public void addEstado(QuartoEstado estado) {
        this.estados.add(estado);
    }

    public int getQuarto() {
        return quarto;
    }

    public QuartoEstado getUltimoEstado() {
        if (estados.size() <= 0) {
            return new QuartoEstadoDisponivel();
        }
        QuartoEstado estado = estados.get(estados.size() - 1);
        estados.remove(estados.size() - 1);
        return estado;
    }

}
