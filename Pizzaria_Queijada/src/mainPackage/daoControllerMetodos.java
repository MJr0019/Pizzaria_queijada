package mainPackage;

import funcionariosPackage.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;
import pedidoPackage.Pedido;

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
            System.out.println("\n"+"Novo funcionario Adcionado ao Sitema.");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("\n"+"Resgistrado com sucesso!" + "\n");

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

            System.out.println("\n"+"Dados do funcionario atualizados com sucesso!" + "\n");

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

            System.out.println("\n"+"Funcionario Apagado do Sistema!" + "\n");

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
    public void RealizarPedido(Pedido pedido) {
        String sql = "insert into pedido (codigo_pedido, codigo_cliente, codigo_funcionario, data_pedido, valor_total) values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //push nos campos de Funcionario
            stmt.setInt(1, pedido.getCodigoPedido());
            stmt.setInt(2, pedido.getCodigoCliente());
            stmt.setInt(3, pedido.getCodigoFuncionario());
            stmt.setDate(4, (Date) pedido.getDataPedido());
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

}
