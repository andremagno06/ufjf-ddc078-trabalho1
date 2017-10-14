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
public class PromocaoDiaCriancas implements Promocao{

    @Override
    public float obterDesconto() {
        return 25/100;
    }

    @Override
    public String obterPromocao() {
        return "Promoção do dia das crianças";
    }
    
}
