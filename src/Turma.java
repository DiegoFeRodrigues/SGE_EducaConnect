import java.util.ArrayList;
import java.util.List;

public class Turma {
    // atributos turma:
    int codigo;
    Professor professor;
    Curso curso;
    List<String> listaAlunos;
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
        this.curso = curso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
    }
    // método adiciona aluno: 
    public void addAluno(Aluno aluno, Curso curso) {
        if (aluno.curso.equals(curso.nomeCurso)) {
            listaAlunos.add(aluno.nomeAluno);
            System.out.println(aluno.nomeAluno+" foi adicionado ao curso de "+curso.nomeCurso);
        } else {
            System.out.println("O aluno "+aluno.nomeAluno+" é de outra turma");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno, Curso curso) {
        listaAlunos.remove(aluno.nomeAluno);
        System.out.println(aluno.nomeAluno+" foi removido do curso de "+curso.nomeCurso+".");
    }
    // método resumo da turma:
    public String resumoTurma() {
        return "\nDados da turma do curso de "+this.curso.nomeCurso+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nProfessor: "+this.professor.nomeProfessor+
        "\nCurso: "+this.curso.nomeCurso+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaAlunos;
    }
}