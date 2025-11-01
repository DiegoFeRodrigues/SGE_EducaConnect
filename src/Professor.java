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
    // método saída p/ testar professor:
    public String dadosProf() {
        return "Nome do Professor: "+this.nomeProfessor+
        "\nRegistro: "+this.registro+
        "\nEspecialidade: "+this.especialidade;
    }
}