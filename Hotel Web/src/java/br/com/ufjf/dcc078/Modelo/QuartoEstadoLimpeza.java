package br.com.ufjf.dcc078.Modelo;

/**
 * Estado Limpeza
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class QuartoEstadoLimpeza implements QuartoEstado {
    @Override
    public String getSigla() {
        return "L";
    }

    @Override
    public String getNome() {
        return "Limpeza";
    }

    @Override
    public void disponibilizar(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoDisponivel());
    }

    @Override
    public void ocupar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto não pode ser ocupado.");
    }

    @Override
    public void limpar(Quarto quarto) {
        quarto.setEstado(this);
    }

    @Override
    public void manutencao(Quarto quarto) {
        quarto.setEstado(new QuartoEstadoManutencao());
    }
}
