public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos:
        Aluno aluno = new Aluno("Diego", "ADS", 12345);
        Curso curso = new Curso("ADS", 54321, 2180f);
        Professor professor = new Professor("Mestre Roshi", "Estilo da tartaruga", 00001);
        
        Aluno aluno2 = new Aluno("Jacinto", "Pedagogia", 578913);
        Curso curso2 = new Curso("Pedagogia", 58931, 3865.3f);
        Professor professor2 = new Professor("Ananias", "C#", 237189);
        
        // saída:
        System.out.println("Dados do aluno:\n"+
        aluno.dadosAluno()+"\n\nDados do curso:\n"+
        curso.dadosCurso()+"\n\nDados do professor:\n"+
        professor.dadosProf());

        System.out.println("\n DADO 2:\n"+aluno2.dadosAluno()+
        " "+curso2.dadosCurso()+" "+professor2.dadosProf());


        Turma tur = new Turma();

        tur.setCodigoTur(curso);
        tur.setNomeCurso(curso);
        tur.setProfessor(professor);

        Turma tur2 = new Turma();

        tur2.setCodigoTur(curso2);
        tur2.setNomeCurso(curso2);
        tur2.setProfessor(professor2);
        
        System.out.println(tur.toString());

        System.out.println(tur2.toString());

    }
}