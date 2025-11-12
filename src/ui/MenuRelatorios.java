package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;

public class MenuRelatorios {

    // public static void main(String[] args) {
    public void menuR() {

        // instanciando objeto da classe que contém as listas
        ArmazTemporario listaAlu = new ArmazTemporario();
        listaAlu.adicionaAluno();

        ArmazTemporario listaPro = new ArmazTemporario();
        listaPro.adicionaProf();

        ArmazTemporario listaCursoP = new ArmazTemporario();
        listaCursoP.adicionaCursoP();
        
        ArmazTemporario listaCursosEAD = new ArmazTemporario();
        listaCursosEAD.adicionaCursoEAD();
        
        // instanciando novo scanner - input do usuário
        Scanner scan = new Scanner(System.in);
        // variável de controle - escolha:
        int escolha;
        // do-while para repetir menu de escolha (executa ao menos uma vez, testa no final):
            do {
                // menu:
                System.out.println("Gerar relatórios:");
                System.out.println("\nDigite 1 - Alunos matriculados");
                System.out.println("Digite 2 - Professores registrados");
                System.out.println("Digite 3 - Cursos disponíveis");
                System.out.println("Digite 4 - Sair");
                System.out.print("Digite o número do relatório desejado ou 4 para sair: ");
                // lendo escolha do usuário:
                escolha = scan.nextInt();
                scan.nextLine();
                // usando switch-case para selecionar escolha do usuário:
                switch (escolha) {
                    case 1 :    // alunos:
                        System.out.println("\n== Relatório de alunos matriculados ==\n");
                        for (Aluno alunos : listaAlu.getListaAlunos()) {
                            System.out.println(alunos.gerarRelatorio());
                        }
                        break;
                    case 2:     // professores:
                        System.out.println("\n== Relatório de professores registrados ==");
                        for (Professor prof : listaPro.getListaProf()) {
                            System.out.println(prof.gerarRelatorio());
                        }
                        break;
                    case 3:     // cursos - EAD:
                        System.out.println("\n=== Relatório de cursos ===");
                        System.out.println("\n-- Cursos EAD disponíveis: --");
                        for (Curso cursosEAD : listaCursosEAD.getListaCursosEAD()) {
                            System.out.println(cursosEAD.gerarRelatorio());
                        }       // presencial:
                        System.out.println("\n-- Cursos Presenciais disponíveis: --");
                        for (Curso cursosPre : listaCursoP.getListaCursosP()) {
                            System.out.println(cursosPre.gerarRelatorio());
                        }
                        break;
                    case 4:     // sair:
                        System.out.println("\nSaindo.\n"); 
                        break;
                    default :   // se escolha != de 1, 2, 3 ou 4 = opção inválida.
                    System.out.println("\nOpção inválida!"); 
                    break;
                }
            } while (escolha != 4); // se escolha != de 4 repete do-while
            scan.close();
    }
}
