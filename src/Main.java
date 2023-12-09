import java.util.List;
import java.util.Scanner;
import controler.controler;
public class Main {

    public static void menu(){
        System.out.println("1 - Estoque");
        System.out.println("2 - carrinho");
        System.out.println("3 - Listar Produtos");
        System.out.println("4 - Sair");
    }
    static void menu2(){
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Remover produto");
        System.out.println("3 - Atualizar produto");
        System.out.println("4 - Comprar");
        System.out.println("5 - Vender");
        System.out.println("6 - Vizualizar produto");
        System.out.println("7 - Listar produtos");
        System.out.println("8 - Sair");
    }
    static void menu3(){
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Remover produto");
        System.out.println("3 - ver itens do carrinho");
        System.out.println("4 - Comprar");
        System.out.println("5 - retornar");
    }
    public static void main(String[] args) {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        while (!exit){
            menu();
            int op = sc.nextInt();
           switch (op){
               case 1:
                   menu2();
                   int op2 = sc.nextInt();
                   switch (op2){
                        case 1:
                            System.out.println("Digite o codigo do produto");
                            String cod = sc.next();
                            System.out.println("Digite a descricao do produto");
                            String descricao = sc.next();
                            System.out.println("Digite o preco do produto");
                            double preco = sc.nextDouble();
                            System.out.println("Digite a quantidade do produto");
                            int quantidade = sc.nextInt();
                            System.out.println("Digite a marca do produto");
                            String marca = sc.next();
                            System.out.println("Digite o tipo do produto");
                            System.out.println("1 - Relogio");
                            System.out.println("2 - Perfume");
                            int opcao = sc.nextInt();
                            controler.AdicionaProd(cod,descricao,preco,quantidade,marca,opcao);
                            break;
                        case 2:
                            System.out.println("Digite o codigo do produto");
                            String cod1 = sc.next();
                            controler.RemoveProd(cod1);
                            break;
                        case 3:
                            controler.Update();
                            break;
                        case 4:
                            controler.compravenda(2);
                            break;
                        case 5:
                            controler.compravenda(1);
                            break;
                        case 6:
                            controler.vizualizar();
                            break;
                        case 7:
                            System.out.println("Lista de produtos:");
                            controler.listar();
                            break;
                        case 8:
                            System.out.println("Saindo...");
                            break;
                   }
                   break;
               case 2:
                    menu3();
                    int op3 = sc.nextInt();
                    switch (op3){
                        case 1:
                            controler.AdicionarCarrinho();
                            break;
                        case 2:
                            controler.RemoverCarrinho();
                            break;
                        case 3:
                            controler.VizualizarCarrinho();
                            break;
                        case 4:
                            controler.ComprarCarrinho();
                            break;
                        case  5:
                            System.out.println("Retornando...");
                            break;
                    }
                   break;
               case 3:
                   System.out.println("Lista de produtos Estoque:");
                   controler.listar();
                   break;
               case 4:
                     System.out.println("Saindo...");
                     exit=true;
                     break;

           }
        }
    }
}