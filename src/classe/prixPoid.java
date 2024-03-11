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
public class prixPoid {

    public static Float getPrixPoid() throws SQLException, ClassNotFoundException { // Recuperation du prix/poids dans la BD

        Float rslt = null;

        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql = "SELECT prix_poid FROM prix_poids WHERE id= ?";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    int rowCount = res.getInt(1);
                    rslt = res.getFloat("prix_poid");
                }
            }
        }
        return rslt;
    }

    public static void updatePrixPoid(Float prix) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "UPDATE prix_poids SET prix_poid =? WHERE id=1 ";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setFloat(1, prix);
        insertStatement.executeUpdate();
    }

}
