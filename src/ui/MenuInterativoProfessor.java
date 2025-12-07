
/*
    classe Menu de Professor
*/

package ui;

import java.util.Scanner;

import repository.ArmazTemporario;
import service.Apoio;
import service.RegistraAvaliacoes;

public class MenuInterativoProfessor {
// método polimórfico para menus interativos:
    public static void menu() {
        
        Scanner scan = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("**             Menu              **");
            System.out.println("************************************");
            System.out.println("\n1 - Registrar avaliação");
            System.out.println("2 - Sair - Voltar ao Menu Inicial:");
            System.out.print("\nDigite opção: ");
            Apoio.validaNumeroMenu(scan); // valida se número de menu informado é número inteiro

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:     // registrar avalições:
                    if (ArmazTemporario.listaAlunos.isEmpty() || ArmazTemporario.listaTurmas.isEmpty()) {
                        System.out.println("\n\nErro: Não é possível registrar avaliação.");
                        System.out.println("\nProfessor, solicite ao Administrador(a) que adicione alunos em sua turma.\n\n");
                        break;
                    }
                    RegistraAvaliacoes.registrar();
                    break;
            
               case 2:
                   System.out.println("\n\nSaindo...\n");
                   System.out.println("\nAté logo, professor.\n");
                    break;

                default:
                    System.out.println("\n\nOpção inválida!\n");
            }
        } while (opcao != 2); 
    }
}