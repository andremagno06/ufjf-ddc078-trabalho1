package br.com.ufjf.dcc078.Modelo;

public class QuartoEstadoReservado implements QuartoEstado{

    @Override
    public String getSigla() {
        return "R";
    }

    @Override
    public String getNome() {
        return "Reservado";
    }

    @Override
    public void disponibilizar(Quarto quarto) {
       quarto.setEstado(new QuartoEstadoDisponivel());
    }

     @Override
    public void desfazer(Quarto quarto) {
        throw new UnsupportedOperationException("Ação desfeita");
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

    @Override
    public void reservar(Quarto quarto) {
        throw new UnsupportedOperationException("Quarto se encontra reservado");
    }
    
}
