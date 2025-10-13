public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos:
        Aluno aluno = new Aluno("", "", 0);
        Curso curso = new Curso("", 0, 0);
        Professor professor = new Professor("", "", 0);
        // set atributos - aluno:
        aluno.setNome("Diego Ferreira Rodrigues");
        aluno.setCurso("ADS");
        aluno.setMatricula(123456);
        // set atributos - curso:
        curso.setNomeCurso("ADS");
        curso.setCodigo(54321);
        curso.setCarga(2180f);
        // set atributos - professor:
        professor.setNomeProf("Nome Prof!!!"); 
        professor.setEspec("POO");
        professor.setRegistro(56789);
        // saída:
        System.out.println("Dados do aluno:\n"+
        aluno.dadosAluno()+"\n\nDados do curso:\n"+
        curso.dadosCurso()+"\n\nDados do professor:\n"+
        professor.dadosProf());
    }
}