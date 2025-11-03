public class Aluno {
    // atributos aluno:
    String nome, curso;
    int matricula;
    // constructor aluno - valida e inicia atributos:
    public Aluno(String nome, String curso, int matricula) {
        if (nome == null) {
            throw new NullPointerException("Informe o nome do aluno.");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o curso do aluno.");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("O número de matrícula deve ser maior que 0.");
        }
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }
}