
/*
    Classe para cadastro de cursos
    Com método polimórfico, input (scanner) de dados e usando método de apoio da classe ValidaDados.
*/

package service;

import java.util.Scanner;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;

public class CadastraCurso {
    
    // método polimórfico:
    public static void cadastro(int numero) {

        Scanner scan = new Scanner(System.in);

        // menu seleção de tipo de curso:
        
        System.out.println("\nTipo do curso:");
        System.out.println("1 - Curso EAD");
        System.out.println("2 - Curso Presencial");
        
        // seleção de tipo de curso, tratando se usuário digita apenas as opções disponíveis (1 ou 2):
        String mensagem = "ao tipo de curso desejado: ";
        String texto1 = "Digite 1 = Cadastrar curso EAD. \nDigite 2 = Cadastrar curso Presencial.";
        int tipoCurso = ValidaDados.validaMenu1ou2(scan, mensagem, texto1);
        
        
        // nome curso:
        System.out.print("\nNome do curso: "); 
        String nomeCurso = scan.nextLine();
        
        // código:
        int codigo = numero;
        
        // carga horária:
        String texto2 = "a carga horária do curso de "+nomeCurso+": ";
        ValidaDados.validaNumeroReal(scan, texto2); // testa se valor de carga horária informada é número real
        float cargaHoraria = scan.nextFloat();
        scan.nextLine();

        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor das classes Curso, CursoEAD e CursoPresencial:
        try {
            // instanciando objetos Curso (EAD e Presencial) com dados informados e adicionando no armazenamento temporário em lista:
            if (tipoCurso == 1) {   // CURSO EAD - PLATAFORMA:
                System.out.print("\nPlataforma EAD: ");
                String plataforma = scan.nextLine();
                Curso cursoEAD = new CursoEAD(nomeCurso, codigo, cargaHoraria, plataforma);
                repository.ArmazTemporario.listaCursos.add(cursoEAD); // adiciona curso EAD criado no armazenamento temporário em lista
                System.out.println("\nCurso EAD de "+cursoEAD.getNomeCurso()+" foi cadastrado com sucesso.\n\n");
            } else if (tipoCurso == 2) {    // CURSO PRESENCIAL - SALA:
                System.out.print("\nSala: ");
                String sala = scan.nextLine();
                Curso cursoPresencial = new CursoPresencial(nomeCurso, codigo, cargaHoraria, sala);
                repository.ArmazTemporario.listaCursos.add(cursoPresencial); // adiciona curso Presencial criado no armazenamento temporário em lista
                System.out.println("\nCurso Presencial de "+cursoPresencial.getNomeCurso()+" foi cadastrado com sucesso.\n\n");
            }
        }
        // captura exceções lançadas na instancia de objetos:
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\nFalha ao cadastrar curso: "+ npeOUiae+"\n\n");
        }        
    }
}
