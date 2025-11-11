public class Administrador extends Usuario implements Autenticacao{
    // constructor adm - valida e inicia atributos:
    public Administrador(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login de administrador.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha de administrador.\n");
        }
        super(login, senha); // -> herda da superclasse abstrata Usuário
    }
    // implementacão método da interface Autenticacao:
    @Override
    public String autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login de administrador para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha de administrador para autenticar.\n");
        }
        if ( login != this.getLogin() || senha != this.getSenha()) { 
            return "\nFalha ao autenticar administrador: Login ou senha incorretos.";
        }
        return "\nLogado como administrador.";
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