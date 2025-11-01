public class Curso {
    // atributos:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    // constructor:
    public Curso(String nomeCur, int codigo, float carga) {
        this.nomeCurso = nomeCur;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }
    // método saída p/ testar curso:
    public String dadosCurso() {
        return "Curso: " +this.nomeCurso+
        "\nCódigo: "+this.codigo+
        "\nCarga horária: "+this.cargaHoraria;
    }
}