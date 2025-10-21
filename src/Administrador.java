public class Administrador implements Autenticacao{
    // atributo:
    private String login, senha;
    // constructor:
    public Administrador(String log, String se) {
        this.login = log;
        this.senha = se;
    }
    // implementando método autenticar da classe abstrata autenticacao:
    @Override
    public void autenticar(String l, String s) {
        if (login == l && senha == s){
            System.out.println("\nLogin efetuado com sucesso!");
        } else {
            System.out.println("\nUsuário ou senha incorretos!");
        }
    }

}
