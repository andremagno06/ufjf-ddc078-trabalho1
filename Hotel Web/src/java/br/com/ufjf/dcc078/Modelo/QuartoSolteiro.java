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
public class QuartoSolteiro extends Quarto{

    public QuartoSolteiro() {
        this.setTipoQuarto("Solteiro");
        this.promocao = new PromocaoFimDeAno();
    }

    public QuartoSolteiro(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);
        
    }

    
    
    @Override
   public String tipoQuarto() {
        
        return "Solteiro";
    }

}
