package classe;

import java.sql.*;

/**
 *
 * @author lankoande
 */
public class connexionbd {

    private static Connection con = null;
    private static final String user = "root";
    private static final String pass = "";

    public static Connection seconnecter() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_stock", user, pass);

        return con;
    }
}
