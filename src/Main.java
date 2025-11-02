public class Main {
    public static void main(String[] args) {
        // bloco try para tentar a validação na instancia de objetos:
        try {
            // instanciando objetos - alunos:
            Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
            Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
            Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
            Aluno aluno4 = new Aluno("Yamcha", "Artes marciais", 7);
            // cursos:
            Curso curso1 = new Curso("ADS", 54321, 2180f);
            Curso curso2 = new Curso("Artes marciais", 98765, 10000f);
            // professores:
            Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
            Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
            // turmas:
            Turma tur1 = new Turma(curso1, curso1, professor1);
            Turma tur2 = new Turma(curso2, curso2, professor2);

            // adicionando aluno em seus cursos:
            System.out.println("\nAlunos adicionados:");
            //turma 1:
            tur1.addAluno(aluno1, curso1);
            //turma 2:
            tur2.addAluno(aluno2, curso2);
            tur2.addAluno(aluno3, curso2);
            tur2.addAluno(aluno4, curso2);
    
            // removendo aluno:
            System.out.println("\nAlunos removidos:");
            tur2.removeAluno(aluno4, curso2);
    
            // saída com retorno do método resumoTurma():
            System.out.println(tur1.resumoTurma()+"\n"+tur2.resumoTurma()+"\n");
        }
        // bloco catch para captura e saída de erros de objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalAccessError npeouiae) {
            System.err.println("Erro: "+npeouiae.getMessage());
        }

    }
}