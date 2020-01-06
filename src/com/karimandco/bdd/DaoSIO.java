/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.bdd;

/**
 *
 * @author c.nadal
 */
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données contenant des membres statiques afin de manipuler
 * la BDD ON implémente ici le Design Pattern Singleton
 *
 * @author nc
 */
public class DaoSIO {

    /**
     * Vous devez saisir vos informations ici.
     *
     */
    private static String nomServeur = "";
    private static String port = "";
    private static String nomBdd = "";
    private static String nomUtilisateur = "";
    private static String motDePasse = "";

    private static String chaineConnexion;

    //propriété non statique
    private Connection connexion;

    private static DaoSIO monDao = null;

    /**
     * Constructeur privé ! pour construire un objet, il faut utiliser la
     * méthode publique statique getDaoSIO
     */
    private DaoSIO() {
        try {
            //Définition de l'emplacement de la BDD
            DaoSIO.chaineConnexion = "jdbc:mysql://" + DaoSIO.nomServeur + "/" + DaoSIO.nomBdd;

            //Création de la connexion à la BDD
            this.connexion = (Connection) DriverManager.getConnection(DaoSIO.chaineConnexion, DaoSIO.nomUtilisateur, DaoSIO.motDePasse);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Permet d'obtenir l'objet instancié
     *
     * @return un Objet DaoSIO avec connexion active ... pour une certaine durée
     */
    public static DaoSIO getInstance() {
        if (DaoSIO.monDao == null) {
            DaoSIO.monDao = new DaoSIO();
        } else {
            if (!DaoSIO.monDao.connexionActive()) {
                DaoSIO.monDao = new DaoSIO();
            }
        }
        return DaoSIO.monDao;
    }

    /**
     * Cette méthode vérifie si il y a déjà une connexion active
     *
     * @return Boolean true or false
     */
    public Boolean connexionActive() {
        Boolean connexionActive = true;

        try {
            if (this.connexion.isClosed()) {
                connexionActive = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connexionActive;
    }

    /**
     * Cette méthode permet d'exécuter une requête SQL de type SELECT
     *
     * @param sql, comportera un ordre selec
     * @return ResultSet résultat de la requête SQL
     */
    public ResultSet requeteSelection(String sql) {
        System.out.println(sql);
        try {

            Statement requete = new DaoSIO().connexion.createStatement();
            return requete.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Cette méthode permet d'exécuter une requête SQL de type INSERT, UPDATE,
     * DELETE, ...
     *
     * @param sql, comportera un ordre insert, update, select, alter, etc.
     * @return Integer le nombre de lignes impactées par la requête action
     */
    public Integer requeteAction(String sql) {
        System.out.println(sql);
        try {
            Statement requete = new DaoSIO().connexion.createStatement();
            return requete.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Integer updateImage(InputStream stream, File fichier, Integer id) {
        Integer update = 0;
        try {
            // Pour l'adapter à votre code, remplacer "identifiant" par "id" et récupérez l'id de l'utilisateur que vous souhaitez altétrer.
            PreparedStatement maRequete = this.connexion.prepareStatement("update utilisateurs set photo=? where id="+id);
            maRequete.setBinaryStream(1, (InputStream) stream, fichier.length());

            update = maRequete.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return update;
    }

    public Integer getLastID(String table, String... args) throws SQLException {

        ResultSet result = this.requeteSelection("SELECT " + (!args.equals("") ? String.join(",", args) : "*")
                + " FROM " + table + " ORDER BY id DESC LIMIT 0, 1");

        if (result.next()) {
            return Integer.parseInt(result.getString("id"));
        }

        return null;
    }
}
