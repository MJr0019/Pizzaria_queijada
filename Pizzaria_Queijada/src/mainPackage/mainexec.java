package mainPackage;

import funcionariosPackege.funcionario;
import java.util.Scanner;

public class mainexec {

    public static void main(String[] args) {

        funcionario fc = new funcionario();
        Scanner sc = new Scanner(System.in);
        fc.setMatricula(1);
        fc.setSenha(1);

        System.out.println("Qual a sua MATRICULA?");
        fc.setMatricula(sc.nextInt());
        System.out.println("Qual a sua MATRICULA?");
        fc.setSenha(sc.nextInt());

        System.out.println("Sua mtricula é:" + fc.getMatricula());
        System.out.println("Sua senha é:" + fc.getSenha());
    }
}
