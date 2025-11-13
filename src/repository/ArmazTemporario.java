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
    // private List<CursoEAD> listaCursosEAD = new ArrayList<>();
    // private List<CursoPresencial> listaCursosPres = new ArrayList<>();
    private List<Curso> listaCursos = new ArrayList<>();

    public void adicionaAluno(String nome, int matricula, String Curso, String login, String senha) {
        listaAlunos.add(new Aluno(nome, matricula, Curso, login, senha));
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
    // public void adicionaCursoP() {
    //     listaCursosPres.add(new CursoPresencial("Engenharia", 57777, 53891f, "18"));
    // }
    // public List<CursoPresencial> getListaCursosP() {
    //     return listaCursosPres;
    // }
    // public void adicionaCursoEAD() {
    //     listaCursosEAD.add(new CursoEAD("ADS", 12345, 2180f, "Studeo"));
    // }
    // public List<CursoEAD> getListaCursosEAD() {
    //     return listaCursosEAD;
    // }
    public void adicionaCurso(String curso, int codigo, float cargaHoraria, String sala) {
        listaCursos.add(new CursoPresencial(curso, codigo, cargaHoraria, sala));
    }
    public void adicionaCurso(int codigo, String curso, float cargaHoraria, String plataforma) {
        listaCursos.add(new CursoEAD(curso, codigo, cargaHoraria, plataforma));
    }
    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public Aluno encontraAluno(int matricula) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula() == matricula){
                return aluno;
            }
        }
        System.out.println("\nAluno não encontrado.");
        return null;
    }
    public Curso encontraCurso(String curso) {
        for (Curso cursos : listaCursos) {
            if (cursos.getNomeCurso().equals(curso)){
                return cursos;
            }
        }
        System.out.println("\nCurso não encontrado.");
        return null;
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

