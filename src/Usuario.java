public abstract class Usuario {
    
    //atributos usuário:
    private String nome;
    private String login; 
    private String senha; 
    
    // constructor - será herdado em Aluno e Professor:
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    // constructor usuário - será herdado pela classe Administrador:
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    // getters:
    public String getNome() {
        return nome;
    }
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
}