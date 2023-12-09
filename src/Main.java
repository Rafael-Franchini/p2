import java.util.List;
import java.util.Scanner;
import controler.controler;
public class Main {

    public static void menu(){
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Remover produto");
        System.out.println("3 - Atualizar produto");
        System.out.println("4 - Comprar produto");
        System.out.println("5 - Vender produto");
        System.out.println("6 - ver produto");
        System.out.println("7 - Listar Produtos");
        System.out.println("8 - Sair");
    }
    public static void main(String[] args) {

        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        while (!exit){
            menu();
            int op = sc.nextInt();
            switch (op){
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
                    exit = true;
                    break;
            }
        }
    }
}