import model.Administrador;
import model.Aluno;
import model.CursoPresencial;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Turma;
import ui.MenuInicial;
import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****\n\n");
            
            // objetos pré informados p/ popular armazenamento temporário e agilizar testes:
            // Administrador:
                
            
            // aluno:
                ArmazTemporario.listaAlunos.add(new Aluno("Diego", 1, "ADS", "ddd", "sss"));
            // professor:
                Professor prof = new Professor("Mestre Kame", "Artes Marciais", 1, "kkk", "sss");
                ArmazTemporario.listaProf.add(prof);
            // curso:
                Curso curso = new CursoPresencial("Artes Marciais", 1, 20000, "Sala do tempo");
                ArmazTemporario.listaCursos.add(curso);
            // turma:
                ArmazTemporario.listaTurmas.add(new Turma(1, curso, prof));

            MenuInicial.bemVindo();
        }
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println(npeOUiae);
        }
    }
}