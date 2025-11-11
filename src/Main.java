import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== EduConnect - Sistema de Gestão Educacional (SGC) ===");        

        // instanciando novos objetos - alunos:
        Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
        Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
        Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
        Aluno aluno10 = new Aluno("Anna", "Letras", 593150, "Anninha", "98@k9Lç$");

        // cursos:
        Curso curso1 = new Curso("ADS", 54321, 2180f);
        Curso curso2 = new Curso("Artes marciais", 98765, 10000f);

        // professores:
        Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
        Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
        Professor professor10 = new Professor("Walter White", "Química", 19, "WWhite", "1234");

        // nova lista de alunos e adicionando objetos - TESTANDO FASE 6:
        List<Aluno> listaAlunos = new ArrayList<>();
        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);
        listaAlunos.add(aluno3);
        listaAlunos.add(aluno10);

        // nova lista de professores e adicionando objetos - TESTANDO FASE 6:
        List<Professor> listaProf = new ArrayList<>();
        listaProf.add(professor1);
        listaProf.add(professor2);
        listaProf.add(professor10);
        
        // nova lista de alunos e adicionando objetos - TESTANDO FASE 6:
        List<Curso> listaCursos = new ArrayList<>();
        listaCursos.add(curso1);
        listaCursos.add(curso2);

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
                    for (Aluno alunos : listaAlunos) {
                        System.out.println(alunos.gerarRelatorio());
                    }
                    break;
                case 2:     // professores:
                    System.out.println("\nRelatório de professores registrados:");
                    for (Professor prof : listaProf) {
                        System.out.println(prof.gerarRelatorio());
                    }
                    break;
                case 3:     // cursos:
                    System.out.println("\nRelatório de cursos disponíveis:");
                    for (Curso cursos : listaCursos) {
                        System.out.println(cursos.gerarRelatorio());
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