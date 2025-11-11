public class Aluno extends Usuario implements Autenticacao {
    
    // constrcutor aluno - valida e inicia atributos:
    public Aluno(String nome, int matricula, String curso, String login, String senha) {
        if (nome == null) {
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
        super(nome, matricula, curso, login, senha); // -> herda da superclasse abstrata Usuário
    }
    // implementação método da interface Autenticacao:
    @Override
    public String autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login do aluno para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do aluno para autenticar.\n");
        }        
        if ( login != this.getLogin() || senha != this.getSenha()) {
            return "\nFalha ao autenticar aluno: Login ou senha incorretos.";
        } else {
            return "\nLogado como aluno.";
        }
    }
    // método polimórfico - Relatórios aluno::
    public String gerarRelatorio() {
        return "Nome do aluno: "+this.getNomeAluno()+
        "\nMatrícula: "+this.getMatricula()+
        "\nCurso: "+this.getCursoAluno()+"\n";
    }
}