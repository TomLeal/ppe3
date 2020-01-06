package com.karimandco.pdf;

import com.karimandco.bdd.DaoSIO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class Formation {
    
    private String nom;
    private String lieu;
    private String description;
    private String anneeDebut;
    private String anneeFin;

    //Constructeur
    
    public Formation(String nom, String lieu, String description, String anneeDebut, String anneeFin) {
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
    }

    //Accesseur et mutateur

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(String anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public String getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(String anneeFin) {
        this.anneeFin = anneeFin;
    }

    /**
     * Récupère toutes les formations d'un CV à partir de la base de donnée.
     * @param idDuCV
     * @return 
     */
    public static ArrayList<Formation> recupFormation(String idDuCV){
        ArrayList<Formation> formations = new ArrayList<Formation>();
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            if (!idDuCV.equals("")) {
                ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT nom, lieu, description, annee_debut, annee_fin FROM formation WHERE id_cv = " + idDuCV);

                try{
                    while (res.next()) {
                        String[] dateSplit = res.getString("annee_debut").split("-");
                        String dateDebut = dateSplit[2] + "/" + dateSplit[1] + "/" + dateSplit[0];
                        dateSplit = res.getString("annee_fin").split("-");
                        String dateFin = dateSplit[2] + "/" + dateSplit[1] + "/" + dateSplit[0];
                        Formation uneFormation = new Formation(res.getString("nom"), res.getString("lieu"), res.getString("description"), dateDebut, dateFin);
                        formations.add(uneFormation);
                    }
                    for (Formation formation : formations) {
                        System.out.println(formation.getNom());
                    }
                }catch(SQLException e){
                    System.out.println("ERREUR recupInformation("+idDuCV+") : "+e);
                }
            }
        }
        return formations;
    }
}
