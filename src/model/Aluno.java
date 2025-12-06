package model;

import service.Autenticacao;

public class Aluno extends Usuario implements Autenticacao {
     
    // atributos aluno:
    private String curso;
    private int matricula;
    
    // constrcutor aluno - valida e inicia atributos:
    public Aluno(String nomeAluno, int matricula, String curso, String login, String senha) {
        if (nomeAluno == null) {
            throw new NullPointerException("Informe o nome do aluno.\n");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("Matrícula deve ser maior que 0.\n");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o curso do aluno.\n");
        }
        if (login == null) {
            throw new NullPointerException("Informe o login.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha.\n");
        }
        super(nomeAluno, login, senha); // -> herda da superclasse abstrata Usuário
        this.matricula = matricula;
        this.curso = curso;
    }
    // getter curso - usado em Turma:
    public String getCursoAluno() {
        return curso;
    }
    public int getMatricula() {
        return matricula;
    }
    // implementação método da interface Autenticacao:
    @Override
    public boolean autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login do aluno para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do aluno para autenticar.\n");
        }   
        // compara login informado com login cadastrado na construção do objeto:     
        if (!login.equals(this.getLogin()) || !senha.equals(this.getSenha())) {
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
        "\nMatrícula: "+this.matricula+
        "\nCurso: "+this.curso+"\n";
    }
}