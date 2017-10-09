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
public class QuartoDuplo extends Quarto implements Promocao{

    public QuartoDuplo(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);
         
    }

    public QuartoDuplo() {
        this.setTipoQuarto("Duplo");
    }

    
    
    @Override
    public String tipoQuarto() {
       
        return "Duplo";
    }

    @Override
    public int obterDesconto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obterPromocao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
