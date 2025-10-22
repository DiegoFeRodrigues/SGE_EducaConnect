public class Administrador extends Usuario implements Autenticacao{
    private String login, senha;
    // constructor:
    public Administrador(String log, String se) {
        this.login = log;
    }
    // implementando método autenticar da classe abstrata autenticacao:
    @Override
    public void autenticar(String l, String s) {
        if (login == l && senha == s){
            System.out.println("\nLogado como administrador.");
        } else {
            System.out.println("\nLogin ou senha incorretos!");
        }
    }

}
