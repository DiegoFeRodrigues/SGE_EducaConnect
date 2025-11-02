import java.util.ArrayList;
import java.util.List;
public class Turma {
    // atributos turma:
    private Curso codigo;
    private Curso nomeCurso;
    private Professor professor;
    private List<String> listaAlunos;
    // constructor turma - valida e inicia atributos:
    public Turma(Curso codigo, Curso nomeCurso, Professor professor) {
        if (codigo == null) {
            throw new NullPointerException("Informe o objeto do curso desejado para acessar seu código.");
        }
        if (nomeCurso == null) {
            throw new NullPointerException("Informe o objeto do curso desejado para acessar seu nome.");
        }
        if (professor == null) {
            throw new NullPointerException("Informe o objeto do professor desejado.");
        }
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
    }
    // método adiciona aluno: 
    public void addAluno(Aluno aluno, Curso curso) {
        if (aluno.getCursoAlu().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno.getNomeAlu());
            System.out.println(aluno.getNomeAlu()+" foi adicionado ao curso de "+curso.getNomeCurso());
        } else {
            System.out.println("O aluno "+aluno.getNomeAlu()+" é de outra turma");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno, Curso curso) {
        listaAlunos.remove(aluno.getNomeAlu());
        System.out.println(aluno.getNomeAlu()+" foi removido do curso de "+curso.getNomeCurso()+".");
    }
    // método com resumo da turma:
    public String resumoTurma() {
        return "\nDados da turma do curso de "+this.nomeCurso.getNomeCurso()+":"+
        "\nProfessor: "+this.professor.getNomeProf()+
        "\nCurso: "+this.nomeCurso.getNomeCurso()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaAlunos;
    }
}