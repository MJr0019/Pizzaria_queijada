package funcionariosPackege;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import mainPackage.connectionFactory;
//import java.util.ArrayList;

public class authenticationUsers {

    private Connection con;

    public authenticationUsers() {
        this.con = new connectionFactory().getConnection();
    }

    public void authFuncionario(funcionario funcionario) {
        String sql = "SELECT matricula";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getMatricula());

            stmt.execute();
            stmt.close();
            con.close();

            System.out.println("Usuario autenticado no banco");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    authenticationUsers(funcionario fc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
