package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDao {

    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "5500";
        String db_name = "postgres";
        String username = "postgres";
        String password = "12345";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
            System.out.println("Estou conectado no banco de dados!!!");
            con.close();
            System.out.println("Conexão encerrada!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
