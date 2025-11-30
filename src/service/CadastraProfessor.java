
/*
    Classe para cadastro de professores
    Com input (scanner) de dados e usando método de apoio da classe TestaDados para testar e validar número de registro informado. 
*/

package service;

import java.util.Scanner;
import model.Professor;

public class CadastraProfessor {
    
    public static void cadastraProf() {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n** Cadastro de professor **");
        System.out.println("\nInforme os dados do professor:");
        
        // nome:
        System.out.print("Nome: "); 
        String nomeProf = scan.nextLine();
        
        // registro:
        System.out.print("Registro: ");
        String registroProf = "o NÚMERO de registro do professor: "; 
        TestaDados.testaNumeroDados(scan, registroProf);    // -> testa se valor informado é número inteiro.
        int registro = scan.nextInt();
        scan.nextLine();

        // especialidade:
        System.out.print("Especialidade do professor "+nomeProf+": ");
        String especialidade = scan.nextLine();
        
        // login:
        System.out.print("Login: ");
        String loginProf = scan.nextLine();
        
        // senha:
        System.out.print("Senha: ");
        String senhaProf = scan.nextLine();
        
        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Professor:    
        try {
            Professor professor = new Professor(nomeProf, especialidade, registro, loginProf, senhaProf);
            repository.ArmazTemporario.listaProf.add(professor);
            System.out.println("\nProfessor "+professor.getNome()+" foi cadastrado com sucesso.\n\n");
        }
        // captura exceções:
        catch (NullPointerException npe) {
            System.err.println("Falha ao cadastrar professor: "+npe+"\n\n");
        }        
    }
}
