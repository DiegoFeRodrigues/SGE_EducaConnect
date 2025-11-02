public class Curso {
    // atributos curso:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    // constructor curso - valida e inicia atributos:
    public Curso(String nomeCur, int codigo, float carga) {
        if (nomeCur == null) {
            throw new NullPointerException("Informe o nome do curso.");
        }
        if (codigo <= 0) {
            throw new IllegalArgumentException("Codigo do curso deve ser maior que 0.");
        }
        if (carga <= 0) {
            throw new IllegalArgumentException("A carga horária do curso deve ser maior que 0.");
        }
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