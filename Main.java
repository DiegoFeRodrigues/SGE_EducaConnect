public class Main {
    public static void main(String[] args) {
        
        Aluno aluno = new Aluno("", "", 0);
        Curso curso = new Curso("", 0, 0);
        Professor professor = new Professor("", "", 0);

        aluno.setNome("Diego Ferreira Rodrigues");
        aluno.setCurso("ADS");
        aluno.setMatricula(123456);

        curso.setNomeCurso("ADS");
        curso.setCodigo(54321);
        curso.setCarga(2180f);

        professor.setNomeProf("Nome Prof!!!"); 
        professor.setEspec("POO");
        professor.setRegistro(98765);

        System.out.println("Dados do aluno:\n"+
        aluno.dadosAluno()+"\n\nDados do curso:\n"+
        curso.dadosCurso()+"\n\nDados do professor:\n"+
        professor.dadosProf());
    }
}
