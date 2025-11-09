package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import ui.MenuInterativo;

public class MenuRelatorios {

    private ArmazTemporario dadosSalvos;

    public MenuRelatorios(ArmazTemporario dados) {
        this.dadosSalvos = dados;
    }

    public void menuR() {
        Scanner scan = new Scanner(System.in);
        
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


    
        ArmazTemporario listaPro = new ArmazTemporario();
        listaPro.adicionaProf();

        ArmazTemporario listaCur = new ArmazTemporario();
        listaCur.adicionaCurso();
        
        // instanciando novo scanner - input do usuário
        // variável de controle - escolha:
        int escolha;
        // do-while para repetir menu de escolha (executa ao menos uma vez, testa no final):
        do {
            // menu:
            System.out.println("\nRelatórios\nSelecione o relatório desejado:"+
            "\nDigite 1 - Alunos matriculados\nDigite 2 - Professores registrados"+
            "\nDigite 3 - Cursos disponíveis\nDigite 4 - Sair");
            // lendo escolha do usuário:
            escolha = scan.nextInt();
            // usando switch-case para selecionar escolha do usuário:
            switch (escolha) {
                case 1 :    // alunos:

                    System.out.println("\nRelatório de alunos matriculados:");
                    
                    for (Aluno alunos : dadosSalvos.getListaAlunos()) {
                        System.out.println(alunos.gerarRelatorio());
                    }
                    break;
                case 2:     // professores:
                    System.out.println("\nRelatório de professores registrados:");
                    for (Professor prof : listaPro.getListaProf()) {
                        System.out.println(prof.gerarRelatorio());
                    }
                    break;
                case 3:     // cursos:
                    System.out.println("\nRelatório de cursos disponíveis:");
                    for (Curso cursos : listaCur.getListaCursos()) {
                        System.out.println(cursos.gerarRelatorio());
                    }
                default :   // opção inválida ou sair
                    if (escolha <= 0 || escolha > 4) {
                        System.out.println("\nOpção inválida!");
                    } else if (escolha == 4) {
                        System.out.println("\nSaindo...\n");
                    }
                    break;
            }       // enquanto != 4 repete do-while
        } while (escolha != 4);
        scan.close();
    }
}
