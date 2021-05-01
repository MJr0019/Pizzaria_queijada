package mainPackage;

import funcionariosPackage.authenticationUsers;
import funcionariosPackage.Funcionario;
import java.util.Scanner;

public class mainexec {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Funcionario fc = new Funcionario();
        Funcionario updd = new Funcionario();
        Scanner oqfazer = new Scanner(System.in);

//        System.out.println("Digite sua MATRICULA");
//        fc.setMatricula(sc.nextInt());
//
//        authenticationUsers V = new authenticationUsers();
//        V.authFuncionario(fc);
//
//
//
        System.out.println(
                "Escolha uma opção abaixo:\n"
                + "1 - Registrar \n" //adicionar
                + "2 - Atualizar \n" //editar
                + "3 - apagar clientes \n"
                + "4 - Produtos \n"
                + "5 - Pedidos \n"
                + "6 - funcionários \n "
        );
        int oqf = oqfazer.nextInt();
//
//authFuncionario

        /*
    fazer um if de altenticação do Funcionario para autorizar os outros metodos,
    para habilitar os outros metodos
         */
//
        if (oqf == 1) {
            System.out.println("Vamos Registrar \n");

            System.out.println("Digite sua MATRICULA");
            fc.setMatricula(sc.nextInt());

            System.out.println("Digite seu NOME");
            fc.setNome(sc.next());

            System.out.println("Digite seu ENDERECO");
            fc.setEndereco(sc.next());

            System.out.println("Digite sua SENHA");
            fc.setSenha(sc.next());

            daoControllerMetodos VrController = new daoControllerMetodos();
            VrController.gravar(fc);
        }
//
//   update atualizar
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
            fc.setSenha(sc.next());

            daoControllerMetodos VrController = new daoControllerMetodos();
            VrController.update(fc);
        }
//
//   Apagando Funcionario
//
        if (oqf == 6) {  //fazer uma verificão da pessoa que está deletando
            System.out.println("Vamos APAGAR \n");
            System.out.println("Digite A MATRICULA do FUNCIONADO que vai ser apagado");
            fc.setMatricula(sc.nextInt());

//            System.out.println("Digite o NOME do FUNCIONADO que vai ser apagado ");
//            fc.setNome(sc.next());
            daoControllerMetodos VrController = new daoControllerMetodos();
            VrController.deleteFuncionario(fc);
        }
    }
}
