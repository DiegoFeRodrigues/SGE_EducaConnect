public class Administrador extends Usuario implements Autenticacao{
    private String login, senha;
    // constructor:
    public Administrador(String log, String se) {
        this.login = log;
        this.senha = se;
    }
    // getters:
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
    
    // implementando método autenticar da classe abstrata autenticacao:
    @Override
    public boolean autenticar(String l, String s) {
        if (login == l && senha == s){ // ***  MELHORAR ISSO !!!!
            if (login == null || l == null || senha == null || s == null) {
                // System.out.println("\nInforme login e senha.");
                return false;
            }
            // System.out.println("\nLogado como administrador.");
            return true;
        } else {
            // System.out.println("\nLogin ou senha incorretos");
            return false;
        }
    }
    // sobrescrita do método abstrato toString da classe Usuario:
    @Override
    public String toString(String l, String s) {
        if (!autenticar(l, s)) {
            return "\nLogin ou senha incorretos.";
        } else {
            return "\nLogado como administrador!!!!";
        }
    }
}


/*

MÉTODO AUTENTICA JÁ COM A SAÍDA - QUAL É MELHOR, MENOS CÓDIGO OU COM RETORNO????

// implementando método autenticar da classe abstrata autenticacao:
    @Override
    public boolean autenticar(String l, String s) {
        if (login == l && senha == s){ // ***  MELHORAR ISSO !!!!
            if (login == null || l == null || senha == null || s == null) {
                // System.out.println("\nInforme login e senha.");
                return false;
            }
            // System.out.println("\nLogado como administrador.");
            return true;
        } else {
            // System.out.println("\nLogin ou senha incorretos");
            return false;
        }
}
*/