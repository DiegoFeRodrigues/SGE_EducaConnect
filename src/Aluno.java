public class Aluno {
    // atributos aluno:
    private String nome, curso;
    private int matricula;
    // constructor:
    public Aluno(String nome, String curso, int matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    // getters nome e curso aluno - usados em turma:
    public String getCursoAlu() {
        return curso;
    }
    public String getNomeAlu() {
        return nome;
    }
}