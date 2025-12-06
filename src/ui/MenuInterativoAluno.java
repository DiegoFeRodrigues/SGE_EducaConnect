package ui;

import java.util.Scanner;

import repository.ArmazTemporario;
import service.Apoio;
import service.Avaliacao;

public class MenuInterativoAluno {
    // método polimórfico para menus interativos:
    public static void menu(int numero) {
        
        Scanner scan = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("*** Menu Interativo: ***");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("1 - Consultar avaliações registradas");
            System.out.println("2 - Fazer logoff - Voltar ao Menu Inicial:");
            System.out.print("Digite opção:");
            Apoio.validaNumeroMenu(scan);

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    if (numero >= ArmazTemporario.listaAvaliacoes.size()) {
                        System.out.println("Você não tem avaliações registradas ainda.");
                    } else {
                        Avaliacao avaliacaoAluno = ArmazTemporario.listaAvaliacoes.get(numero);
                        System.out.println(avaliacaoAluno.resultadoAvaliacao());
                    }
                    break;
            
               case 2:
                    System.out.println("\nSaindo da sua conta...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
            }
        } while (opcao != 2); 
    }
}
