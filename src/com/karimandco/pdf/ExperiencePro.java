package com.karimandco.pdf;

import com.karimandco.bdd.DaoSIO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class ExperiencePro {
    private String entreprise;
    private String lieu;
    private String description;
    private String anneeDebut;
    private String anneeFin;

    //Constructeur
    
    public ExperiencePro(String nom, String lieu, String description, String anneeDebut, String anneeFin) {
        this.entreprise = nom;
        this.lieu = lieu;
        this.description = description;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
    }

    //Accesseur et mutateur

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String nom) {
        this.entreprise = nom;
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
     * Récupère toutes les expériences professionnelles d'un CV à partir de la base de donnée.
     * @param idDuCV
     * @return 
     */
    public static ArrayList<ExperiencePro> recupExperiencePro(String idDuCV){
        ArrayList<ExperiencePro> expPros = new ArrayList<ExperiencePro>();
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            if (!idDuCV.equals("")) {
                ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT entreprise, adresse, description, annee_debut, annee_fin FROM experience_pro WHERE id_cv = " + idDuCV);

                try{
                    while (res.next()) {
                        String[] dateSplit = res.getString("annee_debut").split("-");
                        String dateDebut = dateSplit[2] + "/" + dateSplit[1] + "/" + dateSplit[0];
                        dateSplit = res.getString("annee_fin").split("-");
                        String dateFin = dateSplit[2] + "/" + dateSplit[1] + "/" + dateSplit[0];
                        ExperiencePro exp = new ExperiencePro(res.getString("entreprise"), res.getString("adresse"), res.getString("description"), dateDebut, dateFin);
                        expPros.add(exp);
                    }
                }catch(SQLException e){
                    System.out.println("ERREUR recupExperiencePro("+idDuCV+") : "+e);
                }
                
            }
            
        }
        return expPros;
    }
}
