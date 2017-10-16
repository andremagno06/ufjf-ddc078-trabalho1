package br.com.ufjf.dcc078.Modelo;

import java.util.Observable;

public class Reserva extends Observable {

    private int id;
    private Pessoa cliente;
    private Quarto quarto;
    private String data_checkin;
    private String data_checkout;
    private String data_reserva;

    public Reserva() {
    }

    public Reserva(Pessoa cliente, Quarto quarto, String data_reserva) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.data_reserva = data_reserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(PessoaCliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;

    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
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
        setChanged();
        notifyObservers();
    }

    public String getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }

}
