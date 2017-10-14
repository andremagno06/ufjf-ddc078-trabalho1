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
public class QuartoDuplo extends Quarto{

    public QuartoDuplo(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);
         
    }

    public QuartoDuplo() {
        this.setTipoQuarto("Duplo");
        this.promocao = new PromocaoBaixaTemporada();
    }

    
    
    @Override
    public String tipoQuarto() {
       
        return "Duplo";
    }

}
