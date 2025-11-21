import repository.ArmazTemporario;
import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {

        ArmazTemporario dadosSalvos = new ArmazTemporario();

        MenuInterativo menuI = new MenuInterativo(dadosSalvos);
        menuI.Menu();

        
    }
}