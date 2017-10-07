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
public class Reserva {
    
    private int id;
    private int pessoa_id;
    private int quarto_id;
    private String data_checkin;
    private String data_checkout;
    private String data_reserva;

    public Reserva() {
    }

    public Reserva(int id, int pessoa_id, int quarto_id, String data_checkin, String data_checkout, String data_reserva) {
        this.id = id;
        this.pessoa_id = pessoa_id;
        this.quarto_id = quarto_id;
        this.data_checkin = data_checkin;
        this.data_checkout = data_checkout;
        this.data_reserva = data_reserva;
    }
    public Reserva(int pessoa_id, int quarto_id, String data_checkin, String data_checkout, String data_reserva) {
        this.pessoa_id = pessoa_id;
        this.quarto_id = quarto_id;
        this.data_checkin = data_checkin;
        this.data_checkout = data_checkout;
        this.data_reserva = data_reserva;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public int getQuarto_id() {
        return quarto_id;
    }

    public void setQuarto_id(int quarto_id) {
        this.quarto_id = quarto_id;
    }

    public String getData_checkin() {
        return data_checkin;
    }

    public void setData_checkin(String data_checkin) {
        this.data_checkin = data_checkin;
    }

    public String getData_checkout() {
        return data_checkout;
    }

    public void setData_checkout(String data_checkout) {
        this.data_checkout = data_checkout;
    }

    public String getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }
    
    
    
    
}
