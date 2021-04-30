package mainPackage;

import funcionariosPackege.funcionario;
import java.util.Scanner;

public class mainexec {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        funcionario fc = new funcionario();
        funcionario updd = new funcionario();
        Scanner oqfazer = new Scanner(System.in);

        System.out.println("\n1 - Grava \n2 - Atualizar \n");

        int oqf;
        oqf = oqfazer.nextInt();
//
//
//
        if (oqf == 1) {
            System.out.println("Vamos gravar \n");

            System.out.println("Digite sua MATRICULA");
            fc.setMatricula(sc.nextInt());

            System.out.println("Digite seu NOME");
            fc.setNome(sc.next());

            System.out.println("Digite seu ENDERECO");
            fc.setEndereco(sc.next());

            System.out.println("Digite sua SENHA");
            fc.setSenha(sc.nextInt());

            daoControllerMetodos VrController = new daoControllerMetodos();
            VrController.gravar(fc);
        } else {
            System.out.println("Opção invalida");
        }

///
///
//
        if (oqf == 2) {
            System.out.println("Vamos ATUALIZAR \n");
            System.out.println("Digite sua MATRICULA");
            fc.setMatricula(sc.nextInt());

            System.out.println("Digite seu NOME");
            fc.setNome(sc.next());

            System.out.println("Digite seu ENDERECO");
            fc.setEndereco(sc.next());

            System.out.println("Digite sua SENHA");
            fc.setSenha(sc.nextInt());

            daoControllerMetodos VrController = new daoControllerMetodos();
            VrController.update(fc);
        } else {
            System.out.println("Opção invalida");
        }
    }
}
