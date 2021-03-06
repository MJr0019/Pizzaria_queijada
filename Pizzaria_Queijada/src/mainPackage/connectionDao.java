package mainPackage;

import clientePackage.Cliente;
import funcionariosPackage.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import produtoPackage.Produto;
import pedidoPackage.Pedido;

public class connectionDao {

    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "5500";
        String db_name = "postgres";
        String username = "postgres";
        String password = "12345";

        Scanner sc = new Scanner(System.in);
        Scanner oqfazer = new Scanner(System.in);
        Scanner cardapio = new Scanner(System.in);
        Funcionario fc = new Funcionario();
        Cliente cl = new Cliente();
        Produto pt = new Produto();
        Pedido pd = new Pedido();

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
            System.out.println("=== Sistema conectado ao banco de dados! ===");

            Statement stmt = con.createStatement();

            System.out.println("\n" + "Digite a Matricula:");
            int matriculaAuthenticar = sc.nextInt();

            String SQL_matricula = "SELECT * FROM funcionario WHERE matricula='" + matriculaAuthenticar + "'";
            ResultSet matriculaAuthenticator = stmt.executeQuery(SQL_matricula);

            if (matriculaAuthenticator.next()) {
                System.out.println("\n" + "Matricula Confirmada!");

                System.out.println("\n" + "Digite sua senha:");
                String SenhaAuthenticar = sc.next();

                String SQL_Senha = "SELECT * FROM funcionario WHERE matricula='" + matriculaAuthenticar
                        + "' AND senha='" + SenhaAuthenticar + "'";
                ResultSet SenhaAuthenticator = stmt.executeQuery(SQL_Senha);

                if (SenhaAuthenticator.next()) {
                    System.out.println("\n" + "Senha Confirmada!");
                    System.out.println("\n" + " ======== Bem-vindo ao Sistema ========");
                    System.out.println(" ======== Pizzaria Queijada ========" + "\n");
                    System.out.println(
                            "Escolha uma opcao abaixo:\n" + "\n"
                            + " ======== Funcionalidades de Funcionarios ===== \n"
                            + "1 - Registrar novo Funcionario\n"
                            + "2 - Atualizar Funcionario\n"
                            + "3 - Apagar Funcionario\n "
                            + "\n ======== Funcionalidades de Cliente ===== \n"
                            + "4 - Registrar novo Cliente\n"
                            + "5 - Atualizar Cliente\n"
                            + "6 - Apagar Cliente\n"
                            + "7 - Realizar Pedido para Cliente. \n"
                            + "\n ======== Funcionalidades de Produto ===== \n"
                            + "8  - Registrar novo Produto\n"
                            + "9  - Atualizar Produto\n"
                            + "10 - Apagar Produto\n"
                            + "\n ======== Funcionalidades de Pedido ===== \n"
                            + "11 - Atualizar Pedido\n"
                            + "12 - Apagar Pedido\n"
                            + "\n ======== Sair do Sistema ===== \n"
                            + "0 - Log-out (Sair do Sistema) \n "
                    );
                    int oqf = oqfazer.nextInt();

                    // Funcionario //
                    if (oqf == 1) {
                        System.out.println("\n" + "Vamos Registrar um novo Funcionario! \n");

                        System.out.println("Digite a Matricula:");
                        fc.setMatricula(sc.nextInt());

                        System.out.println("Digite o Nome:");
                        fc.setNome(sc.next());

                        System.out.println("Digite o Endereco:");
                        fc.setEndereco(sc.next());

                        System.out.println("Digite a Senha:");
                        fc.setSenha(sc.next());

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.gravar(fc);

                    }
                    //Atualizar funcionario
                    if (oqf == 2) {
                        System.out.println("\n" + "Vamos Atualizar os dados do Funcionario! \n");
                        System.out.println("Digite uma Matricula Existente:");
                        fc.setMatricula(sc.nextInt());

                        System.out.println("Atualize o Nome:");
                        fc.setNome(sc.next());

                        System.out.println("Atualize o Endereco:");
                        fc.setEndereco(sc.next());

                        System.out.println("Atualize a Senha:");
                        fc.setSenha(sc.next());

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.update(fc);
                    }
                    //Apagar funcionario
                    if (oqf == 3) {
                        System.out.println("\n" + "Vamos apagar o Funcionario! \n");
                        System.out.println("Digite a Matricula do Funcionario que vai ser apagado:");
                        fc.setMatricula(sc.nextInt());
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.deleteFuncionario(fc);
                    }

                    //Registrar novo Cliente //
                    if (oqf == 4) {
                        System.out.println("Vamos Registrar um novo Cliente! \n");
                        System.out.println("Digite o codigo do novo cliente:");
                        cl.setCodigoCliente(sc.nextInt());
                        //
                        System.out.println("Digite o nome do cliente:");
                        cl.setNome(sc.next());
                        //
                        System.out.println("Digite o endere??o do cliente:");
                        cl.setEndereco(sc.next());
                        //
                        System.out.println("Digite o telefone do cliente:");
                        cl.setTel(sc.next());
                        //
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.CadastrarCliente(cl);
                    }
                    //   Atualziar cliente
                    if (oqf == 5) {
                        System.out.println("Vamos Atualizar os dados do cliente! \n");
                        System.out.println("Digite um Codigo de um cliente existente:");
                        cl.setCodigoCliente(sc.nextInt());
                        //
                        System.out.println("Atualize o nome do cliente:");
                        cl.setNome(sc.next());
                        //
                        System.out.println("Atualize o endere??o do cliente:");
                        cl.setEndereco(sc.next());
                        //
                        System.out.println("Atualize o telefone do cliente:");
                        cl.setTel(sc.next());
                        //
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.AtualizarCliente(cl);
                    }
                    // Apagar cliente
                    if (oqf == 6) {
                        System.out.println("Vamos apagar o cliente! \n");
                        System.out.println("Digite o Codigo do Cliente que vai ser apagado:");
                        cl.setCodigoCliente(sc.nextInt());
                        //
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.ApagarCliente(cl);
                    }
                    //   Realizar pedido para Cliente
                    if (oqf == 7) {

                        Math.random();
                        int pedido = (int) (Math.random() * 2000);

                        fc.setCodigoPedido(pedido); // N??mero do Pedido

                        System.out.println("Digite o Codigo do cliente:");
                        fc.setCodigoCliente(sc.nextInt()); // C??digo do cliente

                        fc.setCodigoFuncionario(matriculaAuthenticar); // Matricula do Funcionario logado.

                        LocalDate lD = LocalDate.now(); // Data dinamica no B.D

                        int ValorDoProdutoTotal = 0;

                        System.out.println("\nREALIZAR PEDIDO: Os produtos disponiveis abaixo:");
                        System.out.println("\n"+"Escolha uma opcao abaixo: EX: 1001 ou 1002 ...\n");

                        daoControllerMetodos vvs = new daoControllerMetodos();
                        List<Produto> lt = vvs.getCartapio();

                        for (Produto produto : lt) {
                            System.out.println(produto);
                        }
//
//
//
                        int cp = cardapio.nextInt();

                        if (cp == 1001) {

                            ValorDoProdutoTotal = 5;

                        }

                        if (cp == 1002) {

                            ValorDoProdutoTotal = 6;

                        }
                        if (cp == 1003) {

                            ValorDoProdutoTotal = 6;

                        }
                        if (cp == 1004) {

                            ValorDoProdutoTotal = 8;

                        }
                        if (cp == 1005) {

                            ValorDoProdutoTotal = 7;

                        }
                        if (cp == 1006) {

                            double change = 3.50;
                            ValorDoProdutoTotal = (int) change;

                        }
                        if (cp == 1007) {
                            double change = 3.50;
                            ValorDoProdutoTotal = (int) change;

                        }

                        fc.setValorTotal(ValorDoProdutoTotal);

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.RealizarPedido(fc, lD);
                    }
                    //   registrar novo produto
                    if (oqf == 8) {
                        System.out.println("Vamos registrar um novo produto! \n");

                        System.out.println("Digite o Codigo do produto:");
                        pt.setCodigoProduto(sc.nextInt());
                        //
                        System.out.println("Digite do nome do produto:");
                        pt.setNome(sc.next());
                        //
                        System.out.println("Digite do preco Unitario:");
                        pt.setPrecoUnitario(sc.nextDouble());
                        //

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.CadastrarProduto(pt);
                    }
                    //   Atualizar Produto
                    if (oqf == 9) {
                        System.out.println("Vamos Atualizar o produto! \n");

                        System.out.println("Digite um Codigo de um produto existente:");
                        pt.setCodigoProduto(sc.nextInt());
                        //
                        System.out.println("Atualize o nome do produto:");
                        pt.setNome(sc.next());
                        //
                        System.out.println("Atualize o preco Unitario:");
                        pt.setPrecoUnitario(sc.nextDouble());
                        //

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.AtualizarProduto(pt);
                    }
                    //  Apagar produto
                    if (oqf == 10) {
                        System.out.println("Vamos deletar o produto! \n");

                        System.out.println("Digite o Codigo do Produto que vai ser apagado:");
                        pt.setCodigoProduto(sc.nextInt());
                        //

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.deletarProduto(pt);
                    }

                    //   atualizar Pedido
                    if (oqf == 11) {
                        System.out.println("Vamos Atualizar o pedido! \n");

                        System.out.println("Digite um codigo do pedido Existente:");
                        pd.setCodigoPedido(sc.nextInt());
                        //
                        System.out.println("Atualize o codigo do cliente:");
                        pd.setCodigoCliente(sc.nextInt());
                        //
                        System.out.println("Atualize o codigo do funcionario:");
                        pd.setCodigoFuncionario(sc.nextInt());
                        //
                        System.out.println("Atualize o Valor do pedido:");
                        pd.setValorTotal(sc.nextInt());

                        int x, y, z;
                        System.out.println("Atualize o ano de criacao do pedido: ");
                        x = sc.nextInt();
                        System.out.println("Atualize o mes de criacao do pedido: ");
                        y = sc.nextInt();
                        System.out.println("Atualize o dia de criacao do pedido: ");
                        z = sc.nextInt();

                        LocalDate lD = LocalDate.of(x, y, z);
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.AtualizarPedido(pd, lD);
                    }
                    if (oqf == 12) {
                        System.out.println("\n" + "Vamos apagar o Pedido! \n");
                        System.out.println("Digite o codigo do pedido que vai ser apagado:");
                        fc.setCodigoPedido(sc.nextInt());
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.ApagarPedido(fc);
                    }
                    if (oqf == 0) {
                        con.close();
                        System.out.println("\nLogoff Realizado! \n");
                    }
                } else {
                    System.out.println("\n" + "Senha Invalida." + "\n");
                }
            } else {
                System.out.println("\n" + "Matricula Invalida." + "\n");
            }
            con.close();
            System.out.println("Conexao encerrada!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
