public class Main {
    public static void main(String[] args) {
        // bloco try - tenta validação na instancia de objetos:
        try {
            System.out.println("\n*** EduConnect - Sistema de Gestão Educacional (SGC) ***");
            
            // instanciando objetos pra testar FaseCinco: - ADMINISTRADORES:
            Administrador adm1 = new Administrador("adm", "0000");
            Administrador adm2 = new Administrador("Admin","12345");
            
            // ALUNOS:
            Aluno aluno1 = new Aluno("Diego", 12345, "ADS", "D", "98765");
            Aluno aluno2 = new Aluno("Kuririn", 18, "Artes Marciais", "marron", "98@k9Lç$");
            
            // PROFESSORES:
            Professor prof1 = new Professor("Mestre Kame", "Estilo da targatura", 1, "roshi", "jackiechun");
            Professor prof10 = new Professor("Walter White", "Química", 19, "WWhite", "Heisenberg{}*@s");
            
            // saída com retorno do método autenticar - ADMINISTRADORES:
            // adm1 - login e senha corretos:
            adm1.autenticar("adm","0000"); 
            
            // adm2 - LOGIN INCORRETO:
            adm2.autenticar("adm", "12345");
            
            // ALUNOS:
            // adm1 - login e senha corretos:
            aluno1.autenticar("D","98765");
            
            // aluno2 - SENHA INCORRETA:
            aluno2.autenticar("marron", "98k9L$");
            
            // PROFESSORES:            
            // adm1 - login e senha corretos:
            prof1.autenticar("roshi", "jackiechun");
            
            // prof10 - LOGIN E SENHA INCORRETOS:
            prof10.autenticar("wWhite", "Heisenberg{*s");
        }
        // bloco catch para captura e saída de erros de objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("\nErro: "+npeouiae.getMessage());        
        }
    }
}