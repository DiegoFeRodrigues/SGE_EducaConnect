public interface Autenticacao {
    abstract boolean autenticar(String login, String senha);
}