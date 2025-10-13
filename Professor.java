public class Professor {

    private String nomeProfessor, especialidade;
    private int registro;
    
    public Professor(String nome, String espec, int reg) {
        this.nomeProfessor = nome;
        this.especialidade = espec;
        this.registro = reg;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }
    public void setNomeProfessor(String nome) {
        this.nomeProfessor = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public int getRegistro() {
        return registro;
    }
    public void setRegistro(int registro) {
        this.registro = registro;
    }
}
