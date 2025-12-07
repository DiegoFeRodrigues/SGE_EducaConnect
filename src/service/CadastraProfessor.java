
/*
    Classe para cadastro de professores
    Com método polimórfico, input (scanner) de dados e usando método de apoio da classe Apoio.
*/

package service;

import java.util.Scanner;
import model.Professor;
import repository.ArmazTemporario;

public class CadastraProfessor {
    
    // método polimórfico:
    public static void cadastro(int numero) {

        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n***  Cadastrar Professor(a):  ***");
        System.out.println("*********************************");
        // nome:
        System.out.print("\nNome do(a) professor(a): "); 
        String nomeProf = scan.nextLine();
        
        // registro:
        int registro = numero;
        
        // especialidade:
        System.out.print("\nEspecialidade: ");
        String especialidade = scan.nextLine();
        
        // login:
        System.out.println("\n\n** Dados de login: **");
        System.out.print("\nLogin: ");
        String loginProf = scan.nextLine();
        
        // senha:
        System.out.print("Senha: ");
        String senhaProf = scan.nextLine();
        
        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Professor:    
        try {
            // instanciando objetos Professor com dados informados e adicionando no armazenamento temporário em lista:
            ArmazTemporario.listaProf.add(new Professor(nomeProf, especialidade, registro, loginProf, senhaProf));
            System.out.println("\n\nProfessor(a) "+nomeProf+" foi cadastrado(a) com sucesso.");
            System.out.println("\nVolte ao Menu Inicial para fazer login.\n");
        }
        // captura exceções lançadas na instancia de objetos:
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\n\nFalha ao cadastrar professor(a): "+npeOUiae+"\n\n");
        }        
    }
}
