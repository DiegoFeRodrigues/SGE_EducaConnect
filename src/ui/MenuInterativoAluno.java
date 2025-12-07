package ui;

import java.util.Scanner;

import repository.ArmazTemporario;
import service.Apoio;
import service.Avaliacao;

public class MenuInterativoAluno {
    // método polimórfico para menus interativos:
    public static void menu() {
        
        Scanner scan = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("\n\n***           Menu:           ***");
            System.out.println("*********************************");
            // System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("\n1 - Consultar avaliações registradas");
            System.out.println("2 - Sair - Voltar ao Menu Inicial");
            System.out.print("\nDigite opção:");
            Apoio.validaNumeroMenu(scan); // valida numero inteiro no menu

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1: // resultado avaliações:
                    System.out.println("Resultado de avaliações:");
                    for (Avaliacao avaliacao : ArmazTemporario.listaAvaliacoes) {
                        System.out.println(avaliacao.resultadoAvaliacao());
                    }
                    break;
               case 2:
                    System.out.println("\n\n\nSaindo...\n");
                    break;

                default:
                    System.out.println("\n\n\nOpção inválida!\n");
            }
        } while (opcao != 2); 
    }
}
