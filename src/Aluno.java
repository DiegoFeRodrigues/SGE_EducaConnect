public class Aluno extends Usuario implements Autenticacao{
    // atributos:
    private String nomeAluno, curso, login, senha;
    private int matricula;
    // constructor inicial:
    public Aluno(String nome, String curso, int matricula) {
        this.nomeAluno = nome;
        this.curso = curso;
        this.matricula = matricula;
    }
    // constrcutor novo - atributos da classe abstrata Usuario:
    public Aluno(String nome, String curso, int matricula, String login, String senha) {
        this.nomeAluno = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.login = login;
        this.senha = senha;
    }
    // getters curso e nome - usados em Turma e Avaliacao:
    public String getCursoAlu() {
        return curso;
    }
    public String getNomeAlu() {
        return nomeAluno;
    }
    // implementação método da interface Autenticacao:
    @Override
    public boolean autenticar(String log, String sen) {
        if (this.login != log || this.senha != sen) { // == null também
            System.out.println("\nFalha ao autenticar aluno: "+
            "Login ou senha incorretos.");
            return false;
        } else { // true ou != null
            System.out.println("\nLogado como aluno");
            return true;
        }
    }
}