public class Curso {
    // atributos:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    //constructor:
    public Curso(String nomeCur, int codigo, float carga) {
        this.nomeCurso = nomeCur;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }
    //getters e setters nome e código:
    public String getNomeCurso() {
        return nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }

    // saída curso:
    public String toString() {
        return "\n\nDados curso:\nNome do curso: "+getNomeCurso()+
        "\nCódigo: "+getCodigo()+"\nCarga horária: "+this.cargaHoraria;
    }
}