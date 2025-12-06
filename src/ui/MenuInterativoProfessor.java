package ui;

import java.util.Scanner;

import service.Apoio;
import service.RegistraAvaliacoes;

public class MenuInterativoProfessor {
// método polimórfico para menus interativos:
    public static void menu() {
        
        Scanner scan = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("*** Menu Interativo: ***");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("1 - Registrar avaliação");
            System.out.println("2 - Fazer logoff - Voltar ao Menu Inicial:");
            System.out.print("Digite opção:");
            Apoio.validaNumeroMenu(scan);

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    RegistraAvaliacoes.registrar();
                    break;
            
               case 2:
                   System.out.println("\nSaindo da sua conta...\n");
                   System.out.println("\nAté logo, professor.\n");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
            }
        } while (opcao != 2); 
    }
}