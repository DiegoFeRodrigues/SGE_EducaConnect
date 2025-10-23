public class Administrador extends Usuario implements Autenticacao{
    private String login, senha;
    // constructor:
    public Administrador(String log, String se) {
        this.login = log;
        this.senha = se;
    }
    
    // implementando método autenticar da classe abstrata autenticacao:
    @Override
    public void autenticar(String l, String s) {
        if (l != this.login || s != this.senha) {
            if (l == null || s == null) {
                System.out.println("\nInforme login e senha.");
            }
            System.out.println("\nLogin ou senha incorretos.");
        } else {
            System.out.println("\nLogado como administrador.");
        }
    }
}


/*
 *  // implementando método autenticar da classe abstrata autenticacao:
    @Override
    public void autenticar(String l, String s) {
        if ((login == null || l == null) || (senha == null || s == null)) {
            System.out.println("\nInforme login e senha.");
        } else if (login == l && senha == s){
            System.out.println("\nLogado como administrador.");
        } else {
            System.out.println("\nLogin ou senha incorretos.");
        }
    }
 */