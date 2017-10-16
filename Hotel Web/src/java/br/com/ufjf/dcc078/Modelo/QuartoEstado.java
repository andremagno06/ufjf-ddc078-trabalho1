package br.com.ufjf.dcc078.Modelo;

/**
 * Estados dos quartos
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public interface QuartoEstado {

    public String getSigla();

    public String getNome();

    public void disponibilizar(Quarto quarto);

    public void ocupar(Quarto quarto);

    public void limpar(Quarto quarto);

    public void manutencao(Quarto quarto);
    
    public void reservar(Quarto quarto);
}
