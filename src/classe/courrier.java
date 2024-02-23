/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lankoande
 */
public class courrier {

    public static void validerCourrier(String num_courrier, String type_courrier, String poid_courrier, String provenance, String destination, String prix_factuer, String date_depo, String num_expediteur, String num_destinateur) throws ClassNotFoundException, SQLException {

        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "INSERT INTO courriers (num_courrier, type_courrier, poids_courrier, provenance_courrier, destination_courrier, prix_facturer_courrier, date_envoie_courrier, num_expediteur_courrier, num_destinateur_courrier, status_courrier ) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_courrier);
        insertStatement.setString(2, type_courrier);
        insertStatement.setString(3, poid_courrier);
        insertStatement.setString(4, provenance);
        insertStatement.setString(5, destination);
        insertStatement.setString(6, prix_factuer);
        insertStatement.setString(7, date_depo);
        insertStatement.setString(8, num_expediteur);
        insertStatement.setString(9, num_destinateur);
        insertStatement.setString(10, "NON_RECUPERER");
        insertStatement.executeUpdate();
    }

    public static void modifierCourrier() {

    }

    public static void supprimerCourrier() {

    }

    public static void actualiser(DefaultTableModel tm) throws SQLException, ClassNotFoundException {

        try (Connection con = connexionbd.seconnecter()) {
            Statement stmt = con.createStatement();
            String sql = "SELECT c.num_courrier, c.type_courrier, c.date_envoie_courrier, c.poids_courrier, c.prix_facturer_courrier, provenance_courrier, destination_courrier, status_courrier, concat( e.nom_client ,' ', e.prenom_client) AS Expediteur, CONCAT( d.nom_client ,' ', d.prenom_client) AS Destinateur from courriers c INNER JOIN clients e ON c.num_expediteur_courrier = e.num_client INNER JOIN clients d ON c.num_destinateur_courrier = d.num_client;";
            ResultSet res = stmt.executeQuery(sql);
            int n = 0;

            while (res.next()) {
                n++;
                tm.addRow(new Object[]{res.getString("c.num_courrier"), res.getString("c.type_courrier"), res.getString("c.date_envoie_courrier"), res.getString("c.poids_courrier"), res.getString("c.prix_facturer_courrier"),
                    res.getString("provenance_courrier"), res.getString("destination_courrier"), res.getString("Expediteur"), res.getString("Destinateur"), res.getString("status_courrier")});

            }
            if (n == 0) {
                JOptionPane.showMessageDialog(null, "Aucune donnée trouvé");
            }

        }

    }

    @SuppressWarnings("empty-statement")
    public static String[] rechercheColis(String uniq_id) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql = "SELECT c.type_courrier, c.date_envoie_courrier, c.provenance_courrier, c.destination_courrier, status_courrier, concat( e.nom_client ,' ', e.prenom_client) AS Expediteur, "
                + "CONCAT( d.nom_client ,' ', d.prenom_client) AS Destinateur from courriers c INNER JOIN clients e ON c.num_expediteur_courrier = e.num_client INNER JOIN clients d ON c.num_destinateur_courrier = d.num_client WHERE num_courrier = ?;";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setString(1, uniq_id);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    String[] rslt = {res.getString("c.type_courrier"),
                        res.getString("c.date_envoie_courrier"),
                        res.getString("c.provenance_courrier"),
                        res.getString("c.destination_courrier"),
                        res.getString("Expediteur"),
                        res.getString("Destinateur")};
                    if ("RECUPERER".equals(res.getString("status_courrier"))) {
                        String[] vrslt = {"Vide"};
                        return vrslt;
                    } else {
                        return rslt;
                    }
                }
            }
        }
        String[] videMessage = {"colis", "Introuvable"};
        return videMessage;

    }

    public static void validRetraisColis(String num_courrier, String date_recuperer, String num_recuperateur) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "UPDATE courriers SET num_recuperateur_courrier =?, date_recuperer_courrier = ?, status_courrier= ? WHERE num_courrier = ? ";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_recuperateur);
        insertStatement.setString(2, date_recuperer);
        insertStatement.setString(3, "RECUPERER");
        insertStatement.setString(4, num_courrier);

        insertStatement.executeUpdate();
    }
}
