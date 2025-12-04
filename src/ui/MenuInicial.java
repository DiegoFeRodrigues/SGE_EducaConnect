package ui;

import java.util.Scanner;

import model.Administrador;
import repository.ArmazTemporario;
import service.Apoio;

public class MenuInicial {
    public static void bemVindo() {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("*************************************************************");
        System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****");
        System.out.println("\n\nBem vindo(a)");
        System.out.println("\n\n\nFazer login como:");
        System.out.println("\n\n1 - Administrador(a):");
        System.out.println("\n2 - Professor(a):");
        System.out.println("\n3 - Aluno(a):");
        System.out.println("\n\nAinda não está cadastrado(a)?");
        System.out.println("\n4 - Fazer cadastro:");
        System.out.print("\nDigite opção: ");  
        Apoio.validaNumeroMenu(scan);
        int opcao = scan.nextInt();
        scan.nextLine();

        switch (opcao) {
            case 1:
                ArmazTemporario.mostraListaAdms();
                System.out.println(ArmazTemporario.listaAlunos);
                System.out.print("\nLogin de Administrador: ");
                String login = scan.nextLine();
                
                System.out.print("\nSenha de Administrador: ");
                String senha = scan.nextLine();
                
                
                
                for (Administrador adm : ArmazTemporario.listaAdm) {
                    System.out.println(adm);
                    adm.autenticar(login, senha);
                }



        }

    }
    public static void main(String[] args) {
        ArmazTemporario.listaAdm.add(new Administrador("adm", "0000"));
        MenuInicial.bemVindo();

    }
}

