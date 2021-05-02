package mainPackage;

import funcionariosPackage.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class connectionDao {

    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "5500";
        String db_name = "postgres";
        String username = "postgres";
        String password = "12345";

        Scanner sc = new Scanner(System.in);
        Scanner oqfazer = new Scanner(System.in);
        Funcionario fc = new Funcionario();

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
            System.out.println("Estou conectado no banco de dados!!!");

            //
            //
            Statement stmt = con.createStatement();

            //fazer um if global, perguntar se é funcionario ou cliente
            //
            System.out.println("MATRICULA PARA AUTENTICAR"); //verificando se o usuário existe
            int nomeAuthenticar = sc.nextInt();

            String SQL = "SELECT * FROM funcionario WHERE matricula='" + nomeAuthenticar + "'";
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                System.out.println("USUARIO VALIDO");
                System.out.println(
                        "Escolha uma opção abaixo:\n"
                        + "1 - Registrar \n" //adicionar
                        + "2 - Atualizar \n" //editar
                        + "3-  Realizar Pedido \n\n"
                        + " ======== Funcionalidades de APAGAR ===== \n"
                        + "4 - apagar clientes \n"
                        + "5 - Apagar Produtos \n"
                        + "6 - Apagar Pedidos \n"
                        + "7 - Apagar funcionários \n "
                );
                int oqf = oqfazer.nextInt();
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
//
//   Fazer pedido pedido
                if (oqf == 3) {
                    System.out.println("\nREALIZAR PEDIDO: Os produtos disponiveis abaixo:");

                    System.out.println( //passar o if pelo número do pedido
                            "Escolha uma opção abaixo:\n"
                            + "(1001) 1 - Pizza Muçarela: R$:5.00\n"
                            + "(1002) 2 - Pizza Calabresa R$:6.00\n"
                            + "(1003) 3-  Pizza Presunto R$:6.00\n"
                            + "(1004) 4 - Refrigerante de cola R$:8.00\n"
                            + "(1005) 5 - Refrigerante de laranja R$:7.00\n"
                            + "(1006) 6 - Mini pudim R$:3.50\n"
                            + "(1007) 7 - Brigadeiro R$:2.50\n "
                    );

                    System.out.println("Digite o Código do pedido");
                    fc.setMatricula(sc.nextInt());

//                    System.out.println("Digite o Codigo do cliente");
//                    fc.setNome(sc.next());
                    System.out.println("Digite o código do funcionario");
                    fc.setEndereco(sc.next());

                    System.out.println("Valor total");
                    fc.setEndereco(sc.next());

                    System.out.println("Digite a data do pedido");
                    fc.setSenha(sc.next());
                }

//
//   Apagando Funcionario
//
                if (oqf == 7) {
                    System.out.println("Vamos APAGAR \n");
                    System.out.println("Digite A MATRICULA do FUNCIONADO que vai ser apagado");
                    fc.setMatricula(sc.nextInt());
                    daoControllerMetodos VrController = new daoControllerMetodos();
                    VrController.deleteFuncionario(fc);
                }

            } else {
                System.out.println("USUARIO INVALIDO");
            }
            con.close();
            System.out.println("Conexão encerrada!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
