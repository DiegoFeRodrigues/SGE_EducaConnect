import java.util.ArrayList;
import java.util.List;

public class Turma {
    // atributos turma:
    private int codigo;
    private Professor professor;
    private Curso curso;
    private List<String> listaAlunos;
    // constructor turma - valida e inicia atributos:
    public Turma(int codigo, Curso curso, Professor professor) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código da turma deve ser maior que 0.");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o objeto do curso desejado para acessar seu nome.");
        }
        if (professor == null) {
            throw new NullPointerException("Informe o objeto do professor desejado.");
        }
        this.codigo = codigo;
        this.curso = curso;
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
    // método resumo da turma:
    public String resumoTurma() {
        return "\nDados da turma do curso de "+this.curso.getNomeCurso()+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nProfessor: "+this.professor.getNomeProf()+
        "\nCurso: "+this.curso.getNomeCurso()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaAlunos;
    }
}