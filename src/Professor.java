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
            System.out.println("\nFalha ao autenticar professor: Login ou senha incorretos.\n");
            return false;
        } else {
            System.out.println("\nLogado como Professor.");
            return true;
        }
    }
    // método com dados - professor:
    public String dadosProf() {
        return "\nNome do Professor: "+this.getNome()+
        "\nRegistro: "+this.registro+
        "\nEspecialidade: "+this.especialidade+"\n";
    }    
}