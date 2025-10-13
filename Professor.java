public class Professor {
    // atributos:
    private String nomeProfessor, especialidade;
    private int registro;
    // constructor:
    public Professor(String nomeProf, String espec, int reg) {
        this.nomeProfessor = nomeProf;
        this.especialidade = espec;
        this.registro = reg;
    }
    // getters e setters - professor:
    public String getNomeProf() {
        return nomeProfessor;
    }
    public void setNomeProf(String nome) {
        this.nomeProfessor = nome;
    }
    public String getEspec() {
        return especialidade;
    }
    public void setEspec(String espec) {
        this.especialidade = espec;
    }
    public int getRegistro() {
        return registro;
    }
    public void setRegistro(int registro) {
        this.registro = registro;
    }
    // método saída:
    public String dadosProf() {
        return "Nome do Professor: "+getNomeProf()+
        "\nRegistro: "+getRegistro()+
        "\nEspecialidade: "+getEspec();
    }
}