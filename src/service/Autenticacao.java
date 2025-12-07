package service;

public interface Autenticacao {
    abstract boolean autenticar(String login, String senha);
    String getLogin(); // usado no método de apoio de autenticação AutenticaUsuario()
}
