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
    // método saída para testar aluno:
    public String dadosAluno() {
        return "Nome do Aluno: "+this.nome+
        "\nMatrícula: "+this.matricula+
        "\nCurso: "+this.curso;
    }
}