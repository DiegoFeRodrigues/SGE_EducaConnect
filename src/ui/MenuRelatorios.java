package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Turma;

public class MenuRelatorios {

    public static void menu() {

        // instanciando novo scanner - input do usuário
        Scanner scan = new Scanner(System.in);

        // variável de controle - escolha:
        int escolha;

        // do-while para repetir menu de escolha (executa ao menos uma vez, testa no final):
            do {
                // menu:
                System.out.print("\n\n*** Gerar relatórios: ***");
                System.out.println("\n*************************\n");
                System.out.println("Digite 1 - Alunos matriculados");
                System.out.println("Digite 2 - Professores registrados");
                System.out.println("Digite 3 - Cursos cadastrados");
                System.out.println("Digite 4 - Turmas");
                System.out.println("Digite 5 - Sair");
                System.out.print("Digite o número do relatório desejado ou 5 para sair: ");
                // lendo escolha do usuário:
                escolha = scan.nextInt();
                scan.nextLine();
                // usando switch-case para selecionar escolha do usuário:
                switch (escolha) {
                    case 1 :    // alunos:
                        System.out.println("\n\n** Relatório de alunos matriculados **\n");
                        for (Aluno alunos : ArmazTemporario.listaAlunos) {
                            System.out.println(alunos.gerarRelatorio());
                        }
                        System.out.println("------------------------------------------------------------------------");
                        break;
                    case 2:     // professores:
                        System.out.println("\n\n** Relatório de professores registrados **");
                        for (Professor prof : ArmazTemporario.listaProf) {
                            System.out.println(prof.gerarRelatorio());
                        }
                        System.out.println("------------------------------------------------------------------------");
                        break;
                    case 3:     // cursos:
                        System.out.println("\n\n** Relatório de cursos cadastrados **");
                        for (Curso cursos : ArmazTemporario.listaCursos) {
                            System.out.println(cursos.gerarRelatorio());
                        }
                        System.out.println("------------------------------------------------------------------------");
                        break;
                    case 4:     // turmas:
                        System.out.println("\n\n** Relatorio de turmas **");
                        for (Turma turma : ArmazTemporario.listaTurmas) {
                            System.out.println(turma.resumoTurma());
                        }
                        System.out.println("------------------------------------------------------------------------");
                        break;
                    case 5:     // sair:
                        System.out.println("\nSaindo.\n"); 
                        System.out.println("------------------------------------------------------------------------");
                        break;
                    default :   // se escolha != de 1, 2, 3, 4 ou 5 = opção inválida.
                    System.out.println("\nOpção inválida!"); 
                    break;
                }
            } while (escolha != 5); // se escolha != de 5 repete do-while
            scan.close();
    }
}

// instanciando objeto da classe que contém as listas
        // ArmazTemporario listaAlu = new ArmazTemporario();

        // ArmazTemporario listaPro = new ArmazTemporario();
        // listaPro.adicionaProf();

        // ArmazTemporario listaCursos = new ArmazTemporario();
        