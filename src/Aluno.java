public class Aluno {
    // atributos aluno:
    private String nomeAluno;
    private String curso;
    private int matricula;
    // constructor aluno - valida e inicia atributos:
    public Aluno(String nomeAluno, String curso, int matricula) {
        if (nomeAluno == null) {
            throw new NullPointerException("Informe o nome do aluno.");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o curso do aluno.");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("O número de matrícula deve ser maior que 0.");
        }
        this.nomeAluno = nomeAluno;
        this.curso = curso;
        this.matricula = matricula;
    }
    // getters - usados em Turma e Avaliacao:
    public String getCursoAluno() {
        return curso;
    }
    public String getNomeAluno() {
        return nomeAluno;
    }
}