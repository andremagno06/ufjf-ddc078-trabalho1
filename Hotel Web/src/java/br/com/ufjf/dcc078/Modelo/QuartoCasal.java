package br.com.ufjf.dcc078.Modelo;

public class QuartoCasal extends Quarto {

    public QuartoCasal() {
        this.setTipoQuarto("Casal");
        this.promocao = new PromocaoInverno();
    }

    public QuartoCasal(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);

    }

    @Override
    public String tipoQuarto() {
        return "Casal";
    }

}
