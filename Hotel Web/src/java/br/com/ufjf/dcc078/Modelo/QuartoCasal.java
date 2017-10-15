/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Modelo;

import java.util.Observable;

/**
 *
 * @author Davi
 */
public class QuartoCasal extends Quarto{

    public QuartoCasal() {
        this.setTipoQuarto("Casal");
        this.promocao = new PromocaoInverno();
    }

    public QuartoCasal(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);
        
    }

    @Override
    public String tipoQuarto() {

        return "Casal";
    }

}
