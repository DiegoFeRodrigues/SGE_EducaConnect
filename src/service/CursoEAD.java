package service;

import model.Curso;

public class CursoEAD extends Curso {
    // atributo:
    private String plataforma;
    // constructor herdando atributo nome de curso:
    public CursoEAD(String nome) {
        super(nome);
    }

    // constructor "hibrido", herdando nome de Curso
    // e iniciando plataforma como parâmetro no contrutor:
    public CursoEAD (String nome, String plataforma) {
        super(nome);
        this.plataforma = plataforma;
    }
    // sobrescrevendo método detalharCurso da classe curso:
    @Override
    public String detalharCurso() {
        return "\nDetalhes do curso:"+
        "\nCurso de "+this.getNomeCurso()+"."+
        "\nPlataforma: "+this.plataforma+".";
    }
}
