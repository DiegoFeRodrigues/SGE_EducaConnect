package model;

import service.NumeroObjetoCadastro;

public class Curso implements NumeroObjetoCadastro {

    // atributos curso:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;

    // constructor curso - valida e inicia atributos:
    public Curso(String nomeCurso, int codigo, float cargaHoraria) {
        if (nomeCurso == null || nomeCurso.isEmpty()) {
            throw new NullPointerException("\n\nInforme o nome do curso.");
        }
        if (codigo <= 0) {
            throw new IllegalArgumentException("\n\nCodigo do curso deve ser maior que 0.");
        }
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("\n\nA carga horária do curso deve ser maior que 0.");
        }
        this.nomeCurso = nomeCurso;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }        
    //getters  - usados em Turma, CursoEAD, CursoPresencial e na interface NumeroObjetoCadastro:
    public String getNomeCurso() {
        return nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }
    public float cargaHoraria() {
        return cargaHoraria;
    }    
    public int getNumero() {
        return codigo;
    }    
    // Método gerarRelatorio() - Será sobrescrito nas subclasses:
    public String gerarRelatorio() {
        return "\nDados curso:"+
        "\nNome do curso: "+this.nomeCurso+        
        "\nCódigo: "+this.codigo+
        "\nCarga horária: "+this.cargaHoraria;
    }
}