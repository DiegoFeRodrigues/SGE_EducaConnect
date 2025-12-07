package service;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.Professor;

public class Turma implements NumeroObjetoCadastro{
   
    // atributos turma:
    private int codigo;
    private Curso curso;
    private Professor professor;
    private List<Aluno> listaAlunos;
    private List<String> listaNomeAlunos;    
    
    // constructor turma - valida e inicia atributos:
    public Turma(int codigo, Curso curso, Professor professor) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("\n\nCódigo da turma deve ser maior que 0.\n");
        }
        if (curso == null) {
            throw new NullPointerException("\n\nInforme o objeto curso desejado.\n");
        }
        if (professor == null) {
            throw new NullPointerException("\n\nInforme o objeto professor desejado.\n");
        }    
        this.codigo = codigo;
        this.curso = curso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
        this.listaNomeAlunos = new ArrayList<>();        
    }
    // método adiciona aluno:
    public void addAluno(Aluno aluno) {
        if (aluno.getCursoAluno().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno);
            listaNomeAlunos.add(aluno.getNome());
            System.out.println("\n\nO(a) aluno(a) "+aluno.getNome()+" foi adicionado(a) à turma "+codigo+". \n");
        } else {
            System.out.println("\n\nO aluno "+aluno.getNome()+" não é dessa turma ou não foi encontrado(a).\n");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno) {
        if (listaAlunos.contains(aluno)) {
            listaAlunos.remove(aluno);
            listaNomeAlunos.remove(aluno.getNome());
            System.out.println("\n\nO(a) aluno(a) "+aluno.getNome()+" foi removido(a) da turma "+codigo+".\n");
        } else {
            System.out.println("\n\nO(a) aluno(a) "+aluno.getNome()+" não é dessa turma ou não foi encontrado(a).\n");
        }
    }
    // getters - usados em Turma e/ou Avaliacao e/ou AddOuRemoveAluno e/ou ArmazTemporario e/ou NumeroObjetoCadastro:
    public int getCodigoTurma() {
        return codigo;
    }
    public Curso getCursoTurma() {
        return curso;
    }
    public Professor getProfessorTurma() {
        return professor;
    }
    public int getNumero() {
        return codigo;
    }
    public List<Aluno> getListaAlunos() { // usado em RegistraAvaliacoes
        return listaAlunos;
    }
    // método com resumo da turma:
    public String resumoTurma() {
        return "\nDados da turma do curso de "+this.curso.getNomeCurso()+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nProfessor(a): "+this.professor.getNome()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaNomeAlunos+"\n";
    }
}