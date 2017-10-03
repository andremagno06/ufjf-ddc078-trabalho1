/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Quarto;

/**
 *
 * @author Desenvolvedor
 */
public class QuartoDAO {
    
    private static QuartoDAO instance;
    


    public static QuartoDAO getInstance() {
        return instance;
    }

    public static void setInstance(QuartoDAO instance) {
        QuartoDAO.instance = instance;
    }

    public void save(Quarto contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
