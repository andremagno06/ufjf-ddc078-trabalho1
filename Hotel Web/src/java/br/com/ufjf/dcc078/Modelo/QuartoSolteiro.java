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
public class QuartoSolteiro extends Quarto implements Promocao{

    public QuartoSolteiro() {
        this.setTipoQuarto("Solteiro");
    }

    public QuartoSolteiro(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);
        
    }

    
    
    @Override
   public String tipoQuarto() {
        
        return "Solteiro";
    }

    @Override
    public int obterDesconto() {
        
    }

    @Override
    public String obterPromocao() {
        
    }
    
}
