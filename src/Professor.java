public class Professor {
    // atributos professor:
    String nomeProfessor;
    String especialidade;
    int registro;
    // constructor professor - valida e inicia atributos:
    public Professor(String nomeProf, String especialidade, int registro) {
        if (nomeProf == null) {
            throw new NullPointerException("Informe o nome do professor.");
        }
        if (especialidade == null) {
            throw new NullPointerException("Informe a especialidade do professor.");
        }
        if (registro <= 0) {
            throw new IllegalArgumentException("Número de registro inválido.");
        }
        this.nomeProfessor = nomeProf;
        this.especialidade = especialidade;
        this.registro = registro;
    }
    // método saída p/ testar dados professor:
    public String dadosProf() {
        return "Nome do Professor: "+this.nomeProfessor+
        "\nRegistro: "+this.registro+
        "\nEspecialidade: "+this.especialidade;
    }
}