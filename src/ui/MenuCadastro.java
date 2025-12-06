package ui;

import java.util.Random;
import java.util.Scanner;

import repository.ArmazTemporario;
import service.Apoio;
import service.CadastraProfessor;

public class MenuCadastro {

    public static void novoCadastro() {

        Scanner scan = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("------------------------------------------------------------------------");
            
            System.out.println("\n\nCadastrar novo usuário:\n");
    
            System.out.println("\nFazer cadastro de:");
            System.out.println("\n1 - Professor(a)");
            System.out.println("\n2 - Aluno(a)");
            System.out.println("\n3 - Voltar ao Menu Inicial");
            System.out.print("\nDigite opção: ");
            Apoio.validaNumeroMenu(scan);

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1:
                    Random geraRegistro = new Random();
                    
                    int registro = geraRegistro.nextInt(999);
                   
                    if (!Apoio.evitaNumeroDuplicado(registro, ArmazTemporario.listaProf)) {
                        System.out.println("\n\nNão é possível cadastrar professor(a).");
                        System.out.println("\nO número de registro informado já foi cadastrado.\n\n");
                    } else {    // se registro informado não existir, continua cadastro no método da classe CadastraProfessor levando registro informado:
                        CadastraProfessor.cadastro(registro);
                    }
                    break;

                case 3:
                    System.out.println("\n\n");
                    break;

                default:
                    System.out.println("\n\n\nOpção inválida.\n\n");
            }

        } while (opcao != 3);
    }
}
