/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author lankoande
 */
public class idGenerator {

    public static Long generateUniqueId() throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter();
        Random random = new Random();
        long randomNumber;

        do {
            // Générer un nombre aléatoire de 6 chiffres
            randomNumber = 100_000L + random.nextInt(900_000);

            // Vérifier s'il existe déjà dans la base de données
            if (!numberExistsInDatabase(con, randomNumber)) {
                // Enregistrer le nombre dans la base de données
                saveNumberToDatabase(con, randomNumber);
                break; // Sortir de la boucle si le nombre est unique
            }
        } while (true);

        return randomNumber;
    }

    private static boolean numberExistsInDatabase(Connection con, long number) {
        try {
            String query = "SELECT COUNT(*) FROM num_unique WHERE numero = ?";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
            statement.setLong(1, number);
            ResultSet resultSet = (ResultSet) statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    private static void saveNumberToDatabase(Connection con, long number) {
        try {
            String insertQuery = "INSERT INTO num_unique (num_uniq) VALUES (?)";
            PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
            insertStatement.setLong(1, number);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
