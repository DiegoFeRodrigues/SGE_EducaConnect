package model;

import service.Autenticacao;

public class Administrador extends Usuario implements Autenticacao {

    // constructor adm - valida e inicia atributos:
    public Administrador(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("\n\nInforme o login de administrador(a).\n");
        }
        if (senha == null) {
            throw new NullPointerException("\n\nInforme a senha de administrador(a).\n");
        }
        super(login, senha); // -> herda da superclasse abstrata Usuário
    }
    
    // implementacão método da interface Autenticacao:
    @Override
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("\n\nInforme o login de administrador(a) para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("\n\nInforme a senha de administrador(a) para autenticar.\n");
        }
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) { 
            System.out.println("\n\nFalha ao autenticar administrador(a): Login ou senha incorretos.\n");
            return false;
        } else {
            System.out.println("\n\nPermissão de Administrador(a) concedida.\n");
            return true;
        }
    }
}