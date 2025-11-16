package model;

import service.Autenticacao;

public class Professor extends Usuario implements Autenticacao {
     
    // atributos professor:
    private String especialidade;
    private int registro;
        
    // constructor professor - valida e inicia atributos:
    public Professor(String nomeProfessor, String especialidade, int registro, String login, String senha) {
        if (nomeProfessor == null) {
            throw new NullPointerException("Informe o nome do professor.\n");
        }
        if (especialidade == null) {
            throw new NullPointerException("Informe a especialidade do professor.\n");
        }
        if (registro <= 0) {
            throw new IllegalArgumentException("Registro inválido.\n");
        }
        if (login == null) {
            throw new NullPointerException("Informe o login.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha.\n");
        }
        super(nomeProfessor, login, senha); // -> herda da superclasse abstrata Usuário
        this.especialidade = especialidade;
        this.registro = registro;
    }
    // implementação método da interface Autenticacao:
    @Override
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login do professor para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do professor para autenticar.\n");
        }        
        if ( login != this.getLogin() || senha != this.getSenha()) {
            System.out.println("Falha ao autenticar o professor "+this.getNome()+": Login ou senha incorretos.\n");
            return false;
        } else {
            System.out.println("Professor "+this.getNome()+" entrou.\n");
            return true;
        }
    }
    // método polimórfico - Relatório prof.:
    public String gerarRelatorio() {
        return "\nNome do professor: "+this.getNome()+
        "\nRegistro: "+this.registro+
        "\nEspecialidade: "+this.especialidade+"\n";
    }
}