package br.com.ufjf.dcc078.Modelo;

/**
 * Estado ocupado
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class QuartoEstadoOcupado implements QuartoEstado {

    @Override
    public String getNome() {
        return "Ocupado";
    }

    @Override
    public void disponibilizar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto ocupado.");
    }

    @Override
    public void ocupar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto ocupado.");
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
