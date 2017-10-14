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

    @Override
    public float obterDesconto() {
        return 15/100;
    }

    @Override
    public String obterPromocao() {
        return "Promoção de fim de ano";
    }
    
}
