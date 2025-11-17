package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
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
            System.out.println("\n*************************\n");
            System.out.println("Digite 1 - Alunos matriculados");
            System.out.println("Digite 2 - Professores registrados");
            System.out.println("Digite 3 - Cursos disponíveis");
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
                    for (Aluno alunos : dadosSalvos.getListaAlunos()) {
                        System.out.println(alunos.gerarRelatorio());
                    }
                    break;
                case 2:     // professores:
                    System.out.println("\n\n** Relatório de professores registrados **");
                    for (Professor prof : dadosSalvos.getListaProf()) {
                        System.out.println(prof.gerarRelatorio());
                    }
                    break;
                case 3:     // cursos - EAD:
                    System.out.println("\n\n** Relatório de cursos disponíveis **");
                    for (Curso cursos : dadosSalvos.getListaCursos()) {
                        System.out.println(cursos.gerarRelatorio());
                    }
                    break;
                case 4:
                    System.out.println("\n\n** Relatorio de turmas **");
                    for (Turma turma : dadosSalvos.getListaTurmas()) {
                        System.out.println(turma.resumoTurma());
                    }
                    break;
                case 5:     // sair:
                    System.out.println("\nSaindo.\n"); 
                    break;
                default :   // se escolha != de 1, 2, 3, 4 ou 5 = opção inválida.
                System.out.println("\nOpção inválida!"); 
                break;
            }
        } while (escolha != 5); // se escolha != de 5 repete do-while
        scan.close();
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


    
