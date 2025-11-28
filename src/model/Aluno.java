package model;

import service.Autenticacao;

public class Aluno extends Usuario implements Autenticacao {
     
    // atributo aluno:
    private String curso;
    private int matricula;

    // constrcutor aluno - valida e inicia atributos:
    public Aluno(String nomeAluno, int matricula, String curso, String login, String senha) {
        if (nomeAluno == null || nomeAluno.isEmpty()) {
            throw new NullPointerException("Informe o nome do aluno.\n");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("Matrícula deve ser maior que 0.\n");
        }
        if (curso == null || curso.isEmpty()) {
            throw new NullPointerException("Informe o curso do aluno.\n");
        }
        if (login == null || login.isEmpty()) {
            throw new NullPointerException("Informe o login do aluno.\n");
        }
        if (senha == null || senha.isEmpty()) {
            throw new NullPointerException("Informe a senha do aluno.\n");
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
    @Override
    // implementação método da interface Autenticacao:
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login do aluno para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do aluno para autenticar.\n");
        }        
        if ( login != this.getLogin() || senha != this.getSenha()) {
            System.out.println("Falha ao autenticar aluno "+this.getNome()+": Login ou senha incorretos.\n");
            return false;
        } else {
            System.out.println("Aluno "+this.getNome()+" entrou.\n");
            return true;
        }
    }
    // método polimórfico - Relatórios aluno::
    public String gerarRelatorio() {
        return "Nome do aluno: "+this.getNome()+
        "\nMatrícula: "+this.getMatricula()+
        "\nCurso: "+this.getCursoAluno()+"\n";
    }
}