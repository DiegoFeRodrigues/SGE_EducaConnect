import model.Administrador;
import model.Aluno;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.Turma;
import ui.MenuRelatorios;

public class Main {
    
    public static void main(String[] args) {

        // Camada Model - instanciando objetos 

        // Administrador:
        Administrador adm = new Administrador("Admin","1234");
        // Alunos:
        Aluno aluno1 = new Aluno("Diego", 12345, "ADS", "D","123");
        Aluno aluno2 = new Aluno("Kuririn", 18, "Artes marciais", "marron", "98@k9Lç$" );
        Aluno aluno3 = new Aluno("Kakarotto", 59, "Artes marciais", "Oozaru", "gohan");
        Aluno aluno4 = new Aluno("Yamcha", 7, "Artes marciais", "Yam", "pu@l");
        // curso EAD:
        Curso curso1 = new CursoEAD("ADS", 54321, 2180f, "Studeo");
        // cursos Presenciais:
        Curso curso2 = new CursoPresencial("Artes marciais", 98765, 20000f, "Sala do tempo");
        Curso curso10 = new CursoPresencial("Química", 51379, 5300f, "Laboratório");
        // professores:
        Professor professor1 = new Professor("Mestre Kame", "Estilo da targatura", 1, "roshi", "jackiechun");
        Professor professor2 = new Professor("Flavio Ceci", "POO", 134679, "CeciFlavio", "FC12345");
        Professor professor10 = new Professor("Walter White", "Química", 19, "WWhite", "Heisenberg{}*@s");        
        // avaliações:
        Avaliacao prova = new Avaliacao("Prova de POO.");
        Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
        // turmas:
        Turma turma1 = new Turma(1, curso1, professor2);
        Turma turma2 = new Turma(2, curso2, professor1);
        
        // CAMADA DE REGRAS DE NEGOCIO:
        
        // MANIPULANDO TURMAS:
        // adicionando aluno em suas turmas:
        System.out.println("Alunos adicionados:");
        turma1.addAluno(aluno1, curso1);
        turma2.addAluno(aluno2, curso2);
        turma2.addAluno(aluno3, curso2);
        turma2.addAluno(aluno4, curso2);
        
        // removendo aluno de uma turma:
        System.out.println("\nAlunos removidos:");
        turma2.removeAluno(aluno4, curso2);
       
        // saída com resumo das turmas:
        System.out.println(turma1.resumoTurma());
        System.out.println(turma2.resumoTurma());
        
        // AVALIAÇÕES
        // atribuindo nota e saída com resultado - turma 1:
        prova.atribuirNota(aluno1, turma1, 6f);
        System.out.println("\nResultado avaliação da turma 1:");
        System.out.println(prova.resultado(aluno1, turma1, prova));
       
        // atribuindo nota e saída com resultado - turma 2:
        System.out.println("\nResultado avaliação da turma 2:");
        treino.atribuirNota(aluno2, turma2, 8f);
        System.out.println(treino.resultado(aluno2, turma2, treino));

        treino.atribuirNota(aluno3, turma2, 10f);
        System.out.println(treino.resultado(aluno3, turma2, treino));

        // CHAMANDO MENU DE RELATÓRIOS NO MAIN:
        MenuRelatorios menuRelatorios = new MenuRelatorios();
        menuRelatorios.menuR();
    }
    

      
}