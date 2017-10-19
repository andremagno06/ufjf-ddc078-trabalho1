package br.com.ufjf.dcc078.Memento;

import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import java.util.ArrayList;

public class QuartoCareTaker {

    private static QuartoCareTaker instance;
    private static ArrayList<QuartoMemento> quartos;

    public static QuartoCareTaker getInstance() {
        if (instance == null) {
            instance = new QuartoCareTaker();
        }
        return instance;
    }

    public void adicionarMemento(QuartoMemento memento) {
        quartos.add(memento);
    }

    public QuartoEstado getUltimoEstadoSalvo(int idQuarto) {
        if (quartos.size() <= 0) {
            return new QuartoEstadoDisponivel();
        }
        
        QuartoEstado estado = null;
        for (QuartoMemento quarto : quartos) {
            if(quarto.getQuarto() == idQuarto){
                estado =  quarto.getUltimoEstado();
            } 
        }
        return estado;
       
    }
}
