package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;

public class MenuRelatorios {
    
    private ArmazTemporario dadosSalvos;
    
    public MenuRelatorios (ArmazTemporario dados) {
        this.dadosSalvos = dados;
    }

    // public static void main(String[] args) {
    public void menuR() {

        // instanciando objeto da classe que contém as listas
        // ArmazTemporario listaAlu = new ArmazTemporario();

        // ArmazTemporario listaPro = new ArmazTemporario();
        // listaPro.adicionaProf();

        // ArmazTemporario listaCursos = new ArmazTemporario();
        
        // instanciando novo scanner - input do usuário
        Scanner scan = new Scanner(System.in);
        // variável de controle - escolha:
        int escolha;
        // do-while para repetir menu de escolha (executa ao menos uma vez, testa no final):
            do {
                // menu:
                System.out.println("\nGerar relatórios:");
                System.out.println("\nDigite 1 - Alunos matriculados");
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
                        System.out.println("\n== Relatório de alunos matriculados ==\n");
                        for (Aluno alunos : dadosSalvos.getListaAlunos()) {
                            System.out.println(alunos.gerarRelatorio());
                        }
                        break;
                    case 2:     // professores:
                        System.out.println("\n== Relatório de professores registrados ==");
                        for (Professor prof : dadosSalvos.getListaProf()) {
                            System.out.println(prof.gerarRelatorio());
                        }
                        break;
                    case 3:     // cursos - EAD:
                        System.out.println("\n=== Relatório de cursos ===");
                        System.out.println("\n-- Cursos EAD disponíveis: --");
                        for (Curso cursos : dadosSalvos.getListaCursos()) {
                            System.out.println(cursos.gerarRelatorio());
                        }
                        break;
                    case 4:
                        System.out.println("\n ** Relatorio de turmas **");
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
