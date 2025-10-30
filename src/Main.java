import model.Administrador;
import model.Aluno;
import model.Avaliacao;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;
import model.Professor;
import model.Turma;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos - alunos:
        Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
        Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
        Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
        Aluno aluno4 = new Aluno("Yamcha", "Artes marciais", 7);
        // cursos:
        Curso curso1 = new Curso("ADS", 54321, 2180f);
        Curso curso2 = new Curso("Artes marciais", 98765, 10000f);
        // professores:
        Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
        Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
        // turmas:
        Turma turma1 = new Turma(curso1, curso1, professor1);
        Turma turma2 = new Turma(curso2, curso2, professor2);
        // adicionando aluno em seus cursos:
        System.out.println("Alunos adicionados:");
        turma1.addAluno(aluno1, curso1);
        turma2.addAluno(aluno2, curso2);
        turma2.addAluno(aluno3, curso2);
        turma2.addAluno(aluno4, curso2);
        // removendo aluno:
        System.out.println("\nAlunos removidos:");
        turma2.removeAluno(aluno4, curso2);
        // saída com resumo das turmas:
        System.out.println(turma1.toString()+"\n"+turma2.toString());
        // instanciando nova avaliação:
        Avaliacao prova = new Avaliacao("Prova de POO.");
        // atribuindo nota e saída com resultado - turma 1:
        prova.atribuirNota(aluno1, 6f);
        System.out.println("\nResultado avaliação da turma 1:"
        +prova.avaliacao(aluno1, turma1, prova));
        // instanciando nova avaliação:
        Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
        // atribuindo nota e saída com resultado - turma 2:
        treino.atribuirNota(aluno2, 8f);
        System.out.println("\nResultado avaliação da turma 2:"
        +treino.avaliacao(aluno2, turma2, treino));
        treino.atribuirNota(aluno3, 10f);
        System.out.println(treino.avaliacao(aluno3, turma2, treino));
        // instanciando novo curso presencial - construtor apenas nome 
        CursoPresencial artesMarciais = new CursoPresencial(curso2.getNomeCurso());
        artesMarciais.setSala("Sala do tempo");
        // saída com metódo sobrescrito:
        System.out.println(artesMarciais.detalharCurso());

        // instanciando novo curso ead com construtor "hibrido", sem setter:
        CursoEAD poo = new CursoEAD(curso1.getNomeCurso(), "Studeo");
        System.out.println(poo.detalharCurso());

        // instanciando novo objeto da classe Administrador pra testar FaseCinco:
        Administrador adm = new Administrador("adm", "0000");
        adm.autenticar("adm","0000");
        
        // instanciando novo objeto da classe Aluno pra testar FaseCinco:
        Aluno alu10 = new Aluno("Anna", "Letras", 593150, "Anninha", "98@k9Lç$");
        alu10.autenticar("Anninha", "98@k9Lç$");
        
        // instanciando novo objeto da classe Professor pra testar FaseCinco:
        Professor prof10 = new Professor("Walter White", "Química", 19, "WWhite", "1234");
        prof10.autenticar("WWhite", "1234");

        // lista alunos:
        List<Aluno> listaAlunos = new ArrayList<>();
        listaAlunos.add(alu10);
        // instanciando aluno direto na lista:
        listaAlunos.add(new Aluno("Teste1","Eng.",155759,"TJQI", "52390005"));

        // lista professores:
        List<Professor> listaProf = new ArrayList<>();
        listaProf.add(professor1);
        listaProf.add(professor2);
        
        // lista cursos:
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
                default :   // opção inválida ou sair
                    if (escolha <= 0 || escolha > 4) {
                        System.out.println("\nOpção inválida!");
                    } else if (escolha == 4) {
                        System.out.println("\nSaindo...");
                    }
                    break;
            }       // enquanto != 4 repete do-while
        } while (escolha != 4);
        scan.close();
    }
}