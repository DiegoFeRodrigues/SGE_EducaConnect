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

        // saída com resumo das turmas:
        System.out.println(tur1.toString()+"\n"+tur2.toString());

        // instanciando nova avaliação:
        Avaliacao prova = new Avaliacao("Prova de POO.");
        // atribuindo nota e saída com resultado - turma 1:
        prova.atribuirNota(aluno1, 6f);
        System.out.println(tur1.avaliacao(aluno1, curso1, prova));

        // instanciando nova avaliação:
        Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
        // atribuindo nota e saída com resultado - turma 2:
        treino.atribuirNota(aluno2, 7.5f);
        System.out.println(tur2.avaliacao(aluno2, curso2, treino));
        treino.atribuirNota(aluno3, 10f);
        System.out.println(tur2.avaliacao(aluno3, curso2, treino));
    }
}