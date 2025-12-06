package model;

import service.Autenticacao;

public class Administrador extends Usuario implements Autenticacao {

    // constructor adm - valida e inicia atributos:
    public Administrador(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login de administrador(a).\n\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha de administrador(a).\n\n");
        }
        super(login, senha); // -> herda da superclasse abstrata Usuário
    }
    
    // implementacão método da interface Autenticacao:
    @Override
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login de administrador(a) para autenticar.\n\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha de administrador(a) para autenticar.\n\n");
        }
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) { 
            System.out.println("\n\nFalha ao autenticar administrador(a): Login ou senha incorretos.\n\n");
            return false;
        } else {
            System.out.println("\n\nPermissão de Administrador(a) concedida.\n\n");
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