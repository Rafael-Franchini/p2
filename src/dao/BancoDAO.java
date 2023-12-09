package dao;
import model.Produto;
import java.util.ArrayList;
public class BancoDAO implements bancodedados {
       static private final ArrayList<Produto> db = new ArrayList<>();
   static private BancoDAO instancia = null;


   //Construtor de um singleton é privado!
   private BancoDAO() { }
   static public BancoDAO getInstancia() {
       if (instancia == null)
           instancia = new BancoDAO();
       return instancia;
   }
   @Override
   public void delete(String cod) {
       db.removeIf((a) -> a.getCod().equals(cod));
       System.out.println("Produto deletado com sucesso!");
   }
   @Override
   public void update(Produto e) {
       Produto resultado = this.get(e.getCod());
       resultado.setCod(e.getCod());
       resultado.setDescricao(e.getDescricao());
       resultado.setQuantidade(e.getQuantidade());
       resultado.setPreco(e.getPreco());
   }
   @Override
   public void add(Produto e) {
       db.add(e);
       System.out.println("Produto adicionado com sucesso!");
   }
   public ArrayList<Produto> listar(){
       ArrayList<Produto> lista = new ArrayList<>();
       for(Produto e:db){
           lista.add(e);
       }
       return lista;
   }

   @Override
   public Produto get(String cod) {
           return db.stream().filter(e -> e.getCod().equals(cod)).findFirst().orElse(null);
   }
}
