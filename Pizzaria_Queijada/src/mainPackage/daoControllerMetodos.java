package mainPackage;

import funcionariosPackege.funcionario;
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

    public void gravar(funcionario funcionario) {
        String sql = "insert into funcionario (matricula, nome, endereco, senha) values (?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //push nos campos de funcionario
            stmt.setInt(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setInt(4, funcionario.getSenha());
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
    public void update(funcionario funcionario) {
        String sql = "update funcionario set matricula = ? , nome = ?, endereco = ?, senha = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setInt(4, funcionario.getSenha());
            System.out.println("Usuario Atualizados no banco");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    //
    //
    /* todos os metodos devem ficar por dentro desse para fazer a auth,
    apenas pessoas cadastradas podem fazer alteração
     */
    public void authFuncionario(funcionario funcionario) {
        String sql = "select * from funcionario where matricula = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, funcionario.getMatricula());
            System.out.println("Usuario autenticado no banco");

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //////////////
    //
    //
    public void deleteFuncionario(funcionario funcionario) {
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
