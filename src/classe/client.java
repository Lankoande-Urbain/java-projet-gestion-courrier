/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lankoande
 */
public class client {

    public static void validerClient(String num_client, String nom_client, String prenom_client, String phone_client, String type_piece, String num_piece) throws ClassNotFoundException, SQLException {

        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "INSERT INTO clients (num_client, nom_client, prenom_client, phone_client, type_piece_client, num_piece_client) VALUES (?,?,?,?,?,?)";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_client);
        insertStatement.setString(2, nom_client);
        insertStatement.setString(3, prenom_client);
        insertStatement.setString(4, phone_client);
        insertStatement.setString(5, type_piece);
        insertStatement.setString(6, num_piece);
        insertStatement.executeUpdate();
    }

    public static void modiferClient() {

    }

    public static void supprimerClient() {

    }

}
