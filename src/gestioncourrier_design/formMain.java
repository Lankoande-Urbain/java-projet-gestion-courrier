/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestioncourrier_design;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author lankoande
 */
public class formMain extends javax.swing.JFrame {

    /**
     * Creates new form formMain
     */
    public formMain() {

        initComponents();

        // Obtenir la taille de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Définir la taille de la fenêtre à la taille de l'écran
        this.setSize(screenSize.width, screenSize.height);

        mPam.removeAll();
        formAcceuil fAccueil = new formAcceuil(); // instanciation de la femetre de acceuil
        fAccueil.setSize(mPam.getWidth(), mPam.getHeight());
        fAccueil.setVisible(true);
        fAccueil.setLocation(0, 0);
        mPam.add(fAccueil);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnenvoie = new javax.swing.JLabel();
        btnreception = new javax.swing.JLabel();
        tnadmin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        mPam = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Hack", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/entrepot2.png"))); // NOI18N
        jLabel2.setText("Transport");
        jLabel2.setAutoscrolls(true);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIconTextGap(7);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        btnenvoie.setFont(new java.awt.Font("Hack", 1, 22)); // NOI18N
        btnenvoie.setForeground(new java.awt.Color(0, 0, 51));
        btnenvoie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnenvoie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/colis-bleu.png"))); // NOI18N
        btnenvoie.setText("Envoie colis");
        btnenvoie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnenvoie.setFocusTraversalPolicyProvider(true);
        btnenvoie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnenvoieMouseClicked(evt);
            }
        });

        btnreception.setFont(new java.awt.Font("Hack", 1, 22)); // NOI18N
        btnreception.setForeground(new java.awt.Color(0, 0, 51));
        btnreception.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnreception.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paquet-bleu.png"))); // NOI18N
        btnreception.setText("Reception de colis");
        btnreception.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreception.setFocusTraversalPolicyProvider(true);
        btnreception.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnreceptionMouseClicked(evt);
            }
        });

        tnadmin.setFont(new java.awt.Font("Hack", 1, 22)); // NOI18N
        tnadmin.setForeground(new java.awt.Color(0, 0, 51));
        tnadmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tnadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/setting-bleu.png"))); // NOI18N
        tnadmin.setText("Administration");
        tnadmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tnadmin.setFocusTraversalPolicyProvider(true);

        jLabel6.setFont(new java.awt.Font("Hack", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Envoie colis");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setFocusTraversalPolicyProvider(true);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 51));
        jSeparator1.setFont(new java.awt.Font("Cantarell", 2, 36)); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(0, 0, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 51));
        jSeparator2.setFont(new java.awt.Font("Cantarell", 2, 36)); // NOI18N

        jSeparator3.setBackground(new java.awt.Color(0, 0, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 51));
        jSeparator3.setFont(new java.awt.Font("Cantarell", 2, 36)); // NOI18N

        jSeparator4.setBackground(new java.awt.Color(0, 0, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 51));
        jSeparator4.setFont(new java.awt.Font("Cantarell", 2, 36)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tnadmin))
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnreception)
                        .addGap(6, 6, 6))
                    .addComponent(btnenvoie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnenvoie, btnreception, jLabel6, tnadmin});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSeparator1, jSeparator2, jSeparator3, jSeparator4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnenvoie, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnreception)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(tnadmin)
                .addGap(30, 30, 30)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnenvoie, btnreception, jLabel6, tnadmin});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jSeparator1, jSeparator2, jSeparator3, jSeparator4});

        mPam.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout mPamLayout = new javax.swing.GroupLayout(mPam);
        mPam.setLayout(mPamLayout);
        mPamLayout.setHorizontalGroup(
            mPamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1055, Short.MAX_VALUE)
        );
        mPamLayout.setVerticalGroup(
            mPamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setOpaque(true);

        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        jMenu2.setText("Accueil");
        jMenu2.setFont(new java.awt.Font("Hack", 1, 18)); // NOI18N

        jMenuItem1.setText("Quitter");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Aide");
        jMenu3.setFont(new java.awt.Font("Hack", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu3);

        jMenu1.setForeground(new java.awt.Color(0, 0, 51));
        jMenu1.setText("Apropos");
        jMenu1.setFont(new java.awt.Font("Hack", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mPam, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mPam, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        mPam.removeAll();
        formAcceuil fAccueil = new formAcceuil(); // instanciation de la femetre de acceuil
        fAccueil.setSize(mPam.getWidth(), mPam.getHeight());
        fAccueil.setVisible(true);
        fAccueil.setLocation(0, 0);
        mPam.add(fAccueil);

//        activation de bouton
        btnenvoie.setEnabled(true);
        btnreception.setEnabled(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnenvoieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnenvoieMouseClicked
        mPam.removeAll();// Supsresion du contenu de la page mPam
        mPam.repaint(); // Reactualisation de la page

        formEnvoie fGestion = new formEnvoie(); // instanciation de la femetre de gestion
        fGestion.setSize(mPam.getWidth(), mPam.getHeight());
        fGestion.setVisible(true);

        mPam.add(fGestion); // affectation de la page de gestion a mPam
        fGestion.moveToFront();
        btnenvoie.setEnabled(false);
        btnreception.setEnabled(true);

    }//GEN-LAST:event_btnenvoieMouseClicked

    private void btnreceptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreceptionMouseClicked
        mPam.removeAll();// Supsresion du contenu de la page mPam
        mPam.repaint(); // Reactualisation de la page

        formReception fenetre = new formReception(); // instanciation de la femetre de gestion
        fenetre.setSize(mPam.getWidth(), mPam.getHeight());
        fenetre.setVisible(true);

        mPam.add(fenetre); // affectation de la page de gestion a mPam
        fenetre.moveToFront();
        btnreception.setEnabled(false);
        btnenvoie.setEnabled(true);
    }//GEN-LAST:event_btnreceptionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnenvoie;
    private javax.swing.JLabel btnreception;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JDesktopPane mPam;
    private javax.swing.JLabel tnadmin;
    // End of variables declaration//GEN-END:variables
}