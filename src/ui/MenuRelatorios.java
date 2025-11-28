package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.Turma;

public class MenuRelatorios {

    private ArmazTemporario dadosSalvos;
    
    public MenuRelatorios (ArmazTemporario dados) {
        this.dadosSalvos = dados;
    }

    public void menuRelatorios() {
        Scanner scan = new Scanner(System.in);
        
        // instanciando novo scanner - input do usuário
        // variável de controle - escolha:
        int escolha;
        // do-while para repetir menu de escolha (executa ao menos uma vez, testa no final):
        do {
            // menu:
            System.out.print("\n\n*** Gerar relatórios: ***");
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
                    System.out.println("\n\n** Relatório de alunos matriculados **\n");
                    for (Aluno alunos : dadosSalvos.listaAlunos) {
                        System.out.println(alunos.gerarRelatorio());
                    }
                    break;
                case 2:     // professores:
                    System.out.println("\n\n** Relatório de professores registrados **");
                    for (Professor prof : dadosSalvos.listaProf) {
                        System.out.println(prof.gerarRelatorio());
                    }
                    break;
                case 3:     // cursos - EAD:
                    System.out.println("\n\n** Relatório de cursos disponíveis **");
                    for (Curso cursos : dadosSalvos.listaCursos) {
                        System.out.println(cursos.gerarRelatorio());
                    }
                    break;
                case 4:
                    System.out.println("\n\n** Relatorio de turmas **");
                    for (Turma turma : dadosSalvos.listaTurmas) {
                        System.out.println(turma.resumoTurma());
                    }
                    break;
                case 5:
                    System.out.println("\n\n** Relatorio de avaliações **");
                    for (Avaliacao avaliacao : dadosSalvos.listaAvaliacoes) {
                        System.out.println(avaliacao.resultadoAvaliacao());
                    }
                    break;
                case 6:     // sair:
                    break;
                default :   // se escolha != de 1, 2, 3, 4 ou 6 = opção inválida.
                System.out.println("\nOpção inválida!"); 
                break;
            }
        } while (escolha != 6); // se escolha != de 6 repete do-while
        // scan.close();
    }
}

        // ArmazTemporario listaPro = new ArmazTemporario();
        // listaPro.adicionaProf();

        // ArmazTemporario listaCur = new ArmazTemporario();
        // listaCur.adicionaCurso();

        
        // ArmazTemporario listaAlu = new ArmazTemporario();

        // System.out.println("getLista da classe MenuRelatorios: "+ listaAlu.getListaAlunos());
        // int opcao;
        // do {
        //     System.out.println("Menu Interativo:");
        //     System.out.println("1 - Cadastrar aluno");
        //     opcao = scan.nextInt();
        //     scan.nextLine();
        //     switch (opcao) {
        //         case 1:
        //             System.out.println("Nome do aluno:");
        //             String nomeAluno = scan.nextLine();
        //             System.out.println("Curso:");
        //             String cursoAluno = scan.nextLine();
        //             System.out.println("Matrícula:");
        //             int matricula = scan.nextInt();
        //             System.out.println("Login:");
        //             String login = scan.nextLine();
        //             System.out.println("Senha:");
        //             String senha = scan.nextLine();
        //             listaAlu.adicionaAluno(nomeAluno, cursoAluno, matricula, login, senha);
        //             scan.nextLine();
        //             break;
                    
        //         }
        //     } while (opcao != 4); 


    
