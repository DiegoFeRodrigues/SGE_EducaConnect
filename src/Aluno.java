public class Aluno implements Autenticacao{ // *** RECOLOCAR EXTENDS USUARIO
    // atributos:
    private String nomeAluno, curso, login, senha;
    private int matricula;
    // constructor anterior:
    public Aluno(String nome, String curso, int matricula) {
        this.nomeAluno = nome;
        this.curso = curso;
        this.matricula = matricula;
    }
    // construtor novo com atributos da classe abstrata - completo:
    public Aluno(String nome, String curso, int matricula, String login, String senha) {
        this.nomeAluno = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.login = login;
        this.senha = senha;
    }
    // construtor novo - apenas login e senha:
    public Aluno(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    // getters - nome e curso aluno:
    public String getCursoAlu() {
        return curso;
    }
    public String getNomeAlu() {
        return nomeAluno;
    }

    public boolean autenticar(String log, String sen) {
        if (login == log && senha == sen) {
            return true;
        } else {
            return false;
        }
    }
    // saída aluno:
    @Override
    public String toString() {
        return "Dados aluno:\nNome do aluno: "+this.nomeAluno+
        "\nMatrícula: "+this.matricula+
        "\nCurso: "+this.curso;
    }
}