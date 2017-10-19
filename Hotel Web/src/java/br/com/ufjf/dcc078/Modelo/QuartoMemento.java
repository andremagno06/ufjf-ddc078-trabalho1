
package br.com.ufjf.dcc078.Modelo;

import br.com.ufjf.dcc078.Modelo.QuartoEstado;

/**
 *
 * @author Desenvolvedor
 */
public class QuartoMemento {
    

    private QuartoEstado estado;
    
     public QuartoMemento(QuartoEstado estadoSalvar) {
        estado = estadoSalvar;
        
    }

    public QuartoMemento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public QuartoEstado getEstadoSalvo(){
        return estado;
    }
 
    
}
