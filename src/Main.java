import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // bloco try - tenta validação na instancia de objetos:
        try {
            System.out.println("\n=== EduConnect - Sistema de Gestão Educacional (SGC) ===\n");        

            // instanciando objetos - alunos:
            Aluno aluno1 = new Aluno("Diego", 12345, "ADS", "D", "98765");
            Aluno aluno2 = new Aluno("Kuririn", 18, "Artes marciais", "marron", "98@k9Lç$");
            Aluno aluno10 = new Aluno("Ana", 593150, "Letras", "Anninha", "123");

            // cursos - EAD:
            Curso curso1 = new CursoEAD("ADS", 54321, 2180f, "Studeo");
            Curso curso2 = new CursoEAD("Cyber Segurança", 134678, 2500f, "Studeo");
            // Presencial:
            Curso curso3 = new CursoPresencial("Artes marciais", 98765, 20000f, "Sala do tempo");
            Curso curso10 = new CursoPresencial("Química", 51379, 5300f, "Laboratório");

            // professores:
            Professor professor1 = new Professor("Mestre Kame", "Estilo da targatura", 1, "roshi", "jackiechun");
            Professor professor2 = new Professor("Flavio Ceci", "POO", 134679, "CeciFlavio", "FC12345");
            Professor professor10 = new Professor("Walter White", "Química", 19, "WWhite", "Heisenberg{}*@s");

            // nova lista de alunos e adicionando objetos p/ testes FASE 6:
            List<Aluno> listaAlunos = new ArrayList<>();
            listaAlunos.add(aluno1);
            listaAlunos.add(aluno2);
            listaAlunos.add(aluno10);

            // nova lista de professores e adicionando objetos p/ testes FASE 6:
            List<Professor> listaProf = new ArrayList<>();
            listaProf.add(professor1);
            listaProf.add(professor2);
            listaProf.add(professor10);
            
            // novas listas de curso (EAD e presenc.) e adicionando objetos p/ testes FASE 6:
            List<Curso> listaCursosEAD = new ArrayList<>();
            listaCursosEAD.add(curso1);
            listaCursosEAD.add(curso2);

            List<Curso> listaCursosPresen = new ArrayList<>();
            listaCursosPresen.add(curso3);
            listaCursosPresen.add(curso10);

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
                        for (Aluno alunos : listaAlunos) {
                            System.out.println(alunos.gerarRelatorio());
                        }
                        break;
                    case 2:     // professores:
                        System.out.println("\n== Relatório de professores registrados ==");
                        for (Professor prof : listaProf) {
                            System.out.println(prof.gerarRelatorio());
                        }
                        break;
                    case 3:     // cursos - EAD:
                        System.out.println("\n=== Relatório de cursos ===");
                        System.out.println("\n-- Cursos EAD disponíveis: --");
                        for (Curso cursosEAD : listaCursosEAD) {
                            System.out.println(cursosEAD.gerarRelatorio());
                        }       // presencial:
                        System.out.println("\n-- Cursos Presenciais disponíveis: --");
                        for (Curso cursosPre : listaCursosPresen) {
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
        } // captura e tratamento de erros de objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("\nErro: "+npeouiae.getMessage());        
        }
    }
        
}