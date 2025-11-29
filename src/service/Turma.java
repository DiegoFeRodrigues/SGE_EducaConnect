package service;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.Professor;

public class Turma {
   
    // atributos turma:
    private int codigo;
    private static Curso curso;
    private Professor professor;
    private List<Aluno> listaAlunos;
    private List<String> listaNomeAlunos;    
    
    // constructor turma - valida e inicia atributos:
    public Turma(int codigo, Curso curso, Professor professor) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código da turma deve ser maior que 0.");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o objeto curso desejado.");
        }
        if (professor == null) {
            throw new NullPointerException("Informe o objeto professor desejado.");
        }    
        this.codigo = codigo;
        Turma.curso = curso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
        this.listaNomeAlunos = new ArrayList<>();        
    }
    // método adiciona aluno:
    public void addAluno(Aluno aluno) {
        if (aluno.getCursoAluno().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno);
            listaNomeAlunos.add(aluno.getNome());
            System.out.println("\n"+aluno.getNome()+" foi adicionado à turma "+codigo+". \n\n");
        } else {
            System.out.println("\nO aluno "+aluno.getNome()+" não é dessa turma ou não foi encontrado.\n\n");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno) {
        if (listaAlunos.contains(aluno)) {
            listaAlunos.remove(aluno);
            listaNomeAlunos.remove(aluno.getNome());
            System.out.println("\n"+aluno.getNome()+" foi removido da turma "+codigo+".\n\n");
        } else {
            System.out.println("\nO aluno "+aluno.getNome()+" não é dessa turma ou não foi encontrado.\n\n");
        }
    }
    // getter codigo e curso - usados em Avaliacao e/ou ArmazTemporario:
    public int getCodigoTurma() {
        return codigo;
    }
    public Curso getCursoTurma() {
        return curso;
    }
    public Professor getProfessorTurma() {
        return professor;
    }
    // método com resumo da turma:
    public String resumoTurma() {
        return "\nDados da turma do curso de "+Turma.curso.getNomeCurso()+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nProfessor: "+this.professor.getNome()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaNomeAlunos+"\n";
    }
}