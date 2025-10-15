public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos - alunos:
        Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
        Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
        // cursos:
        Curso curso1 = new Curso("ADS", 54321, 2180f);
        Curso curso2 = new Curso("Artes marciais", 98765, 3865.3f);
        // professores:
        Professor professor1 = new Professor("Mestre Roshi", "Estilo da tartaruga", 00001);
        Professor professor2 = new Professor("Jack Chun", "Artes marciais", 00002);
        // turmas:
        Turma tur1 = new Turma(curso1, curso1, professor1);
        Turma tur2 = new Turma(curso2, curso2, professor2);

        // saída:
        System.out.println(aluno1.toString()+curso1.toString()+
        professor1.toString()+"\n\n"+aluno2.toString()+curso2.toString()+
        professor2.toString()+tur1.toString()+tur2.toString());
    }
}