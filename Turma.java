import java.util.ArrayList;
import java.util.List;

public class Turma {
    // atributos:
    private Curso codigo;
    private Curso nomeCurso;
    private Professor professor;
    private List<Aluno> listaAlunos;
    
    public Turma(Curso codigo, Curso nomeCurso, Professor professor) {
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
    }

    public Curso getCursoTur() {
        return nomeCurso;
    }

    public void addAluno(Aluno aluno, Curso curso) {
        if (aluno.getCursoAlu().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno);
        }
    }
    
    // saída turma:
    @Override
    public String toString() {
        return "\n\nDados da turma:"+
        "\nProfessor: "+this.professor.getNomeProf()+
        "\nCurso: "+this.nomeCurso.getNomeCurso()+
        "\nQuantidade de alunos:"+listaAlunos.size();
    }
}