
/*
    Classe com o armazenamento temporário em lista Armazena todos os objetos
    e possui métodos que mostra as listas de objetos em menus de seleção, usando
    os índices para selecioná-los.
*/

package repository;

import java.util.ArrayList;
import java.util.List;

import model.Administrador;
import model.Aluno;
import model.Curso;
import model.Professor;
import service.Avaliacao;
import service.Turma;

public class ArmazTemporario {
    // listas de objetos - public e static para acesso facilitado em qualquer classe
    public static List<Aluno> listaAlunos = new ArrayList<>();
    public static List<Professor> listaProf = new ArrayList<>();
    public static List<Curso> listaCursos = new ArrayList<>();
    public static List<Turma> listaTurmas = new ArrayList<>();
    public static List<Avaliacao> listaAvaliacoes = new ArrayList<>();
    public static List<Administrador> listaAdm = new ArrayList<>();

    // métodos mostraListas - seleção de objetos pelos índices:
    // cursos:
    public static void mostraListaCursos() {
        System.out.println("Número:      Curso:");
        for (int contador = 0; contador < listaCursos.size(); contador++) {
            System.out.println(" "+contador+"           "+listaCursos.get(contador).getNomeCurso());
        }
    }
    // professores:
    public static void mostraListaProf() {
        System.out.println("Número:      Professor(a):");
        for (int contador = 0; contador < listaProf.size(); contador++) {
            System.out.println(" "+contador+"           "+listaProf.get(contador).getNome()+" - Especialidade: "+listaProf.get(contador).getEspecialidade());
        }
    }
    // alunos:
    public static void mostraListaAlunos() {
        System.out.println("Número:       Aluno(a):");
        for (int contador = 0; contador < listaAlunos.size(); contador++) {
            System.out.println(" "+contador+"            "+listaAlunos.get(contador).getNome()+" - Matriculado no curso de: "+listaAlunos.get(contador).getCursoAluno());
        }
    }
    // turmas:
    public static void mostraListaTurmas() {
        System.out.println("Número:      Turma:");
        for (int contador = 0; contador < listaTurmas.size(); contador++) {
            System.out.println(" "+contador+"           Curso: "+listaTurmas.get(contador).getCursoTurma().getNomeCurso()+" - Professor: "+listaTurmas.get(contador).getProfessorTurma().getNome());
        }
    }
}

// // getters das listas:
// public List<Aluno> getListaAlunos() {
//     return listaAlunos;
// }
// public List<Professor> getListaProf() {
//     return listaProf;
// }
// public List<Curso> getListaCursos() {
//     return listaCursos;
// }
// public List<Turma> getListaTurmas() {
//     return listaTurmas;
// }
    
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

