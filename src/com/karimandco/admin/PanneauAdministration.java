/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.admin;

import com.karimandco.auth.Utilisateur;
import com.karimandco.bdd.DaoSIO;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author t.normand
 */
public class PanneauAdministration extends javax.swing.JPanel {

    private final Helpers helpers;
    private Modification laFenetreModif = null;
    public com.karimandco.admin.Inscription cInscription;
    public com.karimandco.admin.Modification cModification;
    public com.karimandco.admin.Connexion cConnexionAdmin;

    /**
     * Creates new form PanneauAdministration
     */
    public PanneauAdministration() {
        initComponents();
        // Ligne pour relier la variable connexion à la fonction ConnexionBDD
        //DaoSIO.getInstance().connexionActive();
        //Appelle de la fonction pour update les informations du tableau
        //updateJTableInfo();
        helpers = new Helpers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSuppToutUtilisateurs = new javax.swing.JButton();
        jLabelEtatVider = new javax.swing.JLabel();
        jButtonRafraichir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInfo = new javax.swing.JTable();
        jButtonCreerUtilisateur = new javax.swing.JButton();
        jButtonModifierUtilisateur = new javax.swing.JButton();
        jButtonSuppUtilisateur = new javax.swing.JButton();

        jButtonSuppToutUtilisateurs.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSuppToutUtilisateurs.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButtonSuppToutUtilisateurs.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSuppToutUtilisateurs.setText("Supprimer tous les utilisateurs");
        jButtonSuppToutUtilisateurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppToutUtilisateursActionPerformed(evt);
            }
        });

        jLabelEtatVider.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonRafraichir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRafraichir.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButtonRafraichir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRafraichir.setText("Rafraichir");
        jButtonRafraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRafraichirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("< INTERFACE ESPACE ADMINISTRATION >");

        jTableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Prénom", "Naissance", "Téléphone", "Mot de passe", "Photo", "Statut"
            }
        ));
        jScrollPane1.setViewportView(jTableInfo);

        jButtonCreerUtilisateur.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCreerUtilisateur.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButtonCreerUtilisateur.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreerUtilisateur.setText("Créer un utilisateur ");
        jButtonCreerUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreerUtilisateurActionPerformed(evt);
            }
        });

        jButtonModifierUtilisateur.setBackground(new java.awt.Color(0, 0, 0));
        jButtonModifierUtilisateur.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButtonModifierUtilisateur.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModifierUtilisateur.setText("Modifier un utilisateur");
        jButtonModifierUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierUtilisateurActionPerformed(evt);
            }
        });

        jButtonSuppUtilisateur.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSuppUtilisateur.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButtonSuppUtilisateur.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSuppUtilisateur.setText("Supprimer un utilisateur");
        jButtonSuppUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppUtilisateurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRafraichir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreerUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModifierUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSuppUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSuppToutUtilisateurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEtatVider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(537, 537, 537))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCreerUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifierUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSuppUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSuppToutUtilisateurs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEtatVider, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSuppToutUtilisateursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppToutUtilisateursActionPerformed
        Integer result = JOptionPane.showConfirmDialog(this, "Êtes-vous sure de vouloir supprimer TOUS les utilisateurs ?");
        if (result == 0) {
            if (DaoSIO.getInstance().connexionActive()) {
                System.out.println(DaoSIO.getInstance().connexionActive());
                if (DaoSIO.getInstance().requeteAction("DELETE FROM utilisateurs WHERE statut = 0") == 1) {
                    jLabelEtatVider.setForeground(Color.blue);
                    jLabelEtatVider.setText("Les utilisateurs ont été supprimés sauf les administrateurs.");
                    updateJTableInfo();
                } else {
                    //Sinon, message d'erreur
                    jLabelEtatVider.setForeground(Color.blue);
                    jLabelEtatVider.setText("Les utilisateurs ont été supprimés sauf les administrateurs.");
                    updateJTableInfo();
                }
            }
        }
    }//GEN-LAST:event_jButtonSuppToutUtilisateursActionPerformed

    private void jButtonRafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRafraichirActionPerformed
        updateJTableInfo();
        //Elaboration du message de succès
        jLabelEtatVider.setForeground(Color.blue);
        jLabelEtatVider.setText("Les données ont été rafraichies");
    }//GEN-LAST:event_jButtonRafraichirActionPerformed

    private void jButtonCreerUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreerUtilisateurActionPerformed
        cInscription = new Inscription(this);
        cInscription.getPanneauFormInscription1().getjButton1().setText("Créer un utilisateur");
        cInscription.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cInscription.getPanneauFormInscription1().getjButton1().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cInscription.getPanneauFormInscription1().getInscriptionOK()) {
                    cInscription.setVisible(false);
                    updateJTableInfo();
                    jLabelEtatVider.setForeground(Color.blue);
                    jLabelEtatVider.setText("Inscription réussie");
                }
            }

            @Override

            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        cInscription.setLocationRelativeTo(this);
        cInscription.setModal(true);
        cInscription.setVisible(true);
    }//GEN-LAST:event_jButtonCreerUtilisateurActionPerformed

    private void jButtonModifierUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierUtilisateurActionPerformed
        //Création d'une variable integer pour la selection d'une ligne dans la table
        int idTable = jTableInfo.getSelectedRow();

        //Si aucune ligne n'est séléctionnées, ça fait un message d'erreur
        if (idTable < 0) {
            jLabelEtatVider.setForeground(Color.red);
            jLabelEtatVider.setText("Veuillez selectionner un utilisateur");
        } else {
            cModification = new Modification(this);
            cModification.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            TableModel test = jTableInfo.getModel();
            //Raliement des colonnes id, nom et prenom à une valeur pour l'identifier
            Object id = test.getValueAt(idTable, 0);
            int id_admin = (Integer.parseInt(String.valueOf(id)));

            cModification.getPanneauFormModification1().setLigne_selectionnee(id_admin);

            String[] resultat = requeteSelectAllUpdateAdmin("SELECT * FROM utilisateurs WHERE id = '" + id_admin + "'");
            //Si le nom de lignes du tableau de la BDD est supérieur à 0 alors application des données de la BDD à notre tableau
            cModification.getPanneauFormModification1().getPanneauNom().getChamp2().setText(resultat[4]);
            cModification.getPanneauFormModification1().getPanneauPrenom().getChamp2().setText(resultat[5]);
            cModification.getPanneauFormModification1().getPanneauIdentifiant().getChamp2().setText(resultat[2]);
            cModification.getPanneauFormModification1().getPanneauCourriel().getChamp2().setText(resultat[7]);
            cModification.getPanneauFormModification1().getPanneauNumeroTelephone().getChamp2().setText(resultat[6]);

            String[] date_split = resultat[8].split("-");
            String date_newFormat = date_split[2] + "/" + date_split[1] + "/" + date_split[0];

            cModification.getPanneauFormModification1().getPanneauDateNaissance().getChamp2().setText(date_newFormat);

            cModification.getPanneauFormModification1().updateJLabelEtat();
            cModification.setLocationRelativeTo(this);
            cModification.setModal(true);
            cModification.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifierUtilisateurActionPerformed

    private void jButtonSuppUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppUtilisateurActionPerformed

        //Création d'une variable integer pour la selection d'une ligne dans la table
        int idTable = jTableInfo.getSelectedRow();

        //Si aucune ligne n'est séléctionnées, ça fait un message d'erreur
        if (idTable < 0) {
            jLabelEtatVider.setForeground(Color.red);
            jLabelEtatVider.setText("Veuillez selectionner un utilisateur");
        } else {
            Integer result = JOptionPane.showConfirmDialog(this, "Êtes-vous sure de vouloir supprimer cet utilisateur ?");
            if (result == 0) {
                if (DaoSIO.getInstance().connexionActive()) {
                    System.out.println(DaoSIO.getInstance().connexionActive());
                    TableModel test = jTableInfo.getModel();
                    //Raliement des colonnes id, nom et prenom à une valeur pour l'identifier
                    Object id = test.getValueAt(idTable, 0);
                    Object nom = test.getValueAt(idTable, 4);
                    Object prenom = test.getValueAt(idTable, 5);
                    int id_admin = (Integer.parseInt(String.valueOf(id)));
                    if (DaoSIO.getInstance().requeteAction("DELETE FROM utilisateurs WHERE id='" + id_admin + "' AND statut = 0") == 1) {
                        jLabelEtatVider.setForeground(Color.blue);
                        jLabelEtatVider.setText("L'utilisateur "+nom+" "+prenom+" a été supprimé.");
                        updateJTableInfo();
                    } else {
                        //Sinon, message d'erreur
                        jLabelEtatVider.setForeground(Color.red);
                        jLabelEtatVider.setText("Erreur");
                        updateJTableInfo();
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonSuppUtilisateurActionPerformed

    public void updateJTableInfo() {
        //Création du tablea graphique
        String[] entetes = {"id", "statut", "identifiant", "mot_de_passe", "nom", "prenom", "num_telephone", "courriel", "date_de_naissance"};
        Object[][] data = {{"L1.1", "L1.2", "L1.1", "L1.2", "L1.1", "L1.2", "L1.1", "L1.2", "L1.2"}};
        //Création d'une variable stockant les colonnes et lignes
        DefaultTableModel modele = new DefaultTableModel(data, entetes);
        //Suppression des lignes
        modele.removeRow(0);
        //Connexion de la table à la BDD pour selectionner toutes les données
        String[][] resultat = requeteSelectAllAdmin("SELECT * FROM utilisateurs");
        //Si le nom de lignes du tableau de la BDD est supérieur à 0 alors application des données de la BDD à notre tableau
        if (resultat.length > 0) {
            for (String[] ligne : resultat) {
                String[] date_split = ligne[9].split("-");
                ligne[9] = date_split[2] + "/" + date_split[1] + "/" + date_split[0];

                modele.addRow(new Object[]{ligne[1], ligne[2], ligne[3], ligne[4], ligne[5], ligne[6], ligne[7], ligne[8], ligne[9]});
            }
        }
        //Envoie des données à notre tableau
        jTableInfo.setModel(modele);
    }

    public JLabel getjLabelEtatVider() {
        return jLabelEtatVider;
    }

    public void setjLabelEtatVider(JLabel jLabelEtatVider) {
        this.jLabelEtatVider = jLabelEtatVider;
    }

    public String[][] requeteSelectAllAdmin(String sql) {
        String[][] resultat = null;

        try {
            int nbr_ligne = 0;
            ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT COUNT(*) FROM utilisateurs");
            while (res.next()) {
                nbr_ligne = res.getInt(1);
            }

            ResultSet lesTuples = DaoSIO.getInstance().requeteSelection(sql);
            int nbr_colonne = lesTuples.getMetaData().getColumnCount() + 1;
            int compteur_ligne = 0;

            resultat = new String[nbr_ligne][nbr_colonne];

            while (lesTuples.next()) {
                for (int i = 1; i < nbr_colonne; i++) {
                    String col_name = lesTuples.getMetaData().getColumnName(i);

                    resultat[compteur_ligne][i] = lesTuples.getString(col_name);
                }
                compteur_ligne++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
    }

    public String[] requeteSelectAllUpdateAdmin(String sql) {
        String[] resultat = new String[10];

        try {
            ResultSet lesTuples_bis = DaoSIO.getInstance().requeteSelection(sql);

            // on attend au max 1 Tuple !!!!!
            if (lesTuples_bis.next()) {
                ResultSet lesTuples = DaoSIO.getInstance().requeteSelection("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'utilisateurs'");

                Integer i = 0;

                while (lesTuples.next()) {
                    resultat[i] = lesTuples_bis.getString(lesTuples.getString("COLUMN_NAME"));
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreerUtilisateur;
    private javax.swing.JButton jButtonModifierUtilisateur;
    private javax.swing.JButton jButtonRafraichir;
    private javax.swing.JButton jButtonSuppToutUtilisateurs;
    private javax.swing.JButton jButtonSuppUtilisateur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEtatVider;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInfo;
    // End of variables declaration//GEN-END:variables
}
