package com.karimandco.xml;

import com.karimandco.auth.Utilisateur;
import com.karimandco.bdd.DaoSIO;
import com.karimandco.pdf.CV;
import com.karimandco.pdf.ExperiencePro;
import com.karimandco.pdf.Formation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.nadal
 */
public class ImportExportCSV extends Export {

    private String nomUtilisateur;
    private Utilisateur util;

    public ImportExportCSV(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setUtil(Utilisateur util) {
        this.util = util;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }
    
    

    @Override
    public void exportFichier() {
        FileWriter objFile = null;
        try {
            //ouverture du fichier en écriture
            objFile = new FileWriter(this.nomFichier);
            objFile.write("<?xml version = \"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>");
            objFile.write("<dernierident>");
            objFile.write(nomUtilisateur);
            objFile.write("</dernierident>");

            objFile.close();

        } catch (IOException ex) {
            Logger.getLogger(ImportExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportCV(String idDuCV) {
        FileWriter objFile = null;
        CV cv = new CV("", "", "", 0, 0);
        cv = cv.recupLeCV(idDuCV);
        try {
            //ouverture du fichier en écriture
            objFile = new FileWriter(this.nomFichier);
            objFile.write("titre,description,signature,nomMaitrise1,niveau1,nomMaitrise2,niveau2\r\n");
            objFile.write(cv.getTitre()+",");
            objFile.write(cv.getDescription()+",");
            objFile.write(cv.getSignature()+",");
            objFile.write(cv.getNomMaitrise1()+",");
            objFile.write(String.valueOf(cv.getMaitrise1())+",");
            objFile.write(cv.getNomMaitrise2()+",");
            objFile.write(String.valueOf(cv.getMaitrise2()));
            objFile.close();

        } catch (IOException ex) {
            Logger.getLogger(ImportExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exportUnUtilisateur(int id){
        FileWriter objFile = null;
        try {
            //ouverture du fichier en écriture
            objFile = new FileWriter(this.nomFichier);
            objFile.write("<?xml version = \"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\r\n");
            objFile.write("<utilisateur>\r\n");
            objFile.write("<statut>"+util.getStatut()+"</statut>\r\n");
            objFile.write("<identifiant>"+Utilisateur.getIdentifiant()+"</identifiant>\r\n");
            objFile.write("<nom>"+util.getNom()+"</nom>\r\n");
            objFile.write("<prenom>"+util.getPrenom()+"</prenom>\r\n");
            objFile.write("<num_tel>"+util.getNumeroTelephone()+"</num_tel>\r\n");
            objFile.write("<courriel>"+util.getCourriel()+"</courriel>\r\n");
            objFile.write("<date>"+util.getDateNaissance()+"</date>\r\n");
            objFile.write("</utilisateur>\r\n");

            objFile.close();

        } catch (IOException ex) {
            Logger.getLogger(ImportExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String importFichier() {
        String resFichier = "";

        try {
            FileReader objFile = null;

            //ouverture du fichier en lecture
            objFile = new FileReader(this.nomFichier);
            int c;
            while ((c = objFile.read()) != -1) {
                resFichier += (char) c;
            }
            objFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resFichier;
    }

    public void recupIdent() {
        String resFichier = importFichier();
        char[] tabFichier = resFichier.toCharArray();

        String resultat = "";

        String baliseDebut = "<dernierident>";
        String baliseFin = "</dernierident>";

        char[] resultDebut = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
        char[] resultFin = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};

        for (int i = 0; i < tabFichier.length - 72; i++) {

        }
    }

}
