package br.com.ufjf.dcc078.Modelo;

/**
 * Estado ocupado
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class QuartoEstadoOcupado implements QuartoEstado {

    @Override
    public String getSigla() {
        return "O";
    }

    @Override
    public String getNome() {
        return "Ocupado";
    }

    @Override
    public void disponibilizar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto não disponçivel, pois se encontra ocupado.");
    }

    @Override
    public void ocupar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto já se encontra ocupado.");
    }
   
    @Override
    public void desfazer(Quarto quarto) {
        throw new UnsupportedOperationException("Ação desfeita");
    }
    
 
    
    @Override
    public void limpar(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoLimpeza());
    }

    @Override
    public void manutencao(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoManutencao());
    }

    @Override
    public void reservar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto está ocupado e não pode ser reservado.");
    }

}
