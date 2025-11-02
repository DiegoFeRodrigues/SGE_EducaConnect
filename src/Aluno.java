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
    // getters - usados em Turma e Avaliacao:
    public String getCursoAlu() {
        return curso;
    }
    public String getNomeAlu() {
        return nome;
    }
}