package model;

public class Relogio extends Produto{

    private String tipo;
    public Relogio(){};
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    @Override
    public void usar() {
        System.out.println("Usando relogio");
    }
}
