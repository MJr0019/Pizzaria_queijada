package mainPackage;

import clientePackage.Cliente;
import funcionariosPackage.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
        Scanner np = new Scanner(System.in);
        Scanner cardapio = new Scanner(System.in);
        Funcionario fc = new Funcionario();
        Cliente cl = new Cliente();

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
            System.out.println("Sistema conectado ao banco de dados!!!");

            //
            //
            Statement stmt = con.createStatement();

            //fazer um if global, perguntar se é funcionario ou cliente
            //
            System.out.println("\n" + "Digite a Matricula:"); //verificando se o usuário existe
            int matriculaAuthenticar = sc.nextInt();

            String SQL_matricula = "SELECT * FROM funcionario WHERE matricula='" + matriculaAuthenticar + "'";
            ResultSet matriculaAuthenticator = stmt.executeQuery(SQL_matricula);

            if (matriculaAuthenticator.next()) {
                System.out.println("\n" + "Matricula Confirmada!");

                System.out.println("\n" + "Digite sua senha:"); //verificando se a senha esta correta
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
                            + "1 - Registrar \n" //Adicionar F
                            + "2 - Atualizar \n" //Editar F
                            + "3 - Apagar \n "// Apagar F
                            + "\n ======== Funcionalidades de Cliente ===== \n"
                            + "4 - Registrar \n" //Adicionar Cliente
                            + "5 - Apagar \n"
                            + "6-  Realizar Pedido. \n"
                            + "\n  ======== Funcionalidades de APAGAR ===== \n"
                            + "7 - Apagar Produtos \n"
                            + "8 - Apagar Pedidos \n"
                            + "\n ======== Sair do Sistema ===== \n"
                            + "99 - Log-out (Sair do Sistema) \n "
                    );
                    int oqf = oqfazer.nextInt();
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

                    //
                    //   update atualizar
                    //
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
                    
                    
                    
                    if (oqf == 3) {
                        System.out.println("\n" +"Vamos apagar o Funcionario! \n");
                        System.out.println("Digite a Matricula do Funcionario que vai ser apagado:");
                        fc.setMatricula(sc.nextInt());
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.deleteFuncionario(fc);
                    }

                                        
                     //
                    //
                    //Cadastrar cliente
                    //
                    //
                    if (oqf == 4) {
                        System.out.println("Vamos Cadastrar o cliente! \n");
                        System.out.println("Informe um código para o cliente");
                        cl.setCodigoCliente(sc.nextInt());
                        //
                        System.out.println("Informe o nome do cliente");
                        cl.setNome(sc.next());
                        //
                        System.out.println("Informe o endereço do cliente");
                        cl.setEndereco(sc.next());
                        //
                        System.out.println("Informe o telefone do cliente");
                        cl.setTel(sc.next());

                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.CadastrarCliente(cl);
                    }
                    
                    
                    if (oqf == 5) {
                        System.out.println("Vamos apagar o cliente! \n");
                        System.out.println("Informe o codigo do cliente");
                        cl.setCodigoCliente(sc.nextInt());
                        //
                        //
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.ApagarCliente(cl);
                    }

                    //
                    //
                    //   Fazer pedido pedido
                    if (oqf == 6) {
                        
                            Math.random();
                            int pedido = (int) (Math.random() * 2000);

                            fc.setCodigoPedido(pedido); // Número do Pedido
                            
                            System.out.println("Digite o Codigo do cliente");
                            fc.setCodigoCliente(sc.nextInt()); // Código do Clinete
                            
                            fc.setCodigoFuncionario(matriculaAuthenticar); // Matricula do Funcionario logado.
                            
                            LocalDate lD = LocalDate.now(); // Data dinamica no B.D
                            
                            int ValorDoProdutoTotal = 0;
                            
                            System.out.println("\nREALIZAR PEDIDO: Os produtos disponiveis abaixo:");

                            System.out.println( //passar o if pelo número do pedido
                                "Escolha uma opcao abaixo: EX: 1001 ou 1002 ...\n"
                                + "(1001)   -   Pizza Muçarela              R$:5.00\n"
                                + "(1002)   -   Pizza Calabresa             R$:6.00\n"
                                + "(1003)   -   Pizza Presunto              R$:6.00\n"
                                + "(1004)   -   Refrigerante de cola        R$:8.00\n"
                                + "(1005)   -   Refrigerante de laranja     R$:7.00\n"
                                + "(1006)   -   Mini pudim                  R$:3.50\n"
                                + "(1007)   -   Brigadeiro                  R$:2.50\n "
                        );
                            
                            
                         int cp = cardapio.nextInt();   
                         
                            if (cp == 1001) {
                                
                                ValorDoProdutoTotal = 5;
                                  
                            }
                            
                            if (cp == 1002) {
                                
                                ValorDoProdutoTotal = 6;
                                  
                            }
                           
                                  fc.setValorTotal(ValorDoProdutoTotal);


                            daoControllerMetodos VrController = new daoControllerMetodos();
                            VrController.RealizarPedido(fc, lD);
                        }

                    //
                    //   Apagando Funcionario
                    //

                    if (oqf == 8) {
                        System.out.println("\n"+"Vamos apagar o Pedido! \n");
                        System.out.println("Digite o codigo do pedido que vai ser apagado:");
                        fc.setCodigoPedido(sc.nextInt());
                        daoControllerMetodos VrController = new daoControllerMetodos();
                        VrController.ApagarPedido(fc);
                    }

                    if (oqf == 99) {
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
