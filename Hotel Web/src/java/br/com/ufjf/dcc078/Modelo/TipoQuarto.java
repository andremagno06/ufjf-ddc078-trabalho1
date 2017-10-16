package br.com.ufjf.dcc078.Modelo;

public class TipoQuarto {

    private int id;
    private String nome;

    public TipoQuarto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
