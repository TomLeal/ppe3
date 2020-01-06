package com.karimandco.pdf;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karim
 */
public class ConnexionDB {
    
    // Default uri connection : jdbc:mysql://<host_name.tld>:port/<database_name>, <user_name>, password
    
    private String connexionURI = "jdbc:mysql://";
    private Connection connexion;
    
    private String hostname = "www.cnadal.fr";
    private Integer port = 3306;
    private String database = "sio2_cv";
    private String username = "sio2_cv";
    private String password = "formation2020";
    
    public ConnexionDB() {
        initConnexion();
    }
    
    public void initConnexion(){
        if(this.connexionURI.equals("jdbc:mysql://")){
            this.connexionURI += hostname + ":" + port + "/" + database;
        }
        try {
            System.out.println(this.connexionURI + " - " + username + " - " + password);
            this.connexion = (Connection)DriverManager.getConnection(this.connexionURI, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnnexion(){
        if(this.connexion != null){
            return this.connexion;
        }
        return null;
    }
    
    public void getAllDataTable(String table){
        if(this.connexion != null){
            Statement req;
            ResultSet res;
            try {
                req = this.connexion.createStatement();
                res = req.executeQuery("SELECT * FROM " + table);
            } catch (SQLException ex) {
                Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Connection reconnect(){
        if(this.connexion != null){
            try {
                ResultSet res = this.connexion.createStatement().executeQuery("SELECT * FROM utilisateurs");

            } catch (SQLException ex) {
                this.connexion = null;
                this.initConnexion();
            }
            
            return this.connexion = this.getConnnexion();
        }
        return null;
    }
}
