package repository;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.Professor;
import service.Turma;

public class ArmazTemporario {
    // listas dos tipos Aluno, Professor, Curso e Turma - public e static
    public static List<Aluno> listaAlunos = new ArrayList<>();
    public static List<Professor> listaProf = new ArrayList<>();
    public static List<Curso> listaCursos = new ArrayList<>();
    public static List<Turma> listaTurmas = new ArrayList<>();
}