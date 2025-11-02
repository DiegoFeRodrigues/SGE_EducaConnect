public class Aluno {
    // atributos aluno:
    private String nome, curso;
    private int matricula;
    // constructor aluno - valida e inicia atributos::
    public Aluno(String nome, String curso, int matricula) {
        if (nome == null) {
            throw new NullPointerException("Informe o nome do aluno.");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o curso do aluno.");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("O número da matrícula deve ser maior que 0.");
        }
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