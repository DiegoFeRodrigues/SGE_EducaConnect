
/*
    Classe para cadastro de novos usuários (Professores e Alunos)
    Gera números de registro (professor) e matrícula (alunos) aleatórios (até 999)
    Usa método de apoio que evita números duplicados
*/

package ui;

import java.util.Random;
import java.util.Scanner;

import repository.ArmazTemporario;
import service.Apoio;
import service.CadastraAluno;
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
            Apoio.validaNumeroMenu(scan); // valida se número de menu digitado é número inteiro
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1:     // cadastro de novo professor:
                        Random geraRegistro = new Random();     // GERA REGISTRO ALETÓRIO - até 999 
                        int registro = geraRegistro.nextInt(999);
                        
                        // método de apoio evita números de registro duplicados:
                        if (!Apoio.evitaNumeroDuplicado(registro, ArmazTemporario.listaProf)) {
                            System.out.println("\n\nNão é possível cadastrar professor(a).");
                            System.out.println("\nO número de registro informado já foi cadastrado.");
                            System.out.println("\nPor favor, tente fazer um novo cadastro.\n\n");
                        } else {    // se registro informado não existir, continua cadastro no método da classe CadastraProfessor levando registro gerado:
                            CadastraProfessor.cadastro(registro);
                        }
                        break;
                    
                    case 2:     // cadastro de novo aluno:
                        Random geraMatricula = new Random();    // GERA MATRÍCULA ALETÓRIA - até 999 
                        int matricula = geraMatricula.nextInt(999);
                        
                        // método de apoio evita números de registro duplicados:
                        if (!Apoio.evitaNumeroDuplicado(matricula, ArmazTemporario.listaProf)) {
                            System.out.println("\n\nNão é possível cadastrar aluno(a).");
                            System.out.println("\nO número de registro informado já foi cadastrado.\n\n");
                            System.out.println("\nPor favor, tente fazer um novo cadastro.\n\n");
                    } else {    // se registro informado não existir, continua cadastro no método da classe CadastraProfessor levando registro gerado:
                        CadastraAluno.cadastro(matricula);
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
