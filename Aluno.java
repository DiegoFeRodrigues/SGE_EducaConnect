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

    public String getNomeAlu() {
        return nome;
    }
    public String getCursoAlu() {
        return curso;
    }

    // saída aluno:
    @Override
    public String toString() {
        return "Dados aluno:\nNome do aluno: "+this.nome+
        "\nMatrícula: "+this.matricula+
        "\nCurso: "+this.curso;
    }
}