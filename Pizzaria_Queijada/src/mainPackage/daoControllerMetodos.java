package mainPackage;

import funcionariosPackage.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;

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
            System.out.println("Usuario ADICIONADOS no banco");

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Gravado com sucesso");

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

            System.out.println("Usuario Atualizados no banco");

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

            System.out.println("Usuario Apagado do banco");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
