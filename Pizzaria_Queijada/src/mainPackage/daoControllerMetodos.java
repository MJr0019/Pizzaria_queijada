package mainPackage;

import clientePackage.Cliente;
import funcionariosPackage.Funcionario;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;
import pedidoPackage.Pedido;
import produtoPackage.Produto;

public class daoControllerMetodos {

    private Connection con;

    public daoControllerMetodos() {
        this.con = new connectionFactory().getConnection();
    }

    public void gravar(Funcionario funcionario) {
        String sql = "insert into funcionario (matricula, nome, endereco, senha) values (?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //push nos campos de Funcionario
            stmt.setInt(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getSenha());
            System.out.println("\n" + "Novo funcionario Adcionado ao Sitema.");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("\n" + "Resgistrado com sucesso!" + "\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // new method editar
    public void update(Funcionario Funcionario) {
        String sql = "update funcionario set nome = ?, endereco = ?, senha = ? where matricula = ? ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, Funcionario.getNome());
            stmt.setString(2, Funcionario.getEndereco());
            stmt.setString(3, Funcionario.getSenha());
            stmt.setInt(4, Funcionario.getMatricula());

            System.out.println("\n" + "Dados do funcionario atualizados com sucesso!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFuncionario(Funcionario funcionario) {
        String sql = "delete from funcionario where matricula = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, funcionario.getMatricula());

            System.out.println("\n" + "Funcionario Apagado do Sistema!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    //
    // Declarando pedido
    //
    //
    public void RealizarPedido(Pedido pedido, LocalDate lD) {
        String sql = "insert into pedido (codigo_pedido, codigo_cliente, codigo_funcionario, data_pedido, valor_total) values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //LocalDate localDate = LocalDate.now();
            LocalDate localDate = lD;

//push nos campos de Funcionario
            stmt.setInt(1, pedido.getCodigoPedido());
            stmt.setInt(2, pedido.getCodigoCliente());
            stmt.setInt(3, pedido.getCodigoFuncionario());
            stmt.setObject(4, localDate); //pegando a data
            stmt.setInt(5, pedido.getValorTotal());

            System.out.println("Pedido REALIZADO COM SUCESSO");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Gravado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    //
    //deletar pedido
    //
    //
    public void ApagarPedido(Pedido pedido) {
        String sql = "delete from pedido where codigo_pedido = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedido.getCodigoPedido());

            System.out.println("\n" + "Pedido Apagado do Sistema!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    //
    //Cadastrando cliente
    //
    //
    public void CadastrarCliente(Cliente cliente) {
        String sql = "insert into cliente (codigo_cliente, nome, endereco, tel) values (?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

//push nos campos de Funcionario
            stmt.setInt(1, cliente.getCodigoCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTel());

            System.out.println("\nCliente cadastrado com sucesso\n");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Gravado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //apagar cliente
    //
    //
    public void ApagarCliente(Cliente cliente) {
        String sql = "delete from cliente where codigo_cliente =?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

//push nos campos de Funcionario
            stmt.setInt(1, cliente.getCodigoCliente());

            System.out.println("\nCliente pagado com sucesso\n");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Apagado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //
    //
    //Atualizar cliente
    //
    //

    public void AtualizarCliente(Cliente cliente) {
        String sql = "update funcionario set nome = ?, endereco = ?, senha = ? where matricula = ? ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, cliente.getCodigoCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTel());

            System.out.println("\n" + "Dados do cliente atualizados com sucesso!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    //
    //Cadastrar produto
    //
    //
    public void CadastrarProduto(Produto produto) {
        String sql = "insert into produto (codigo_produto, nome, preco_unitario) values (?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

//push nos campos de Funcionario
            stmt.setInt(1, produto.getCodigoProduto());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPrecoUnitario());

            System.out.println("\nProduto cadastrado com sucesso\n");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Gravado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AtualizarProduto(Produto produto) {
        String sql = "update funcionario set nome = ?, preco_unitario = ? where codigo_produto = ? ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, produto.getCodigoProduto());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPrecoUnitario());

            System.out.println("\n" + "Dados do produto atualizados com sucesso!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarProduto(Produto produto) {
        String sql = "delete from produto where codigo_produto =?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, produto.getCodigoProduto());

            System.out.println("\n" + "Produto apagado com sucesso!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    // pedido
    //
    public void CadastrarPedido(Pedido pedido) {
        String sql = "insert into produto (codigo_pedido, codigo_cliente, codigo_funcionario, data_pedido, valor_total) values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

//push nos campos de Funcionario
            stmt.setInt(1, pedido.getCodigoPedido());
            stmt.setInt(2, pedido.getCodigoCliente());
            stmt.setDouble(3, pedido.getCodigoFuncionario());
//            stmt.setDouble(4, pedido.getDataPedido());
            stmt.setDouble(5, pedido.getValorTotal());

            System.out.println("\nProduto cadastrado com sucesso\n");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Gravado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AtualizarPedido(Pedido pedido) {
        String sql = "update pedido set codigo_cliente = ?, codigo_funcionario = ?, codigo_funcionario = ?, data_pedido = ?, valor_total= ?, where codigo_pedido = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedido.getCodigoPedido());
            stmt.setInt(2, pedido.getCodigoCliente());
            stmt.setDouble(3, pedido.getCodigoFuncionario());
//            stmt.setDouble(4, pedido.getDataPedido());
            stmt.setDouble(5, pedido.getValorTotal());

            System.out.println("\n" + "Dados do pedido atualizados com sucesso!" + "\n");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
