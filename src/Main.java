import repository.ArmazTemporario;
import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****\n");
        ArmazTemporario dadosSalvos = new ArmazTemporario();

        MenuInterativo menuI = new MenuInterativo(dadosSalvos);
        menuI.Menu();

        
    }
}