package br.com.ufjf.dcc078.Modelo;

/**
 * Estado Disponível
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class QuartoEstadoDisponivel implements QuartoEstado {
    
    @Override
    public String getNome() {
        return "Disponível";
    }
    
    @Override
    public void disponibilizar(Quarto quarto) {
        quarto.setEstado(this);
    }
    
    @Override
    public void ocupar(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoOcupado());
    }
    
    @Override
    public void limpar(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoLimpeza());
    }
    
    @Override
    public void manutencao(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoManutencao());
    }
    
}
