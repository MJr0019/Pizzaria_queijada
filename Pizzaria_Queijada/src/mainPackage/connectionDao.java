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
        String port = "5432";
        String db_name = "pizzaria";
        String username = "postgres";
        String password = "123123";

        Scanner sc = new Scanner(System.in);
        Scanner oqfazer = new Scanner(System.in);
        Scanner cardapio = new Scanner(System.in);
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
            int matriculaAuthenticar = sc.nextInt();

            String SQL_matricula = "SELECT * FROM funcionario WHERE matricula='" + matriculaAuthenticar + "'";
            ResultSet matriculaAuthenticator = stmt.executeQuery(SQL_matricula);

            if (matriculaAuthenticator.next()) {
                System.out.println("MATRICULA VALIDA");

                System.out.println("SENHA PARA AUTENTICAR"); //verificando se a senha esta correta
                String SenhaAuthenticar = sc.next();
    
                String SQL_Senha = "SELECT * FROM funcionario WHERE matricula='" + matriculaAuthenticar + 
                        "' AND senha='" + SenhaAuthenticar + "'";
                ResultSet SenhaAuthenticator = stmt.executeQuery(SQL_Senha);

                    if (SenhaAuthenticator.next()) {
                        System.out.println("SENHA VALIDA");
                        System.out.println("\n"+"Ben-vindo ao Sistema"+"\n");
                        System.out.println(
                                "Escolha uma opção abaixo:\n"
                                + " ======== Funcionalidades de Funcionários ===== \n"
                                + "1 - Registrar \n" //Adicionar F
                                + "2 - Atualizar \n" //Editar F
                                + "3-  Realizar Pedido \n\n"
                                + " ======== Funcionalidades de APAGAR ===== \n"
                                + "4 - Apagar Clientes \n"
                                + "5 - Apagar Produtos \n"
                                + "6 - Apagar Pedidos \n"
                                + "7 - Apagar Funcionários \n "// Apagar F
                                + "\n ======== Sair do Sistema ===== \n"
                                + "99 - Log-out (Sair do Sistema) \n "
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
                                    "Escolha uma opção abaixo: EX: 1001 ou 1002 ...\n"
                                    + "(1001)   -   Pizza Muçarela: R$:5.00\n"
                                    + "(1002)   -   Pizza Calabresa R$:6.00\n"
                                    + "(1003)   -   Pizza Presunto R$:6.00\n"
                                    + "(1004)   -   Refrigerante de cola R$:8.00\n"
                                    + "(1005)   -   Refrigerante de laranja R$:7.00\n"
                                    + "(1006)   -   Mini pudim R$:3.50\n"
                                    + "(1007)   -   Brigadeiro R$:2.50\n "
                            );

                            int cp = cardapio.nextInt();
                            if (cp == 1001) {
                                System.out.println("Confirme o código do pedido"); //codigo do pedido
                                fc.setCodigoPedido(sc.nextInt());

                                //gerar um código aleatorio para o cliente
        //                    System.out.println("Digite o Codigo do cliente");
        //                    fc.setNome(sc.next());
                                System.out.println("Digite o seu código de funcionario");
                                fc.setCodigoFuncionario(sc.nextInt());
        //
        //
                                //precisa declarar a data
        //                        System.out.println("Digite a data do pedido");
        //                        fc.setDataPedido(sc.next());
        //
        //
                                System.out.println("Valor total");
                                fc.setValorTotal(sc.nextInt());

                                daoControllerMetodos VrController = new daoControllerMetodos();
                                VrController.RealizarPedido(fc);
                            }
                            if (cp == 1002) {
                                System.out.println("Confirme o código do pedido");
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
                            if (cp == 1003) {
                                System.out.println("Confirme o código do pedido");
                                fc.setMatricula(sc.nextInt());
        //                    System.out.println("Digite o Codigo do cliente");
        //                    fc.setNome(sc.next());
                                System.out.println("Digite o seu código de funcionario");
                                fc.setEndereco(sc.next());

                                System.out.println("Valor total");
                                fc.setEndereco(sc.next());

                                System.out.println("Digite a data do pedido");
                                fc.setSenha(sc.next());
                            }
                            if (cp == 1004) {
                                System.out.println("Confirme o código do pedido");
                                fc.setMatricula(sc.nextInt());
        //                    System.out.println("Digite o Codigo do cliente");
        //                    fc.setNome(sc.next());
                                System.out.println("Digite o seu código de funcionario");
                                fc.setEndereco(sc.next());

                                System.out.println("Valor total");
                                fc.setEndereco(sc.next());

                                System.out.println("Digite a data do pedido");
                                fc.setSenha(sc.next());
                            }
                            if (cp == 1005) {
                                System.out.println("Confirme o código do pedido");
                                fc.setMatricula(sc.nextInt());
        //                    System.out.println("Digite o Codigo do cliente");
        //                    fc.setNome(sc.next());
                                System.out.println("Digite o seu código de funcionario");
                                fc.setEndereco(sc.next());

                                System.out.println("Valor total");
                                fc.setEndereco(sc.next());

                                System.out.println("Digite a data do pedido");
                                fc.setSenha(sc.next());
                            }
                            if (cp == 1006) {
                                System.out.println("Confirme o código do pedido");
                                fc.setMatricula(sc.nextInt());
        //                    System.out.println("Digite o Codigo do cliente");
        //                    fc.setNome(sc.next());
                                System.out.println("Digite o seu código de funcionario");
                                fc.setEndereco(sc.next());

                                System.out.println("Valor total");
                                fc.setEndereco(sc.next());

                                System.out.println("Digite a data do pedido");
                                fc.setSenha(sc.next());
                            }
                            if (cp == 1007) {
                                System.out.println("Confirme o código do pedido");
                                fc.setMatricula(sc.nextInt());
        //                    System.out.println("Digite o Codigo do cliente");
        //                    fc.setNome(sc.next());
                                System.out.println("Digite o seu código de funcionario");
                                fc.setEndereco(sc.next());

                                System.out.println("Valor total");
                                fc.setEndereco(sc.next());

                                System.out.println("Digite a data do pedido");
                                fc.setSenha(sc.next());
                            }
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
                        
                        if (oqf == 99) {
                            con.close();
                            System.out.println("\nLogoff Realizado! \n");
                        }

                    } else {
                        System.out.println("SENHA INVALIDA");
                    }
                }else{
                    System.out.println("MATRICULA INVALIDA");
                }
            con.close();
            System.out.println("Conexão encerrada!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
