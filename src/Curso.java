public class Curso {
    // atributos curso:
    String nomeCurso;
    int codigo;
    float cargaHoraria;
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
}