import model.Aluno;
import model.CursoEAD;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Turma;
import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****\n\n");
            
            // objetos pré informados p/ popular armazenamento temporário e agilizar testes:
            // aluno:
                ArmazTemporario.listaAlunos.add(new Aluno("Diego", 1, "ADS", "ddd", "sss"));
            // professor:
                Professor prof = new Professor("Flavio Ceci", "Poo", 1, "fff", "sss");
                ArmazTemporario.listaProf.add(prof);
            // curso:
                Curso curso = new CursoEAD("ADS", 1, 2180, "Studeo");
                ArmazTemporario.listaCursos.add(curso);
            // turma:
                ArmazTemporario.listaTurmas.add(new Turma(1, curso, prof));

            MenuInterativo menuI = new MenuInterativo();
            menuI.Menu();        
        }
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println(npeOUiae);
        }
    }
}