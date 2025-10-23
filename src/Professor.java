public class Professor extends Usuario implements Autenticacao{
    // atributos:
    private String nomeProfessor, especialidade;
    private int registro;
    private String login, senha;
    // construtor inicial:
    public Professor(String nomeProf, String espec, int reg) {
        this.nomeProfessor = nomeProf;
        this.especialidade = espec;
        this.registro = reg;
    }
    // constructor novo - atributos da classe abstrata Usuario:
    public Professor(String nome, String espec, int reg, String login, String senha) {
        this.nomeProfessor = nome;
        this.especialidade = espec;
        this.registro = reg;
        this.login = login;
        this.senha = senha;
    }
    // getter nome professor - usado em Turma:
    public String getNomeProf() {
        return nomeProfessor;
    }
    // implementação método da interface Autenticacao:
    public void autenticar(String lgin, String pword) {
        if (lgin != login || pword != senha) { // == null também
            System.out.println("\nFalha ao autenticar professor:"+
            " Login ou senha incorretos");
        } else { // true ou != null
            System.out.println("\nDados do(a) professor(a):"+
            "\nNome: "+this.nomeProfessor+
            "\nRegistro: "+this.registro+
            "\nEspecialidade: "+this.especialidade);
        }
    }
}