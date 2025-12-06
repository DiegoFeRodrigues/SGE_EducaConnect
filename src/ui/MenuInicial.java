package ui;

import java.util.Scanner;

import model.Administrador;
import model.Aluno;
import model.Professor;
import repository.ArmazTemporario;
import service.Apoio;

public class MenuInicial {
    public static void bemVindo() {

        
        Scanner scan = new Scanner(System.in);
        
        int opcao;
        do {
            System.out.println(ArmazTemporario.listaProf);
            System.out.println("------------------------------------------------------------------------");
            
            System.out.println("\n\nBem vindo(a)");
            System.out.println("\n\n*** Menu Inicial: ***");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("\nFazer login como:");
            System.out.println("\n\n1 - Administrador(a)");
            System.out.println("\n2 - Professor(a)");
            System.out.println("\n3 - Aluno(a)");
            System.out.println("\n\nAinda não está cadastrado(a)?");
            System.out.println("\n4 - Fazer cadastro");
            System.out.println("\n\n5 - Encerrar sistema");
            System.out.print("\nDigite opção: ");  
            Apoio.validaNumeroMenu(scan);   // valida se número de menu digitado é número inteiro
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("\nDigite login e senha de Administrador(a):");    

                    System.out.print("\nLogin: ");
                    String loginADM = scan.nextLine();
                    
                    System.out.print("\nSenha: ");
                    String senhaADM = scan.nextLine();

                    if (Apoio.listaObjetos(loginADM, senhaADM, ArmazTemporario.listaAdm)) {
                        MenuInterativo.menu();
                    }
                    break;

                case 2:
                    System.out.println("\nDigite login e senha de Professor(a):");    

                    System.out.print("\nLogin: ");
                    String loginProf = scan.nextLine();
                    
                    System.out.print("\nSenha: ");
                    String senhaProf = scan.nextLine();
                    
                    // for (Professor prof : ArmazTemporario.listaProf) {
                    //     if (loginProf.equals(prof.getLogin())) {
                    //         prof.autenticar(loginProf, senhaProf);
                    //         MenuInterativo.Menu();
                    //         break;
                    //     } else {
                    //         prof.autenticar(loginProf, senhaProf);
                    //     }
                    // }
                    


                    // for (int cont = 0; cont < ArmazTemporario.listaProf.size(); cont++) {
                    //     for (Professor prof : ArmazTemporario.listaProf) {
                    //         if (loginProf.equals(prof.getLogin())) {
                    //             prof.autenticar(loginProf, senhaProf);
                    //             MenuInterativo.Menu();
                    //             break;
                    //         }
                    //         prof.autenticar(loginProf, senhaProf);
                    //     }
                    //     break;
                    // }
                    //  
                    if (Apoio.listaObjetos(loginProf, senhaProf, ArmazTemporario.listaProf)) {
                        MenuInterativo.menu();
                    } else {
                        System.out.println("Falha ao autenticar professor(a): Login ou senha incorretos.\n\n");
                    }
                    break;

                case 3:
                    System.out.println("\nDigite login e senha do Aluno(a):");    

                    System.out.print("\nLogin: ");
                    String loginAluno = scan.nextLine();
                    
                    System.out.print("\nSenha: ");
                    String senhaAluno = scan.nextLine();

                    int numeroAluno = Apoio.numeroAluno(loginAluno);
                    if (Apoio.listaObjetos(loginAluno, senhaAluno, ArmazTemporario.listaAlunos)) {
                        
                        MenuInterativoAluno.menu(numeroAluno);
                    } else {
                        System.out.println("Falha ao autenticar aluno(a): Login ou senha incorretos.\n\n");
                    }

                    break;

                case 4:
                    MenuCadastro.novoCadastro();
                    break;
                    
                case 5:
                    System.out.println("\n\nEncerrando...\n\n");
                    break;
                default :
                    System.out.println("\n\nOpção inválida.\n\n");
                    break;
            }
        } while (opcao != 5);

    }
}

