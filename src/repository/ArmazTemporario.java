package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;

public class ArmazTemporario {

    private static List<Aluno> listaAlunos = new ArrayList<>();

    public void adicionaAluno() {
        listaAlunos.add(new Aluno("Aninha", "Letras", 564869));
        listaAlunos.add(new Aluno("Teste", "testou",156657,"fasdfsidfa","asfasfpsofia"));
    }
    
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
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

