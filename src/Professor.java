public class Professor {
    // atributos professor:
    private String nomeProfessor, especialidade;
    private int registro;
    // constructor professor - valida e inicia atributos:
    public Professor(String nomeProf, String espec, int reg) {
        if (nomeProf == null) {
            throw new NullPointerException("Informe o nome do professor.");
        }
        if (espec == null) {
            throw new NullPointerException("Informe a especialidade do professor.");
        }
        if (reg <= 0) {
            throw new IllegalArgumentException("O número de registro do professor deve ser maior que 0.");
        }
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