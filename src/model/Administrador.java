package model;

import service.Autenticacao;
import service.Usuario;

public class Administrador extends Usuario implements Autenticacao{
    private String login, senha;
    // constructor:
    public Administrador(String log, String se) {
        this.login = log;
        this.senha = se;
    }
    
    // implementacão método da interface Autenticacao:
    @Override
    public boolean autenticar(String l, String s) {
        if (l != this.login || s != this.senha) { // == null também
            System.out.println("\nFalha ao autenticar administrador: "+
            "Login ou senha incorretos.");
            return false;
        } else { // true ou != null
            System.out.println("\nLogado como administrador.");
            return true;
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