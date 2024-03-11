/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 *
 *this is LANKOANDE Urbain code
 * Prince.COM << lankoandeurbain8@gmail.com >>
 *
 */
package classe;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lankoande
 */
public class validConnexion {

    public static Boolean verifConnexion(String user_name, String user_pass) throws SQLException, ClassNotFoundException {

        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql = "SELECT COUNT(*) FROM users WHERE user_name = ? COLLATE utf8mb4_bin AND user_pass = ? COLLATE utf8mb4_bin";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, user_pass);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    int rowCount = res.getInt(1);
                    return rowCount > 0; // Si rowCount > 0, l'utilisateur existe
                }
            }
        }

        return false; // Si aucun résultat trouvé, l'utilisateur n'existe pas
    }

}
