public class Aluno extends Usuario implements Autenticacao{
    // atributos:
    private String nomeAluno, curso, login, senha;
    private int matricula;
    // constructor antigo:
    public Aluno(String nome, String curso, int matricula) {
        this.nomeAluno = nome;
        this.curso = curso;
        this.matricula = matricula;
    }
    // construtor novo com atributos da classe abstrata completo:
    public Aluno(String nome, String curso, int matricula, String login, String senha) {
        this.nomeAluno = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.login = login;
        this.senha = senha;
    }
    // construtor - apenas login e senha:
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

    public void autenticar(String log, String sen) {
        if (login == log && senha == sen) {
            System.out.println("\nLogado como Aluno.");
        } else {
            System.out.println("\nLogin ou senha incorretos.");
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