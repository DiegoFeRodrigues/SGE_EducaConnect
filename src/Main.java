/* 
Material de Avaliação Prática de Aprendizagem - Unicesumar 
Aluno: Diego Ferreira Rodrigues 
R.A.: 24547188-5 
Disciplina: Programação orientada a objetos. 
*/ 

import model.Administrador;
import model.Aluno;
import model.CursoPresencial;
import model.CursoEAD;
import model.Professor;
import repository.ArmazTemporario;
import ui.MenuInicial;

public class Main {
    public static void main(String[] args) {
        try {
            
            // objetos pré informados p/ popular armazenamento temporário e agilizar testes:
            // Administrador:
                ArmazTemporario.listaAdm.add(new Administrador("adm", "000"));
            // alunos:
                ArmazTemporario.listaAlunos.add(new Aluno("Diego", 1, "ADS", "d", "sss"));
            // professors:
                ArmazTemporario.listaProf.add(new Professor("Mestre Kame", "Artes Marciais", 1, "k", "sss"));
            // cursos:
                ArmazTemporario.listaCursos.add(new CursoPresencial("Artes Marciais", 1, 20000, "Sala do tempo"));
                ArmazTemporario.listaCursos.add(new CursoEAD("ADS", 2, 2180, "Studeo"));
            
            // chamando menu inicial no main:
            MenuInicial.menu();

        }
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println(npeOUiae);
        }
    }
}