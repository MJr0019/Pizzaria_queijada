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

            System.out.println("MATRICULA PARA AUTENTICAR");
            int nomeAuthenticar = sc.nextInt();

            String SQL = "SELECT * FROM funcionario WHERE matricula='" + nomeAuthenticar + "'";
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                System.out.println("USUARIO VALIDO");
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

//   Apagando Funcionario
//
                if (oqf == 6) {  //fazer uma verificão da pessoa que está deletando
                    System.out.println("Vamos APAGAR \n");
                    System.out.println("Digite A MATRICULA do FUNCIONADO que vai ser apagado");
                    fc.setMatricula(sc.nextInt());
                    daoControllerMetodos VrController = new daoControllerMetodos();
                    VrController.deleteFuncionario(fc);
                }

            } else {
                System.out.println("USUARIO INVALIDO");
            }
//
//
//
            con.close();
            System.out.println("Conexão encerrada!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
