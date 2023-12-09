package dao;

import model.Produto;

import java.util.ArrayList;

public class Carrinho implements CarrinhoDB {
    static private final ArrayList<Produto> carrinho = new ArrayList<>();
   static private Carrinho instancia = null;


   //Construtor de um singleton é privado!
   private Carrinho() { }
   static public Carrinho getInstancia() {
       if (instancia == null)
           instancia = new Carrinho();
       return instancia;
   }
   @Override
   public void delete(String cod) {
       carrinho.removeIf((a) -> a.getCod().equals(cod));
       System.out.println("Produto deletado com sucesso!");
   }

   @Override
   public void add(Produto e) {
       carrinho.add(e);
       System.out.println("Produto adicionado com sucesso!");
   }
   public ArrayList<Produto> listar(){
       ArrayList<Produto> lista = new ArrayList<>();
       for(Produto e:carrinho){
           lista.add(e);
       }
       return lista;
   }

   @Override
   public Produto get(String cod) {
           return carrinho.stream().filter(e -> e.getCod().equals(cod)).findFirst().orElse(null);
   }
   public void limpar(){
       carrinho.clear();
   }
}
