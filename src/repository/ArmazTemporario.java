
/*
    Classe com o armazenamento temporário em lista 
    Armazena todos os objetos e possui métodos que mostra as 
    listas de objetos em menus de seleção, usando os índices para selecioná-los.
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