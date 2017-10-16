
package br.com.ufjf.dcc078.Modelo;

public class QuartoFamilia extends Quarto{

    public QuartoFamilia(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        super(descricao, estado, tipo_quarto_id);
        
    }

    public QuartoFamilia() {
        this.setTipoQuarto("Familia");
        this.promocao = new PromocaoDiaCriancas();
    }
    
    @Override
    public String tipoQuarto() {
        
        return "Familia";
    }

}
