package model;

import service.Autenticacao;

public class Administrador extends Usuario implements Autenticacao {
    
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
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login de administrador para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha de administrador para autenticar.\n");
        }
        // compara login informado com login cadastrado na construção do objeto:
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) { 
            System.out.println("Falha ao autenticar administrador: Login ou senha incorretos.\n");
            return false;
        } else {
            System.out.println("Administrador entrou.\n");
            return true;
        }
    }
}