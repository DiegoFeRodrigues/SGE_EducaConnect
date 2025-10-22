public class Aluno extends Usuario implements Autenticacao{
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
    // getters - nome, curso, login e senha - aluno:
    public String getCursoAlu() {
        return curso;
    }
    public String getNomeAlu() {
        return nomeAluno;
    }
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
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
    public String toString(String l, String s) {
        if (!autenticar(l, s)) {
            return "Login ou senha incorretos.";
        } else {
            return "Logado como aluno. \nSeus dados:"+
            "\nNome aluno(a): "+this.nomeAluno+
            "\nMatrícula: "+this.matricula+
            "\nCurso: "+this.curso;
        }
    }
}

// SEGUIR PADRAO DE ADMINISTRADOR!!!!!!!