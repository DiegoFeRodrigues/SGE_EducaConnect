package model;

import service.Autenticacao;
import service.NumeroObjetoCadastro;

public class Aluno extends Usuario implements Autenticacao, NumeroObjetoCadastro {
     
    // atributo aluno:
    private String curso;
    private int matricula;

    // constrcutor aluno - valida e inicia atributos:
    public Aluno(String nomeAluno, int matricula, String curso, String login, String senha) {
        if (nomeAluno == null || nomeAluno.isEmpty()) {
            throw new NullPointerException("\n\nInforme o nome do(a) aluno(a).");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("\n\nMatrícula deve ser maior que 0.");
        }
        if (curso == null || curso.isEmpty()) {
            throw new NullPointerException("\n\nInforme o curso do(a) aluno(a).");
        }
        if (login == null || login.isEmpty()) {
            throw new NullPointerException("\n\nInforme o login do(a) aluno(a).");
        }
        if (senha == null || senha.isEmpty()) {
            throw new NullPointerException("\n\nInforme a senha do(a) aluno(a).");
        }
        super(nomeAluno, login, senha); // -> herda da superclasse abstrata Usuário
        this.curso = curso;
        this.matricula = matricula;
    }
    // getter curso - usados em Turma:
    public String getCursoAluno() {
        return curso;
    }
    public int getMatricula() {
        return matricula;
    }
    public int getNumero() {
        return matricula;
    }
    @Override
    // implementação método da interface Autenticacao:
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("\n\nInforme o login do(a) aluno(a) para autenticar.");
        }
        if (senha == null) {
            throw new NullPointerException("\n\nInforme a senha do(a) aluno(a) para autenticar.");
        }        
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) {
            System.out.println("\n\n\nFalha ao autenticar aluno(a): Login ou senha incorretos.");
            return false;
        } else {
            System.out.println("\n\n\nBem vindo(a) Aluno(a) "+this.getNome()+".");
            return true;
        }
    }
    // método polimórfico - Relatórios aluno::
    public String gerarRelatorio() {
        return "Nome do(a) aluno(a): "+this.getNome()+
        "\nMatrícula: "+this.getMatricula()+
        "\nCurso: "+this.getCursoAluno()+"\n";
    }
}