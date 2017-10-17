
package br.com.ufjf.dcc078.Modelo;

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
      estado= null;
    }
    
    public QuartoEstado getEstadoSalvo(){
        return estado;
    }
 
    
}
