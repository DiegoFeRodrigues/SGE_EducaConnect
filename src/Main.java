import model.Administrador;
import model.Aluno;
import model.CursoPresencial;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.Turma;
import ui.MenuInicial;
import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("************************************************************************");
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGE) ****\n");        
            
            // objetos pré informados p/ popular armazenamento temporário e agilizar testes:
            // Administrador:
            ArmazTemporario.listaAdm.add(new Administrador("adm", "000"));
            // aluno:
                // ArmazTemporario.listaAlunos.add(new Aluno("Diego", 1, "ADS", "ddd", "sss"));
                Aluno aluno = new Aluno("Diego", 1, "ADS", "ddd", "sss");
                ArmazTemporario.listaAlunos.add(aluno);
            // professor:
                Professor prof = new Professor("Mestre Kame", "Artes Marciais", 1, "kkk", "sss");
                ArmazTemporario.listaProf.add(prof);
            // curso:
                Curso curso = new CursoPresencial("Artes Marciais", 1, 20000, "Sala do tempo");
                ArmazTemporario.listaCursos.add(curso);
            // turma:
                Turma turma = new Turma(1, curso, prof);
                ArmazTemporario.listaTurmas.add(turma);
                // ArmazTemporario.listaTurmas.add(new Turma(1, curso, prof));
                
                Avaliacao av = new Avaliacao("Prova de POO");
                av.atribuirNota(aluno, turma, 10);
                ArmazTemporario.listaAvaliacoes.add(av);


            MenuInicial.bemVindo();
        }
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println(npeOUiae);
        }
    }
}