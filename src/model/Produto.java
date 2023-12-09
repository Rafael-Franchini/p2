package model;

public abstract class Produto {
    private String cod;
    private String descricao;
    private double preco;
    private String marca;
    private int quantidade;
    public Produto(){};

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCod() {
        return cod;
    }
    public abstract void usar();

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}
