/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Modelo.Memento;

import br.com.ufjf.dcc078.Modelo.HistoricoMemento;
import br.com.ufjf.dcc078.Modelo.QuartoMemento;
import java.util.ArrayList;

/**
 *
 * @author Desenvolvedor
 */
public class QuartoCareTaker {

    private  ArrayList<QuartoMemento> estados = new ArrayList<>();

    private static QuartoCareTaker instance;


    public static QuartoCareTaker getInstance() {
        if (instance == null) {
            instance = new QuartoCareTaker();
        }
        return instance;
    }

   private QuartoCareTaker() {

    }
   
    public void adicionarMemento(QuartoMemento memento) {
        this.estados.add(memento);
    }
    
    public QuartoMemento getUltimoEstadoSalvo(){
                 if (estados.size() <= 0) {
            return new QuartoMemento();
        }
        QuartoMemento estadoSalvo = estados.get(estados.size() - 1);
        estados.remove(estados.size() - 1);
        return estadoSalvo;
    
    
    }
    
    
    //SET GET
    
    
      public ArrayList<QuartoMemento> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<QuartoMemento> estados) {
        this.estados = estados;
    }

}
