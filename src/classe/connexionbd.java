package classe;

import java.sql.*;

/**
 *
 * @author lankoande of Prince.COM
 */
public class connexionbd {

    private static Connection con = null;
    private static final String user = "root";
    private static final String pass = "";

    public static Connection seconnecter() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_courrier", user, pass);

        return con;
    }
}
