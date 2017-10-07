package br.com.ufjf.dcc078.Modelo;

public class Quarto {

    private int id;
    private String descricao;
    private QuartoEstado estado;
    private int tipo_quarto_id;

    public Quarto() {
    }

    public Quarto(String descricao, QuartoEstado estado, int tipo_quarto_id) {
        this.descricao = descricao;
        this.estado = estado;
        this.tipo_quarto_id = tipo_quarto_id;
    }

    public Quarto(int id, String descricao, QuartoEstado estado, int tipo_quarto_id) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
        this.tipo_quarto_id = tipo_quarto_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public QuartoEstado getEstado() {
        return estado;
    }

    public void setEstado(QuartoEstado estado) {
        this.estado = estado;
    }

    public int getTipo_quarto_id() {
        return tipo_quarto_id;
    }

    public void setTipo_quarto_id(int tipo_quarto_id) {
        this.tipo_quarto_id = tipo_quarto_id;
    }

}
