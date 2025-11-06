public abstract class Usuario {
    private String login; 
    private String senha; 
    private String nomeAluno;
    private int matricula;
    private String curso;
    private String nomeProfessor;
    private String especialidade;
    private int registro;

    // constructor usuário - será herdado pela classe Aluno:
    public Usuario(String nomeAluno, int matricula, String curso, String login, String senha) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.curso = curso;
        this.login = login;
        this.senha = senha;
    }
    // constructor usuário - será herdado pela classe Professor:
    public Usuario(String nomeProfessor, String especialidade, int registro, String login, String senha) {
        this.nomeProfessor = nomeProfessor;
        this.especialidade = especialidade;
        this.registro = registro;
        this.login = login;
        this.senha = senha;
    }
    // constructor usuário - será herdado pela classe Administrador:
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    // getters aluno:
    public String getNomeAluno() {
        return nomeAluno;
    }
    public int getMatricula() {
        return matricula;
    }
    public String getCursoAluno() {
        return curso;
    }

    // getters professor:
    public String getNomeProfessor() {
        return nomeProfessor;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public int getRegistro() {
        return registro;
    }

    // getters login e senha:
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
}