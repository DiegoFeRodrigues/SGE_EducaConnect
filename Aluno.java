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
    // getters e setters:
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    // método saída:
    public String dadosAluno() {
        return "Nome do aluno: "+getNome()+
        "\nMatrícula: "+getMatricula()+
        "\nCurso: "+getCurso();
    }
}