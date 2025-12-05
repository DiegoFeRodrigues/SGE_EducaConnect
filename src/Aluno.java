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
        super(nomeAluno, login, senha); // herda da superclasse abstrata Usuário
        this.matricula = matricula;
        this.curso = curso;
    }
    // getter curso - usado em Turma:
    public String getCursoAluno() {
        return curso;
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
            System.out.println("\nFalha ao autenticar aluno: Login ou senha incorretos.");
            return false;
        } 
        System.out.println("\nLogado como aluno.");
        return true;
    }
    // método com dados - alunos:
    public String dadosAluno() {
        return "\nNome do Aluno: "+this.getNome()+
        "\nMatrícula: "+this.matricula+
        "\nCurso: "+this.curso+"\n";
    }
}