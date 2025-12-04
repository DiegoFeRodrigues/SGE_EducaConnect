
/*
    Classe para cadastro de professores
    Com método polimórfico, input (scanner) de dados e usando método de apoio da classe ValidaDados.
*/

package service;

import java.util.Scanner;
import model.Professor;
import repository.ArmazTemporario;

public class CadastraProfessor {
    
    // método polimórfico:
    public static void cadastro(int numero) {

        Scanner scan = new Scanner(System.in);

        // nome:
        System.out.print("\nNome do professor: "); 
        String nomeProf = scan.nextLine();
        
        // registro:
        int registro = numero;
        
        // especialidade:
        System.out.print("\nEspecialidade do professor "+nomeProf+": ");
        String especialidade = scan.nextLine();
        
        // login:
        System.out.print("\nLogin: ");
        String loginProf = scan.nextLine();
        
        // senha:
        System.out.print("Senha: ");
        String senhaProf = scan.nextLine();
        
        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Professor:    
        try {
            // instanciando objetos Professor com dados informados e adicionando no armazenamento temporário em lista:
            Professor professor = new Professor(nomeProf, especialidade, registro, loginProf, senhaProf);
            ArmazTemporario.listaProf.add(professor);
            System.out.println("\nProfessor "+professor.getNome()+" foi cadastrado com sucesso.\n\n");
        }
        // captura exceções lançadas na instancia de objetos:
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\nFalha ao cadastrar professor: "+npeOUiae+"\n\n");
        }        
    }
}
