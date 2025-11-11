public class Professor extends Usuario implements Autenticacao{
    
    // constrcutor professor - valida e inicia atributos:
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
        super(nomeProfessor, especialidade, registro, login, senha); // -> herda da superclasse abstrata Usuário
    }
    // implementação método da interface Autenticacao:
    @Override    
    public String autenticar(String login, String senha) {
        if (login == null) {
            throw new NullPointerException("Informe o login do professor para autenticar.\n");
        }
        if (senha == null) {
            throw new NullPointerException("Informe a senha do professor para autenticar.\n");
        }        
        if ( login != this.getLogin() || senha != this.getSenha()) {
            return "\nFalha ao autenticar professor: Login ou senha incorretos.\n";
        } else {
            return"\nLogado como Professor.";
        }
    }
    // método polimórfico - Relatório prof.:
    public String gerarRelatorio() {
        return "\nNome do professor: "+this.getNomeProfessor()+
        "\nRegistro: "+this.getRegistro()+
        "\nEspecialidade: "+this.getEspecialidade();
    }
}