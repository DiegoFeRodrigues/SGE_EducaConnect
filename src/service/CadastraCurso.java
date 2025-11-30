
/*
    Classe para cadastro de cursos
    Com método polimórfico, input (scanner) de dados e usando método de apoio da classe TestaDados.
*/

package service;

import java.util.Scanner;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;

public class CadastraCurso {
    
    // método polimórfico:
    public static void cadastro() {

        Scanner scan = new Scanner(System.in);

        // menu de seleção de tipo de curso:
        System.out.println("\n\n** Cadastro de Curso **");
        System.out.println("\nTipo do curso:");
        System.out.println("1 - Curso EAD");
        System.out.println("2 - Curso Presencial");
        System.out.print("Informe o número que corresponde ao tipo de curso desejado: ");
        
        TestaDados.testaNumeroMenu(scan);   // -> testa se valor de menu informado é número inteiro.

        // seleção de tipo de curso, tratando se usuário digita apenas as opções disponíveis (1 ou 2):
        int tipoCurso = scan.nextInt();
        scan.nextLine();
        while (tipoCurso <= 0 || tipoCurso > 2) {
            System.out.println("\nErro: Opção inválida!");
            System.out.println("Digite 1 = Cadastrar curso EAD.");
            System.out.println("Digite 2 = Cadastrar curso Presencial.");
            System.out.print("Opção desejada: ");
            TestaDados.testaNumeroMenu(scan);   // -> testa se valor de menu informado é número inteiro.
            tipoCurso = scan.nextInt();
            scan.nextLine();
        }
        System.out.println("\nInforme os dados do curso:");

        // nome curso:
        System.out.print("Nome do curso: "); 
        String nomeCurso = scan.nextLine();
        
        // código:
        System.out.print("Código: ");
        String codigoCurso = "o código do curso de "+nomeCurso+": ";
        TestaDados.testaNumeroDados(scan, codigoCurso);     // -> testa se valor de código informado é número inteiro.
        int codigo = scan.nextInt();
        scan.nextLine();

        // carga horária:
        System.out.print("Carga horária: ");
        while (!scan.hasNextFloat()) {  // -> testa se valor de carga horária informada é número (real, flutuante);
            System.out.println("\nCarga horária não pode conter letras.");
            System.out.print("Informe a carga horária do curso de "+nomeCurso+": ");
            scan.nextLine();
        }
        float cargaHoraria = scan.nextFloat();
        scan.nextLine();

        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Curso:        
        try {
            // instanciando objetos Curso (EAD e Presencial) com dados informados e adicionando no armazenamento temporário em lista:
            if (tipoCurso == 1) {   // CURSO EAD - PLATAFORMA:
                System.out.print("Plataforma EAD: ");
                String plataforma = scan.nextLine();
                Curso cursoEAD = new CursoEAD(nomeCurso, codigo, cargaHoraria, plataforma);
                repository.ArmazTemporario.listaCursos.add(cursoEAD);
                System.out.println("\nCurso EAD de "+cursoEAD.getNomeCurso()+" foi cadastrado com sucesso.\n\n");
            } else if (tipoCurso == 2) {    // CURSO PRESENCIAL - SALA:
                System.out.print("Sala: ");
                String sala = scan.nextLine();
                Curso cursoPresencial = new CursoPresencial(nomeCurso, codigo, cargaHoraria, sala);
                repository.ArmazTemporario.listaCursos.add(cursoPresencial);
                System.out.println("\nCurso Presencial de "+cursoPresencial.getNomeCurso()+" foi cadastrado com sucesso.\n\n");
            }
        }
        // captura exceções lançadas na instancia de objetos:
        catch (NullPointerException npe) {
            System.err.println("\nFalha ao cadastrar curso: "+ npe+"\n\n");
        }        
    }
}
