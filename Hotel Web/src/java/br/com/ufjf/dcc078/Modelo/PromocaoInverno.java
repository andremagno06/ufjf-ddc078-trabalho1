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
public class PromocaoInverno implements Promocao{

    public PromocaoInverno() {
    }

    
    
    @Override
    public int obterDesconto() {
        return 10;
    }

    @Override
    public String obterPromocao() {
        return "Promocao de inverno";
    }
    
}
