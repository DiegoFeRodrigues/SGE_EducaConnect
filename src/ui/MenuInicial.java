package ui;

import java.util.Scanner;

import model.Administrador;
import repository.ArmazTemporario;
import service.Apoio;

public class MenuInicial {
    public static void bemVindo() {

        Scanner scan = new Scanner(System.in);
        
        int opcao;
        do {
            System.out.println("*************************************************************");
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****");
            System.out.println("\n\nBem vindo(a)");
            System.out.println("\n\n\nFazer login como:");
            System.out.println("\n\n1 - Administrador(a):");
            System.out.println("\n2 - Professor(a):");
            System.out.println("\n3 - Aluno(a):");
            System.out.println("\n\nAinda não está cadastrado(a)?");
            System.out.println("\n4 - Fazer cadastro:");
            System.out.print("\nDigite opção: ");  
            Apoio.validaNumeroMenu(scan);
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    
                    Administrador adm = new Administrador("adm", "000");
                
                    System.out.print("\nLogin de Administrador: ");
                    String login = scan.nextLine();
                    
                    System.out.print("\nSenha de Administrador: ");
                    String senha = scan.nextLine();
                    adm.autenticar(login, senha);
                    // if ()) {
                    //     MenuInterativo.Menu();
                    //     break;
                    // }
                    // try {
                    // }
                    // catch (NullPointerException | IllegalArgumentException npeOUiae) {
                    //     System.err.println("Erro: "+npeOUiae);
                    // }
                    break;
                    
                default :
                    System.out.println("\nOpção inválida.");
            }
        } while (opcao != 2);

    }
}

