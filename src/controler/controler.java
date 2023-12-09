package controler;
import model.Produto;
import  model.Relogio;
import model.Perfume;
import dao.BancoDAO;
import dao.Carrinho;
import dao.bancodedados;

import java.util.ArrayList;
import java.util.Scanner;

public class controler {
    public static void AdicionaProd(String cod, String descricao, double preco, int quantidade,String marca, int opcao){
        Scanner sc = new Scanner(System.in);
        Produto input=null;
        if(opcao==1){
            input = new Relogio();
            input.setDescricao(descricao);
            input.setCod(cod);
            input.setPreco(preco);
            input.setQuantidade(quantidade);
            input.setMarca(marca);
            System.out.println("Relogio de qual tipo?");
            System.out.println("1 - Analogico");
            System.out.println("2 - Digital");
            System.out.println("2 - Quartz");
            int tipo = sc.nextInt();
            if(tipo==1){
                ((Relogio) input).setTipo("Analogico");
            }
            else if(tipo==2){
                ((Relogio) input).setTipo("Digital");
            }
            else if(tipo==3){
                ((Relogio) input).setTipo("Quartz");
            }
            else{
                System.out.println("Opcao invalida");
            }
        }
        else if(opcao==2){
            input = new Perfume();
            input.setDescricao(descricao);
            input.setCod(cod);
            input.setPreco(preco);
            input.setQuantidade(quantidade);
            input.setMarca(marca);
            System.out.println("Perfume de quantos ml?");
            int ml = sc.nextInt();
            ((Perfume) input).setMl(ml);
        }
        BancoDAO.getInstancia().add(input);
    }
    public static void RemoveProd(String cod){
        BancoDAO.getInstancia().delete(cod);
    }
    public static void vizualizar(){
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Digite o codigo do produto que deseja vizualizar");
        op=sc.nextLine();
        Produto e=BancoDAO.getInstancia().get(op);
        if(e!=null){
            System.out.println("Codigo: "+e.getCod());
            System.out.println("Descricao: "+e.getDescricao());
            System.out.println("Preco: "+e.getPreco());
            System.out.println("Quantidade: "+e.getQuantidade());
            System.out.println("Marca: "+e.getMarca());
            if(e instanceof Relogio){
                System.out.println("Tipo: "+((Relogio) e).getTipo());
            }
            else if(e instanceof Perfume){
                System.out.println("Ml: "+((Perfume) e).getTipo());
            }
        }
        else{
            System.out.println("Produto nao encontrado");
        }
    }
    public static void Update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo do produto que deseja atualizar");
        String cod=sc.nextLine();
        Produto e=BancoDAO.getInstancia().get(cod);
        if(e!=null){
            System.out.println("Digite a nova descricao");
            String descricao=sc.nextLine();
            System.out.println("Digite o novo preco");
            double preco=sc.nextDouble();
            System.out.println("Digite a nova quantidade");
            int quantidade=sc.nextInt();
            System.out.println("Digite a nova marca");
            String marca=sc.nextLine();
            if(e instanceof Relogio){
                System.out.println("Digite o novo tipo");
                System.out.println("Analogico");
                System.out.println("Digital");
                System.out.println("Quartz");
                String tipo=sc.nextLine();
                ((Relogio) e).setTipo(tipo);
            }
            else if(e instanceof Perfume){
                System.out.println("Digite o novo ml");
                int ml=sc.nextInt();
                ((Perfume) e).setMl(ml);
            }
            e.setDescricao(descricao);
            e.setPreco(preco);
            e.setQuantidade(quantidade);
            e.setMarca(marca);
            BancoDAO.getInstancia().update(e);
        }
        else{
            System.out.println("Produto nao encontrado");
        }
    }
    public static void compravenda(int op){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo do produto");
        String cod=sc.nextLine();
        Produto e=BancoDAO.getInstancia().get(cod);
        if(e!=null){
            if(op==1){
                System.out.println("Digite a quantidade que deseja vender");
                int quantidade=sc.nextInt();
                if(e.getQuantidade()>=quantidade){
                    e.setQuantidade(e.getQuantidade()-quantidade);
                    BancoDAO.getInstancia().update(e);
                }
                else{
                    System.out.println("Quantidade insuficiente");
                }
            }
            else if(op==2){
                System.out.println("Digite a quantidade que deseja comprar");
                int quantidade=sc.nextInt();
                e.setQuantidade(e.getQuantidade()+quantidade);
                BancoDAO.getInstancia().update(e);
            }
        }
        else{
            System.out.println("Produto nao encontrado");
        }
    }
    public static void listar(){
        ArrayList<Produto> lista = BancoDAO.getInstancia().listar();
        double total=0;
        if(lista.isEmpty()){
            System.out.println("Nao ha produtos cadastrados");
        }else{
            for(Produto e:lista){
            System.out.println("Codigo: "+e.getCod());
            System.out.println("Descricao: "+e.getDescricao());
            System.out.println("Preco: "+e.getPreco());
            System.out.println("Quantidade: "+e.getQuantidade());
            System.out.println("Marca: "+e.getMarca());
            if(e instanceof Relogio){
                System.out.println("Tipo: "+((Relogio) e).getTipo());
            }
            else if(e instanceof Perfume){
                System.out.println("Ml: "+((Perfume) e).getTipo());
            }
            total+=e.getPreco()*e.getQuantidade();
        }
            System.out.println("Total: "+total);
        }
    }
    public static void AdicionarCarrinho(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo do produto que deseja adicionar ao carrinho\n");
        String cod = sc.next();
        Produto e=BancoDAO.getInstancia().get(cod);
        if(e!=null){
            System.out.println("Digite a quantidade que deseja adicionar ao carrinho\n");
            int quantidade = sc.nextInt();
            if(e.getQuantidade()>=quantidade){
                e.setQuantidade(e.getQuantidade()-quantidade);
                BancoDAO.getInstancia().update(e);
                e.setQuantidade(quantidade);
                Carrinho.getInstancia().add(e);
            }
            else{
                System.out.println("Quantidade insuficiente");
            }
        }
        else{
            System.out.println("Produto nao encontrado");
        }
    }
    public static void RemoverCarrinho(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo do produto que deseja remover do carrinho\n");
        String cod = sc.next();

        Produto e=Carrinho.getInstancia().get(cod);
        if(e!=null){
            System.out.println("Digite a quantidade que deseja remover do carrinho\n");
            int quantidade = sc.nextInt();
            if(e.getQuantidade()>=quantidade){
                e.setQuantidade(e.getQuantidade()+quantidade);
                BancoDAO.getInstancia().update(e);
                Carrinho.getInstancia().delete(cod);
            }
            else{
                System.out.println("Quantidade insuficiente");
            }
        }
        else{
            System.out.println("Produto nao encontrado");
        }
    }
    public static void VizualizarCarrinho(){
        ArrayList<Produto> lista = Carrinho.getInstancia().listar();
        double total=0;
        if(lista.isEmpty()){
            System.out.println("Nao ha produtos no carrinho");
        }else{
            for(Produto e:lista){
                System.out.println("Codigo: "+e.getCod());
                System.out.println("Descricao: "+e.getDescricao());
                System.out.println("Preco: "+e.getPreco());
                System.out.println("Quantidade: "+e.getQuantidade());
                System.out.println("Marca: "+e.getMarca());
                total+=e.getPreco()*e.getQuantidade();
                if(e instanceof Relogio){
                    System.out.println("Tipo: "+((Relogio) e).getTipo());
                }
                else if(e instanceof Perfume){
                    System.out.println("Ml: "+((Perfume) e).getTipo());
                }
            }
            System.out.println("Total: "+total);
        }
    }
    public static void ComprarCarrinho(){
        Scanner sc = new Scanner(System.in);
        VizualizarCarrinho();
        System.out.println("Deseja comprar o carrinho?");
        System.out.println("1 - Sim");
        System.out.println("2 - Nao");
        int op = sc.nextInt();
        if(op==1){
            System.out.println("Forma de pagamento");
            System.out.println("1 - Dinheiro");
            System.out.println("2 - Cartao");
            int op2 = sc.nextInt();
            if(op2==1){
                System.out.println("Digite o valor pago");
                double valor = sc.nextDouble();
                ArrayList<Produto> lista = Carrinho.getInstancia().listar();
                double total=0;
                for(Produto e:lista){
                    total+=e.getPreco()*e.getQuantidade();
                }
                if(valor>=total){
                    System.out.println("Troco: "+(valor-total));
                    Carrinho.getInstancia().limpar();
                }
                else{
                    System.out.println("Valor insuficiente");
                }
            }
            else if(op2==2){
                System.out.println("1 - Credito");
                System.out.println("2 - Debito");
                int cartao = sc.nextInt();
                ArrayList<Produto> lista = Carrinho.getInstancia().listar();
                double total=0;
                for(Produto e:lista){
                    total+=e.getPreco()*e.getQuantidade();
                }
                System.out.println("Valor: "+total);
                if (cartao==1){
                    System.out.println("Compra realizada no credito");
                    Carrinho.getInstancia().limpar();
                }
                else if(cartao==2){
                    System.out.println("Compra realizada no debito");
                    Carrinho.getInstancia().limpar();
                }
                else{
                    System.out.println("Opcao invalida");
                }
            }
            else{
                System.out.println("Opcao invalida");
            }
        }else{
            System.out.println("Compra cancelada");
        }
    }
}
