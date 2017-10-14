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
public class PromocaoBaixaTemporada implements Promocao{

    public PromocaoBaixaTemporada() {
    }
    
    

    @Override
    public int obterDesconto() {
        return 30;
    }

    @Override
    public String obterPromocao() {
        return "Promoção de baixa temporada";
    }
    
}
