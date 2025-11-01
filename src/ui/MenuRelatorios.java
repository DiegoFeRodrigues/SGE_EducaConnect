package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;

public class MenuRelatorios {

    public static void main(String[] args) {
    // public void teste() {

        // instanciando objeto da classe que contém as listas
        ArmazTemporario listaAlu = new ArmazTemporario();
        listaAlu.adicionaAluno();

        ArmazTemporario listaPro = new ArmazTemporario();
        listaPro.adicionaProf();

        ArmazTemporario listaCur = new ArmazTemporario();
        listaCur.adicionaCurso();
        
        // instanciando novo scanner - input do usuário
        Scanner scan = new Scanner(System.in);
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
                    for (Aluno alunos : listaAlu.getListaAlunos()) {
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
