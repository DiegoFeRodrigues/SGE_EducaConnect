public class Professor {

    private String nomeProfessor, especialidade;
    private int registro;
    
    public Professor(String nome, String espec, int reg) {
        this.nomeProfessor = nome;
        this.especialidade = espec;
        this.registro = reg;
    }

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
}
