package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.Turma;

public class MenuRelatorios {

    public void menuRelatorios() {
        Scanner scan = new Scanner(System.in);
        
        // instanciando novo scanner - input do usuário
        // variável de controle - escolha:
        int escolha;
        // do-while para repetir menu de escolha (executa ao menos uma vez, testa no final):
        do {
            // menu:
            System.out.print("\n\n\n*** Gerar relatórios: ***");
            System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("1 - Alunos matriculados");
            System.out.println("2 - Professores registrados");
            System.out.println("3 - Cursos cadastrados");
            System.out.println("4 - Turmas criadas");
            System.out.println("5 - Resultado de avaliações");
            System.out.println("6 - Voltar ao Menu Interativo");
            System.out.print("Digite o número do relatório desejado ou 6 para voltar ao Menu Interativo: ");
            // lendo escolha do usuário:
            escolha = scan.nextInt();
            scan.nextLine();
            // usando switch-case para selecionar escolha do usuário:
            switch (escolha) {
                case 1 :    // alunos:
                    if (ArmazTemporario.listaAlunos.isEmpty()) {
                        System.out.println("\n\nO sistema não possui nenhum aluno cadastrado.");
                    } else {
                        System.out.println("\n\n** Relatório de alunos matriculados **\n");
                        for (Aluno alunos : ArmazTemporario.listaAlunos) {
                            System.out.println(alunos.gerarRelatorio());
                        }
                    }
                    break;
                case 2:     // professores:
                    if (ArmazTemporario.listaProf.isEmpty()) {
                        System.out.println("\n\nO sistema não possui nenhum professor cadastrado.");
                    } else {
                        System.out.println("\n\n** Relatório de professores registrados **");
                        for (Professor prof : ArmazTemporario.listaProf) {
                            System.out.println(prof.gerarRelatorio());
                        }
                    }
                    break;
                case 3:     // cursos - EAD:
                    if (ArmazTemporario.listaCursos.isEmpty()) {
                        System.out.println("\n\nO sistema não possui nenhum curso cadastrado.");
                    } else {
                        System.out.println("\n\n** Relatório de cursos disponíveis **");
                        for (Curso cursos : ArmazTemporario.listaCursos) {
                            System.out.println(cursos.gerarRelatorio());
                        }
                    }
                    break;
                case 4:
                    if (ArmazTemporario.listaTurmas.isEmpty()) {
                        System.out.println("\n\nNenhuma turma foi criada.");
                    } else {
                        System.out.println("\n\n** Relatorio de turmas **");
                        for (Turma turma : ArmazTemporario.listaTurmas) {
                            System.out.println(turma.resumoTurma());
                        }
                    }
                    break;
                case 5:
                    if (ArmazTemporario.listaAvaliacoes.isEmpty()) {
                        System.out.println("\n\nO sistema não possui nenhuma avaliação registrada.");
                    } else {
                        System.out.println("\n\n** Relatorio de avaliações **");
                        for (Avaliacao avaliacao : ArmazTemporario.listaAvaliacoes) {
                            System.out.println(avaliacao.resultadoAvaliacao());
                        }
                    }
                    break;
                case 6:     // voltar ao menu interativo:
                    System.out.println("\n\n");
                    break;
                default :   // se escolha != de 1, 2, 3, 4, 5 ou 6 = opção inválida.
                System.out.println("\n\nOpção inválida!"); 
                System.out.println("\nConfira as opções no menu de relatórios."); 
                break;
            }
        } while (escolha != 6); // se escolha != de 6 repete do-while
    }
}