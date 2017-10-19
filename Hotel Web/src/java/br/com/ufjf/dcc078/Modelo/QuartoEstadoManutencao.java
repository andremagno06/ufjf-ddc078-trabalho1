package br.com.ufjf.dcc078.Modelo;

/**
 * Estado Manutenção
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class QuartoEstadoManutencao implements QuartoEstado {

    @Override
    public String getSigla() {
        return "M";
    }

    @Override
    public String getNome() {
        return "Manutenção";
    }

    @Override
    public void disponibilizar(Quarto quarto) {
       quarto.setEstado(new QuartoEstadoDisponivel());
    }

    @Override
    public void ocupar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto não pode ser ocupado, pois está em manutenção.");
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
        quarto.setEstado(this);
    }

    @Override
    public void reservar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto está em manutenção e não pode ser reservado."); 
    }

}
