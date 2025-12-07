
/*
    Classe com menu inicial.
    Com Login, autenticação e cadastro de usuários
*/

package ui;

import java.util.Scanner;

import repository.ArmazTemporario;
import service.Apoio;

public class MenuInicial {
    public static void bemVindo() {

        Scanner scan = new Scanner(System.in);
        
        int opcao;
        do {
            System.out.println("\n****        EduConnect - Sistema de Gestão Educacional (SGE)        ****\n");
            System.out.println("************************************************************************");
            System.out.println("\nBem vindo(a) visitante.");
            System.out.println("\n***    Menu Inicial:    ***");
            System.out.println("***************************");
            System.out.println("\nFazer login como:");
            System.out.println("1 - Administrador(a)");
            System.out.println("2 - Professor(a)");
            System.out.println("3 - Aluno(a)");
            System.out.println("\nNão está cadastrado(a)?");
            System.out.println("4 - Fazer cadastro");
            System.out.println("\n5 - Encerrar sistema");
            System.out.print("\nDigite opção: ");  
            Apoio.validaNumeroMenu(scan);   // valida se número de menu digitado é número inteiro
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:     // login administrador:
                    System.out.println("\n\n**   Entrar como Administrador(a)   **");    
                    System.out.println("**************************************");

                    System.out.print("\nLogin de Administrador(a): ");
                    String loginADM = scan.nextLine();
                    
                    System.out.print("\nSenha de Administrador(a): ");
                    String senhaADM = scan.nextLine();

                    // autenticação do objeto usando método de apoio:
                    if (Apoio.autenticaUsuario(loginADM, senhaADM, ArmazTemporario.listaAdm)) {
                        MenuInterativoADM.menu();   // se autenticação for true = entra no menu de Administrador
                    }
                    break;

                case 2:     // login professor:
                    System.out.println("\n** Entrar como Professor(a): **");    
                    System.out.println("****************************");

                    System.out.print("\nDigite o Login: ");
                    String loginProf = scan.nextLine();
                    
                    System.out.print("\nDigite a Senha: ");
                    String senhaProf = scan.nextLine();
                      
                    // autenticação do objeto usando método de apoio:
                    if (Apoio.autenticaUsuario(loginProf, senhaProf, ArmazTemporario.listaProf)) {
                        MenuInterativoProfessor.menu(); // se autenticação for true = entra no menu de Professor
                    }
                    break;

                case 3:     // login aluno(a)
                    System.out.println("** Entrar como Aluno(a): **");    
                    System.out.println("***************************");

                    System.out.print("\nDigite o Login: ");
                    String loginAluno = scan.nextLine();
                    
                    System.out.print("\nDigite a Senha: ");
                    String senhaAluno = scan.nextLine();

                    if (Apoio.autenticaUsuario(loginAluno, senhaAluno, ArmazTemporario.listaAlunos)) {
                        MenuInterativoAluno.menu();
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
            }
        } while (opcao != 5);
    }
}


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