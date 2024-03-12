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
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lankoande
 */
public class courrier {

    //fonction pour l'envoie de colis
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

    public static void ModiferCourrier(String num_courrier, String type_courrier, String poid_courrier, String provenance, String destination, String prix_factuer, String date_depo, String num_expediteur, String num_destinateur) throws ClassNotFoundException, SQLException {

        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "UPDATE courriers set type_courrier = ?, poids_courrier = ?, provenance_courrier = ?, destination_courrier = ?, prix_facturer_courrier = ?, date_envoie_courrier = ?, num_expediteur_courrier = ?, num_destinateur_courrier = ? WHERE num_courrier = ?;";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, type_courrier);
        insertStatement.setString(2, poid_courrier);
        insertStatement.setString(3, provenance);
        insertStatement.setString(4, destination);
        insertStatement.setString(5, prix_factuer);
        insertStatement.setString(6, date_depo);
        insertStatement.setString(7, num_expediteur);
        insertStatement.setString(8, num_destinateur);
        insertStatement.setString(9, num_courrier);
        insertStatement.executeUpdate();
    }

    public static void supprimerCourrier(String num_colis) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "DELETE FROM courriers WHERE num_courrier = ? ";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_colis);
        insertStatement.executeUpdate();
    }

    public static void actualiserListEnvoie(DefaultTableModel tm) throws SQLException, ClassNotFoundException {

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
    public static String[] rechercheOneColis(String uniq_id) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql = "SELECT c.type_courrier, c.date_envoie_courrier, c.provenance_courrier, c.destination_courrier, c.status_courrier,c.poids_courrier, c.prix_facturer_courrier,e.num_client, e.nom_client, e.prenom_client, e.phone_client, e.type_piece_client, e.num_piece_client, "
                + " d.num_client, d.nom_client, d.prenom_client, d.phone_client from courriers c INNER JOIN clients e ON c.num_expediteur_courrier = e.num_client INNER JOIN clients d ON c.num_destinateur_courrier = d.num_client WHERE num_courrier = ?;";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setString(1, uniq_id);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    String[] rslt = {
                        res.getString("e.num_client"),
                        res.getString("e.nom_client"),
                        res.getString("e.prenom_client"),
                        res.getString("e.phone_client"),
                        res.getString("e.type_piece_client"),
                        res.getString("e.num_piece_client"),
                        res.getString("d.num_client"),
                        res.getString("d.nom_client"),
                        res.getString("d.prenom_client"),
                        res.getString("d.phone_client"),
                        res.getString("c.type_courrier"),
                        res.getString("c.poids_courrier"),
                        res.getString("c.provenance_courrier"),
                        res.getString("c.date_envoie_courrier"),
                        res.getString("c.prix_facturer_courrier"),
                        res.getString("c.destination_courrier")};
                    if ("RECUPERER".equals(res.getString("status_courrier"))) {
                        return null;
                    } else {
                        return rslt;
                    }
                }
            }
        }
        return null;

    }

    /*

    ******* function pour la reception de colis

     */
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

    @SuppressWarnings("empty-statement")
    public static String[] rechercheColisToupdate(String uniq_id) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql;
        sql = "SELECT c.type_courrier, c.date_envoie_courrier, c.provenance_courrier, c.destination_courrier, c.date_recuperer_courrier, status_courrier, concat( e.nom_client ,' ', e.prenom_client) AS Expediteur, "
                + "CONCAT( d.nom_client ,' ', d.prenom_client) AS Destinateur, r.num_client, r.nom_client, r.prenom_client, r.phone_client, r.type_piece_client, r.num_piece_client  "
                + "from courriers c INNER JOIN clients e ON c.num_expediteur_courrier = e.num_client INNER JOIN clients d ON c.num_destinateur_courrier = d.num_client INNER JOIN clients r ON c.num_recuperateur_courrier = r.num_client WHERE num_courrier = ?;";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setString(1, uniq_id);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    String[] rslt = {res.getString("c.type_courrier"),
                        res.getString("c.date_envoie_courrier"),
                        res.getString("c.provenance_courrier"),
                        res.getString("c.destination_courrier"),
                        res.getString("Expediteur"),
                        res.getString("Destinateur"),
                        res.getString("r.num_client"),
                        res.getString("r.nom_client"),
                        res.getString("r.prenom_client"),
                        res.getString("r.phone_client"),
                        res.getString("r.type_piece_client"),
                        res.getString("r.num_piece_client")};

                    return rslt;

                }
            }
        }

        return null;

    }

    public static void validRetraisColis(String num_courrier, String date_recuperer, String num_recuperateur) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "UPDATE courriers SET num_recuperateur_courrier = ?, date_recuperer_courrier = ?, status_courrier= ? WHERE num_courrier = ? ";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_recuperateur);
        insertStatement.setString(2, date_recuperer);
        insertStatement.setString(3, "NON RECUPERER");
        insertStatement.setString(4, num_courrier);

        insertStatement.executeUpdate();
    }

    public static void actualiserListRecuperer(DefaultTableModel tm) throws SQLException, ClassNotFoundException {

        try (Connection con = connexionbd.seconnecter()) {
            Statement stmt = con.createStatement();
            String sql;
            sql = "SELECT c.num_courrier, c.type_courrier, c.date_envoie_courrier, c.date_recuperer_courrier, c.provenance_courrier, c.destination_courrier, CONCAT( e.nom_client ,' ', e.prenom_client) AS Expediteur,"
                    + "CONCAT( d.nom_client ,' ', d.prenom_client) AS Destinateur, CONCAT(r.nom_client, ' ', r.prenom_client ) AS Recuperateur from courriers c INNER JOIN clients e ON c.num_expediteur_courrier = e.num_client INNER JOIN clients d ON c.num_destinateur_courrier = d.num_client  INNER JOIN clients r ON c.num_recuperateur_courrier = r.num_client WHERE status_courrier = 'RECUPERER';";
            ResultSet res = stmt.executeQuery(sql);
            int n = 0;

            while (res.next()) {
                n++;
                tm.addRow(new Object[]{res.getString("c.num_courrier"), res.getString("c.type_courrier"), res.getString("c.date_envoie_courrier"), res.getString("c.provenance_courrier"), res.getString("c.destination_courrier"),
                    res.getString("Expediteur"), res.getString("Destinateur"), res.getString("date_recuperer_courrier"), res.getString("Recuperateur")});

            }
            if (n == 0) {
                JOptionPane.showMessageDialog(null, "Aucune donnée trouvé");
            }

        }

    }

    public static void ModiferCourrierReception(String num_courrier) throws ClassNotFoundException, SQLException {

        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String note = "Not presence";
        String insertQuery = "UPDATE courriers SET num_recuperateur_courrier = ?, date_recuperer_courrier = ?, status_courrier= ?   WHERE num_courrier = ?;";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, note);
        insertStatement.setString(2, note);
        insertStatement.setString(3, "RECUPERER");
        insertStatement.setString(4, num_courrier);
        insertStatement.executeUpdate();
    }

}
