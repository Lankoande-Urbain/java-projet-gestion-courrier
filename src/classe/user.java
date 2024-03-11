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
public class user {

    /**
     *
     * Fonction d'enregistrement des donner d'un utilisateur dans la base de
     * donnees
     *
     * @param num_user
     * @param nom
     * @param prenom
     * @param phone
     * @param type_piece
     * @param num_piece
     * @param user_name
     * @param user_pass
     * @param role
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void validerUser(String num_user, String nom, String prenom, String phone, String type_piece, String num_piece, String user_name, String user_pass, String role) throws ClassNotFoundException, SQLException {

        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "INSERT INTO users (num_user, nom, prenom, phone, type_piece, num_piece, user_name, user_pass, role ) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_user);
        insertStatement.setString(2, nom);
        insertStatement.setString(3, prenom);
        insertStatement.setString(4, phone);
        insertStatement.setString(5, type_piece);
        insertStatement.setString(6, num_piece);
        insertStatement.setString(7, user_name);
        insertStatement.setString(8, user_pass);
        insertStatement.setString(9, role);
        insertStatement.executeUpdate();
    }

    /**
     * Fonction qui recupere toutes les lignes de la base et l'affect a un
     * tableau
     *
     * @param tm
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void getListUser(DefaultTableModel tm) throws SQLException, ClassNotFoundException {

        try (Connection con = connexionbd.seconnecter()) {
            Statement stmt = con.createStatement();
            String sql = "SELECT num_user, nom, prenom, phone, type_piece, num_piece, user_name, user_pass, role from users;";
            ResultSet res = stmt.executeQuery(sql);
            int n = 0;

            while (res.next()) {
                n++;
                tm.addRow(new Object[]{res.getString("num_user"), res.getString("nom"), res.getString("prenom"), res.getString("phone"), res.getString("num_piece"),
                    res.getString("user_name"), res.getString("role")});

            }
            if (n == 0) {
                JOptionPane.showMessageDialog(null, "Aucune donnée trouvé");
            }

        }

    }

    public static String[] getOneUser(String numUser) throws SQLException, ClassNotFoundException {
        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql = "SELECT * FROM users WHERE num_user = ?;";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setString(1, numUser);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    String[] rslt = {res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("type_piece"),
                        res.getString("num_piece"),
                        res.getString("phone"),
                        res.getString("role"),
                        res.getString("user_name"),
                        res.getString("user_pass"),};

                    return rslt;
                }
            }
        }
        return null;
    }

    public static boolean rechercheUser(String uniq_id) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter();
        // Utilisez des requêtes paramétrées pour éviter les injections SQL
        String sql = "SELECT * FROM users WHERE num_user = ?;";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql)) {
            preparedStatement.setString(1, uniq_id);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void DeleteUsers(String num_user) throws ClassNotFoundException, SQLException {
        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "DELETE FROM users WHERE num_user = ? ";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);
        insertStatement.setString(1, num_user);
        insertStatement.executeUpdate();
    }

    public static void UpdateUser(String num_user, String nom, String prenom, String phone, String type_piece, String num_piece, String user_name, String user_pass, String role) throws ClassNotFoundException, SQLException {

        Connection con = connexionbd.seconnecter(); // Creation d'une connexion
        String insertQuery = "UPDATE users SET nom = ?, prenom = ?, phone = ?, type_piece = ?, num_piece = ?, user_name = ?, user_pass = ?, role = ? WHERE num_user = ?;";
        PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertQuery);

        insertStatement.setString(1, nom);
        insertStatement.setString(2, prenom);
        insertStatement.setString(3, phone);
        insertStatement.setString(4, type_piece);
        insertStatement.setString(5, num_piece);
        insertStatement.setString(6, user_name);
        insertStatement.setString(7, user_pass);
        insertStatement.setString(8, role);
        insertStatement.setString(9, num_user);
        insertStatement.executeUpdate();
    }
}
