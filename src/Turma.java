package src;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    // atributos:
    private Curso codigo;
    private Curso nomeCurso;
    private Professor professor;
    private List<String> listaAlunos;
    // constructor:
    public Turma(Curso codigo, Curso nomeCurso, Professor professor) {
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
    }

    // método adiciona aluno: 
    public void addAluno(Aluno aluno, Curso curso) {
        if (aluno.getCursoAlu().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno.getNomeAlu());
            System.out.println(aluno.getNomeAlu()+
            " foi adicionado ao curso de "+curso.getNomeCurso()+".");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno, Curso curso) {
        if (aluno == null){
            System.out.println("Aluno inválido!");
        }else {
            listaAlunos.remove(aluno.getNomeAlu());
                System.out.println(aluno.getNomeAlu()+" foi removido.");
            }
    }
    
    // saída turma:
    @Override
    public String toString() {
        return "\nDados da turma do curso de "+this.nomeCurso.getNomeCurso()+":"+
        "\nProfessor: "+this.professor.getNomeProf()+
        "\nCurso: "+this.nomeCurso.getNomeCurso()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaAlunos;
    }
}