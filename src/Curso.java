public class Curso {
    // atributos:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    //constructor - todos atributos:
    public Curso(String nomeCur, int codigo, float carga) {
        this.nomeCurso = nomeCur;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }
    // constructor - apenas nome:
    public Curso (String nome) {
        this.nomeCurso = nome;
    }
    //getters nome curso:
    public String getNomeCurso() {
        return nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }
    public float getCarga() {
        return cargaHoraria;
    }
    // saída curso:
    public String detalharCurso() {
        return "\n\nDados curso:\nNome do curso: "+getNomeCurso()+
        "\nCódigo: "+this.codigo+"\nCarga horária: "+this.cargaHoraria;
    }
}