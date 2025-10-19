package src;
public class Aluno {
    // atributos:
    private String nome, curso;
    private int matricula;
    // constructor:
    public Aluno(String nome, String curso, int matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    // getters - nome e curso aluno:
    public String getCursoAlu() {
        return curso;
    }
    public String getNomeAlu() {
        return nome;
    }

    // saída aluno:
    @Override
    public String toString() {
        return "Dados aluno:\nNome do aluno: "+this.nome+
        "\nMatrícula: "+this.matricula+
        "\nCurso: "+this.curso;
    }
}