package br.com.ufjf.dcc078.Modelo;

/**
 * Estado Manutenção
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class QuartoEstadoManutencao implements QuartoEstado {

    @Override
    public String getNome() {
        return "Manutenção";
    }

    @Override
    public void disponibilizar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto em manutenção.");
    }

    @Override
    public void ocupar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto em manutenção.");
    }

    @Override
    public void limpar(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoLimpeza());
    }

    @Override
    public void manutencao(Quarto quarto) {
        quarto.setEstado(this);
    }

}
