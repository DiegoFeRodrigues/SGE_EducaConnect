import java.util.ArrayList;
import java.util.List;
public class Turma {
   
    // atributos turma:
    private int codigo;
    private Curso curso;
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
            System.out.println(aluno.getNome()+" foi adicionado ao curso de "+curso.getNomeCurso());
        } else {
            System.out.println("O aluno "+aluno.getNome()+" é de outra turma ou não foi encontrado.");
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno) {
        if (listaAlunos.contains(aluno)) {
            listaAlunos.remove(aluno);
            listaNomeAlunos.remove(aluno.getNome());
            System.out.println(aluno.getNome()+" foi removido do curso de "+curso.getNomeCurso()+".");
        } else {
            System.out.println("O aluno "+aluno.getNome()+" é de outra turma ou não foi encontrado.");
        }
    }
    // getter codigo - usado em Avaliacao:
    public int getCodigoTurma() {
        return codigo;
    }
    // método com resumo da turma:
    public String resumoTurma() {
        return "Dados da turma do curso de "+this.curso.getNomeCurso()+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nCurso: "+this.curso.getNomeCurso()+
        "\nProfessor: "+this.professor.getNome()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaNomeAlunos+"\n";                 
    }
}