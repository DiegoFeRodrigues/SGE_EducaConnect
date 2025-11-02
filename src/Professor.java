public class Professor {
    // atributos professor:
    private String nomeProfessor, especialidade;
    private int registro;
    // constructor:
    public Professor(String nomeProf, String espec, int reg) {
        this.nomeProfessor = nomeProf;
        this.especialidade = espec;
        this.registro = reg;
    }
    // getter nome professor - usado em Turma:
    public String getNomeProf() {
        return nomeProfessor;
    }
}