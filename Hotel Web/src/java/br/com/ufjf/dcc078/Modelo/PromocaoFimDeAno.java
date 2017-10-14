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
public class PromocaoFimDeAno implements Promocao{

    public PromocaoFimDeAno() {
    }

    
    
    @Override
    public int obterDesconto() {
        return 15;
    }

    @Override
    public String obterPromocao() {
        return "Promoção de fim de ano";
    }
    
}
