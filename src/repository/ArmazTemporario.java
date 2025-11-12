package repository;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;
import model.Professor;

public class ArmazTemporario {

    private List<Aluno> listaAlunos = new ArrayList<>();
    private List<Professor> listaProf = new ArrayList<>();
    private List<CursoEAD> listaCursosEAD = new ArrayList<>();
    private List<CursoPresencial> listaCursosPres = new ArrayList<>();

    public void adicionaAluno() {
        listaAlunos.add(new Aluno("Diego",12345, "ADS","D","senha"));
        listaAlunos.add(new Aluno("Ana", 593150, "Letras", "Aninha", "98@k9Lç$"));
    }
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void adicionaProf() {
        listaProf.add(new Professor("Walter White", "Química", 19, "WWhite", "1234"));
    }
    public List<Professor> getListaProf() {
        return listaProf;
    }
    public void adicionaCursoP() {
        listaCursosPres.add(new CursoPresencial("Engenharia", 57777, 53891f, "18"));
    }
    public void adicionaCursoEAD() {
        listaCursosEAD.add(new CursoEAD("ADS", 12345, 2180f, "Studeo"));
    }


    public List<CursoPresencial> getListaCursosP() {
        return listaCursosPres;
    }
    public List<CursoEAD> getListaCursosEAD() {
        return listaCursosEAD;
    }
    
    
    // public void adicionaAluno() {
    // public static void main(String[] args) {
        // ArrayList<Aluno> listaAlunos = new ArrayList<>();
        // Aluno alu10 = new Aluno("Anna", "Letras", 593150, "Anninha", "98@k9Lç$");
    //     alu10.autenticar("Anninha", "98@k9Lç$");
    //     listaAlunos.add(alu10);
        
    //     listaAlunos.add(new Aluno("Teste1","Eng.",155759,"TJQI", "52390005"));
    // // }
    
    
    // public List<Aluno> getListaAlunos () {
    //     return listaAlunos;
    // }
    // public void imprimeLista() {
    //     System.out.println(listaAlunos);
    // }

}

//     public static void main(String[] args) {
        
//         // instanciando novo objeto da classe Aluno pra testar FaseCinco:
//         // lista alunos:
//         List<Aluno> listaAlunos = new ArrayList<>();
//         // instanciando aluno direto na lista:
//         System.out.println(listaAlunos);



//         // instanciando novo objeto da classe Professor pra testar FaseCinco:
//         Professor prof10 = new Professor("Walter White", "Química", 19, "WWhite", "1234");
//         prof10.autenticar("WWhite", "1234");
        
//         // lista professores:
//         List<Professor> listaProf = new ArrayList<>();
//         listaProf.add(prof10);
        

//         Curso curso10 = new Curso("Engenharia", 57777, 53891f);

//         // lista cursos:
//         List<Curso> listaCursos = new ArrayList<>();
//         listaCursos.add(curso10);

//         // getter lista:
        
//     }
// }

