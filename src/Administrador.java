public class Administrador extends Usuario implements Autenticacao{
    private String login, senha;
    // private String login, senha;
    // constructor:
    public Administrador(String log, String se) {
        this.login = log;
    }

    public String getLogin() {
        return login;
    }

    // implementando método autenticar da classe abstrata autenticacao:
    @Override
    public void autenticar(String l, String s) {
        if (getLogin() == l && senha == s){
            System.out.println("\nLogado como administrador.");
        } else {
            System.out.println("\nUsuário ou senha incorretos!");
        }
    }
}
