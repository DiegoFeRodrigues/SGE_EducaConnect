import java.util.ArrayList;
import java.util.List;
public class Turma {
    // atributos turma:
    private int codigo;
    private Curso curso;
    private Professor professor;
    private List<String> listaAlunos;

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
        if (aluno.getCursoAluno().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno.getNomeAluno());
            System.out.println(aluno.getNomeAluno()+" foi adicionado ao curso de "+curso.getNomeCurso());
        } else {
            System.out.println("O aluno "+aluno.getNomeAluno()+" é de outra turma");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno, Curso curso) {
        listaAlunos.remove(aluno.getNomeAluno());
        System.out.println(aluno.getNomeAluno()+" foi removido do curso de "+curso.getNomeCurso()+".");
    }
    // getter codigo - usado em Avaliacao:
    public int getCodigoTurma() {
        return codigo;
    }
    // método com resumo da turma:
    public String resumoTurma() {
        return "Dados da turma do curso de "+this.curso.getNomeCurso()+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nProfessor: "+this.professor.getNomeProfessor()+
        "\nCurso: "+this.curso.getNomeCurso()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaAlunos+"\n";                 
    }
}