import repository.ArmazTemporario;
import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****\n\n");
            ArmazTemporario dadosSalvos = new ArmazTemporario();
    
            MenuInterativo menuI = new MenuInterativo(dadosSalvos);
            menuI.Menu();        
        }
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println(npeOUiae);
        }
    }
}