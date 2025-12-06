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
            throw new NullPointerException("Informe o nome do(a) aluno(a).\n\n");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("Matrícula deve ser maior que 0.\n\n");
        }
        if (curso == null || curso.isEmpty()) {
            throw new NullPointerException("Informe o curso do(a) aluno(a).\n\n");
        }
        if (login == null || login.isEmpty()) {
            throw new NullPointerException("Informe o login do(a) aluno(a).\n\n");
        }
        if (senha == null || senha.isEmpty()) {
            throw new NullPointerException("Informe a senha do(a) aluno(a).\n\n");
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
            throw new NullPointerException("Informe o login do(a) aluno(a) para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do(a) aluno(a) para autenticar.\n");
        }        
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) {
            return false;
        } else {
            System.out.println("Aluno(a) "+this.getNome()+" entrou.\n");
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