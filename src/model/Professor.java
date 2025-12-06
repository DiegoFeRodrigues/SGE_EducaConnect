package model;

import service.Autenticacao;
import service.NumeroObjetoCadastro;

public class Professor extends Usuario implements Autenticacao, NumeroObjetoCadastro{
     
    // atributos professor:
    private String especialidade;
    private int registro;

    // constructor professor - valida e inicia atributos:
    public Professor(String nomeProfessor, String especialidade, int registro, String login, String senha) {
        if (nomeProfessor == null || nomeProfessor.isEmpty()) {
            throw new NullPointerException("Informe o nome do(a) professor(a).\n");
        }
        if (especialidade == null || especialidade.isEmpty()) {
            throw new NullPointerException("Informe a especialidade do(a) professor(a).\n");
        }
        if (registro <= 0) {
            throw new IllegalArgumentException("Registro inválido.\n");
        }
        if (login == null || login.isEmpty()) {
            throw new NullPointerException("Informe o login do(a) professor(a).\n");
        }
        if (senha == null || senha.isEmpty()) {
            throw new NullPointerException("Informe a senha do(a) professor(a).\n");
        }
        super(nomeProfessor, login, senha); // -> herda da superclasse abstrata Usuário
        this.especialidade = especialidade;
        this.registro = registro;
    }
    // implementação método da interface Autenticacao:
    @Override
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login do(a) professor(a) para autenticar.\n\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do(a) professor(a) para autenticar.\n\n");
        }        
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) {
            System.out.println("Falha ao autenticar professor(a): Login ou senha incorretos.\n\n");            
            return false;
        } else {
            System.out.println("Professor(a) "+this.getNome()+" entrou.\n\n");
            return true;
        }
    }
    // getters - usados no armazenamento em lista e na interface NumeroObjetoCadastro:
    public String getEspecialidade() {
        return especialidade;
    }
    public int getNumero() {
        return registro;
    }
    // método polimórfico - Relatório prof.:
    public String gerarRelatorio() {
        return "\nNome do(a) professor(a): "+this.getNome()+
        "\nRegistro: "+this.registro+
        "\nEspecialidade: "+this.especialidade+"\n";
    }
}