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
    
    // getters e setters nome professor:
    public String getNomeProf() {
        return nomeProfessor;
    }
    public void setNomeProf(String nome) {
        this.nomeProfessor = nome;
    }

    // saída professor:
    public String toString() {
        return "\n\nDados do Professor:\nNome do professor: "+
        this.nomeProfessor+"\nRegistro: "+this.registro+
        "\nEspecialidade: "+this.especialidade;
    }
}