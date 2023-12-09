package model;

public class Perfume extends Produto{
    private int ml;
    public Perfume(){};
    public void setMl(int ml) {
        this.ml = ml;
    }

    public int getTipo() {
        return ml;
    }
    @Override
    public void usar() {
        System.out.println("Usando perfume");
    }
}
