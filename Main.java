public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos - alunos:
        Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
        Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
        Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
        Aluno aluno4 = new Aluno("Yamcha", "Artes marciais", 7);
        // cursos:
        Curso curso1 = new Curso("ADS", 54321, 2180f);
        Curso curso2 = new Curso("Artes marciais", 98765, 3865.3f);
        // professores:
        Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
        Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
        // turmas:
        Turma tur1 = new Turma(curso1, curso1, professor1);
        Turma tur2 = new Turma(curso2, curso2, professor2);

        // saída:
        // System.out.println(aluno1.toString()+curso1.toString()+
        // professor1.toString()+"\n\n"+aluno2.toString()+curso2.toString()+
        // professor2.toString()+tur1.toString()+tur2.toString());

        // adicionando aluno em seus cursos:
        System.out.println("Alunos adicionados:");
        tur1.addAluno(aluno1, curso1);
        tur2.addAluno(aluno2, curso2);
        tur2.addAluno(aluno3, curso2);
        tur2.addAluno(aluno4, curso2);

        // removendo aluno:
        System.out.println("\nAlunos removidos:");
        tur2.removeAluno(aluno4, curso2);

        System.out.println(tur1.toString()+"\n"+tur2.toString());

        Avaliacao prova = new Avaliacao("Prova de POO.");

        // prova.atribuirNota(10);

        prova.atribuirNota(aluno1, 6);

        Avaliacao treino = new Avaliacao("Carregar caixas de leite.");

        treino.atribuirNota(aluno2, 5);
        treino.atribuirNota(aluno3, 10);
        
        System.out.println(prova.toString()+"\n"+
        treino.toString());
    }
}