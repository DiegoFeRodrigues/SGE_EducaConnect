
/*
    classe Menu de Aluno
*/

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
            System.out.println("***           Menu:           ***");
            System.out.println("*********************************");
            // System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("\n1 - Consultar avaliações registradas");
            System.out.println("2 - Sair - Voltar ao Menu Inicial");
            System.out.print("\nDigite opção: ");
            Apoio.validaNumeroMenu(scan); // valida numero inteiro no menu

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1: // resultado avaliações:
                    if (ArmazTemporario.listaAvaliacoes.isEmpty()) {
                        System.out.println("\n\nAté o momento nenhuma avaliação foi registrada.\n\n");
                    } else {
                        System.out.println("\n\nResultado de avaliações:");
                        for (Avaliacao avaliacao : ArmazTemporario.listaAvaliacoes) {
                            System.out.println(avaliacao.resultadoAvaliacao());
                        }
                        System.out.println("\n\n");
                    }
                    break;
               case 2:
                    System.out.println("\n\nSaindo...\n");
                    break;

                default:
                    System.out.println("\n\nOpção inválida!\n");
            }
        } while (opcao != 2); 
    }
}