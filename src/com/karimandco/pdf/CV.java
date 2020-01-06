package com.karimandco.pdf;

import com.karimandco.bdd.DaoSIO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class CV {
    
    private String titre;
    private String signature;
    private String description;
    private String nomMaitrise1;
    private String nomMaitrise2;
    private int maitrise1;
    private int maitrise2;

    public CV(String description, String nomMaitrise1, String nomMaitrise2, int maitrise1, int maitrise2) {
        this.description = description;
        this.nomMaitrise1 = nomMaitrise1;
        this.nomMaitrise2 = nomMaitrise2;
        this.maitrise1 = maitrise1;
        this.maitrise2 = maitrise2;
    }

    //Accesseur et mutateur
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomMaitrise1() {
        return nomMaitrise1;
    }

    public void setNomMaitrise1(String nomMaitrise1) {
        this.nomMaitrise1 = nomMaitrise1;
    }

    public String getNomMaitrise2() {
        return nomMaitrise2;
    }

    public void setNomMaitrise2(String nomMaitrise2) {
        this.nomMaitrise2 = nomMaitrise2;
    }

    public int getMaitrise1() {
        return maitrise1;
    }

    public void setMaitrise1(int maitrise1) {
        this.maitrise1 = maitrise1;
    }

    public int getMaitrise2() {
        return maitrise2;
    }

    public void setMaitrise2(int maitrise2) {
        this.maitrise2 = maitrise2;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    
    public static String calculNiveauMaitrise(Integer maitrise){
        String result = "";
        Integer niveau = maitrise/20;
        for (int i = 0; i < niveau; i++) {
            char c = 'O';
            result = result + c;
        }
        System.out.println(result);
        return result;
    }
    
    /**
     * Récupère le CV d'un utilisateur à partir de la base de donnée.
     * @param idDuCV
     * @return 
     */
    public static CV recupCV(String idDuCV){
        CV cv = new CV("", "", "", 0, 0);
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            if (!idDuCV.equals("")) {
                ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT description, nom_maitrise, maitrise, nom_maitrise2, maitrise2 FROM cv WHERE id = " + idDuCV);

                try{
                    if (res.next()) {
                        cv = new CV(res.getString("description"), res.getString("nom_maitrise"), res.getString("nom_maitrise2"), res.getInt("maitrise"), res.getInt("maitrise2"));
                    }
                }catch(SQLException e){
                    System.out.println("ERREUR recupInformation("+idDuCV+") : "+e);
                }
            }
        }
        return cv;
    }
    
    public CV recupLeCV(String idDuCV){
        CV cv = new CV("", "", "", 0, 0);
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            if (!idDuCV.equals("")) {
                ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv WHERE id = " + idDuCV);

                try{
                    if (res.next()) {
                        cv = new CV(res.getString("description"), res.getString("nom_maitrise"), res.getString("nom_maitrise2"), res.getInt("maitrise"), res.getInt("maitrise2"));
                        cv.setTitre(res.getString("titre"));
                        cv.setSignature(res.getString("signature"));
                    }
                }catch(SQLException e){
                    System.out.println("ERREUR recupInformation("+idDuCV+") : "+e);
                }
            }
        }
        return cv;
    }
}
