/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Modelo;

import java.util.ArrayList;

/**
 *
 * @author Desenvolvedor
 */
public class HistoricoMemento {
    
    private int id;
    private  Reserva reserva;
    private ArrayList<QuartoMemento> quartoMemento;
    private int ordem;

    public HistoricoMemento() {
    }



    public HistoricoMemento(int id, Reserva reserva, ArrayList<QuartoMemento> quartoMemento, int ordem) {
        this.id = id;
        this.reserva = reserva;
        this.quartoMemento = quartoMemento;
        this.ordem = ordem;
    }

    
    
    //Get Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }


    public ArrayList<QuartoMemento> getQuartoMemento() {
        return quartoMemento;
    }

    public void setQuartoMemento(ArrayList<QuartoMemento> quartoMemento) {
        this.quartoMemento = quartoMemento;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    
    
    
    
    
}
