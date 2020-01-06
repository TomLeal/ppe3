package com.karimandco.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import static com.itextpdf.text.html.WebColors.getRGBColor;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.karimandco.auth.Utilisateur;
import com.karimandco.bdd.DaoSIO;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class Pdf {

    String lienPDF;
    Integer code = new Random().nextInt(100000000);
    static Integer idUtilisateur;
    String test = code.toString();
    private ConnexionDB connexionDb = new ConnexionDB();
    private Connection connexion;
    private Utilisateur util = new Utilisateur();
    private String idDuCV = "";

    public Pdf(String lienPDF) {
        this.lienPDF = lienPDF;

        connexion = connexionDb.getConnnexion();
    }

    public void setUtil(Utilisateur util) {
        this.util = util;
    }

    public boolean verifPDF() {
        if (lienPDF != "") {
            return true;
        } else {
            return false;
        }
    }

    public String corrigeLeLien(String lien) {
        char[] ancielLien = lien.toCharArray();

        String lienResult = "";
        for (int i = 0; i < ancielLien.length; i++) {
            if (ancielLien[i] == '\\') {
                lienResult = lienResult + "\\\\";
            } else {
                lienResult = lienResult + ancielLien[i];
            }
        }

        lienResult = new File("src\\com\\karimandco\\pdf\\cv\\cv" + test + ".pdf").getAbsolutePath();

        String nomCv = "cv" + test + ".pdf";
        String resultat = nomCv + "|" + lienResult;

        return resultat;
    }

    //Accesseur et mutateur
    public String getNomCv() {
        String nomCvAvantSplit = corrigeLeLien("cv");
        String[] nomCvSplit = nomCvAvantSplit.split("[|]");
        String nomCv = nomCvSplit[0];

        return nomCv;
    }

    public String getUrlCv() {
        String urlCvAvantSplit = corrigeLeLien("cv");
        String[] urlCvSplit = urlCvAvantSplit.split("[|]");
        String urlCv = urlCvSplit[1];

        return urlCv;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void genererPDF() throws FileNotFoundException, BadElementException, IOException {
        try {

            idDuCV = getIDCV(idUtilisateur);
            lienPDF = this.getUrlCv();
            System.out.println("ID : " + idUtilisateur);

            ArrayList<Formation> forms = Formation.recupFormation(idDuCV);
            ArrayList<ExperiencePro> expPros = ExperiencePro.recupExperiencePro(idDuCV);
            CV cv = CV.recupCV(idDuCV);

            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            /**
             * Creation de different style de police
             */
            FontSelector selector = new FontSelector();
            Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            selector.addFont(f1);
            Font f2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 41);
            selector.addFont(f2);
            Font f3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            f3.setColor(getRGBColor("#318CE7"));
            selector.addFont(f3);
            Font f4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            selector.addFont(f4);
            Font f5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            f5.setColor(getRGBColor("#318CE7"));
            selector.addFont(f5);
            Font f6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 1);
            f6.setColor(getRGBColor("#318CE7"));
            selector.addFont(f6);
            Image image;
            String url = "src/image/profil.png";
            image = Image.getInstance(url);

            PdfWriter.getInstance(document, new FileOutputStream(lienPDF));
            System.out.println("OK");
            document.open();
            float[] columnWidths = {10f, 10f, 10f, 10f, 800f};
            PdfPTable Table = new PdfPTable(columnWidths);
            PdfPCell Plein = new PdfPCell(new Phrase(""));
            Plein.setBorderColor(BaseColor.WHITE);
            Table.setWidthPercentage(100);
            Table.setSpacingBefore(0f);
            Table.setSpacingAfter(0f);

            /**
             * Travail dans la Premier Cellulue de la table
             */
            PdfPTable Bleu = new PdfPTable(1);
            Bleu.setWidthPercentage(100);
            Bleu.setSpacingBefore(0f);
            Bleu.setSpacingAfter(0f);
            PdfPCell Bleu1 = new PdfPCell(new Phrase(""));
            Bleu1.setBackgroundColor(WebColors.getRGBColor("#318CE7"));
            Bleu1.setBorderColor(BaseColor.WHITE);
            Bleu1.setFixedHeight(842);
            Table.addCell(Bleu1);

            PdfPTable White = new PdfPTable(1);
            White.setWidthPercentage(100);
            White.setSpacingBefore(0f);
            White.setSpacingAfter(0f);
            PdfPCell White1 = new PdfPCell(new Phrase(""));
            White1.setBackgroundColor(BaseColor.WHITE);
            White1.setBorderColor(BaseColor.WHITE);
            White1.setFixedHeight(840);
            Table.addCell(White1);

            PdfPTable Blue = new PdfPTable(1);
            Blue.setWidthPercentage(100);
            Blue.setSpacingBefore(0f);
            Blue.setSpacingAfter(0f);
            PdfPCell Blue1 = new PdfPCell(new Phrase(""));
            Blue1.setBackgroundColor(WebColors.getRGBColor("#318CE7"));
            Blue1.setBorderColor(BaseColor.WHITE);
            Blue1.setFixedHeight(840);
            Table.addCell(Blue1);

            PdfPTable White2 = new PdfPTable(1);
            White2.setWidthPercentage(100);
            White2.setSpacingBefore(0f);
            White2.setSpacingAfter(0f);
            PdfPCell White21 = new PdfPCell(new Phrase(""));
            White21.setBackgroundColor(BaseColor.WHITE);
            White21.setBorderColor(BaseColor.WHITE);
            White21.setFixedHeight(840);
            Table.addCell(White21);

            PdfPCell C1 = new PdfPCell(new Phrase("Gris"));
            C1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            C1.setFixedHeight(840);

            /**
             * Travail dans la Seconde Cellulue de la table
             */
            // <editor-fold>
            /**
             * Création de la table Principale
             */
            PdfPTable Table2 = new PdfPTable(1);
            Table2.setWidthPercentage(100);
            Table2.setSpacingBefore(0f);
            Table2.setSpacingAfter(0f);
            Table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            // </editor-fold>
            /**
             * Création de la tables avec les info et la photo
             */
            float[] columnWidths3 = {500f, 200f};
            PdfPTable Table3 = new PdfPTable(columnWidths3);
            Table3.setWidthPercentage(100);
            Table3.setSpacingBefore(0f);
            Table3.setSpacingAfter(0f);
            /**
             * Création de la Cellule contenant les cellules d'information perso
             */
            PdfPCell PresentationPhoto = new PdfPCell(new Phrase(""));
            PresentationPhoto.addElement(Table3);
            PresentationPhoto.setBorderColor(BaseColor.WHITE);
            /**
             * Création des cellules d'information perso
             */
            PdfPCell Para = new PdfPCell(new Phrase(""));
            Para.setBorderColor(BaseColor.WHITE);
            Paragraph para1 = new Paragraph("");
            para1.add(new Paragraph(util.getNom() + " " + util.getPrenom(), f2));
            para1.add(new Paragraph(util.getCourriel(), f3));
            para1.add(new Paragraph(util.getNumeroTelephone(), f1));
            para1.add(new Paragraph("Date de Naissance : " + util.getDateNaissance(), f1));
            para1.add(new Paragraph(cv.getDescription(), f1));
            Para.addElement(para1);
            /**
             * Creation de la Cellule Image
             */
            PdfPCell Image = new PdfPCell(new Phrase(""));
            Image.setBorderColor(BaseColor.WHITE);
            Image.addElement(image);
            /**
             * Création de la Cellule
             */

            PdfPCell FormationC = new PdfPCell(new Phrase(""));
            Paragraph FormationCV = new Paragraph("", f1);
            for (Formation formation : forms) {
                FormationCV.add(new Paragraph(" ", f1));
                FormationCV.add(new Paragraph(formation.getNom(), f1));
                FormationCV.add(new Paragraph("Adresse : " + formation.getLieu(), f1));
                FormationCV.add(new Paragraph("Du " + formation.getAnneeDebut() + " au " + formation.getAnneeFin(), f1));
                FormationCV.add(new Paragraph(formation.getDescription(), f1));
            }
            FormationC.addElement(FormationCV);

            FormationC.setBorderColor(BaseColor.WHITE);
            /**
             * Création de la categorie Experience Pro
             */
            PdfPCell ExpePro = new PdfPCell(new Phrase(""));
            Paragraph Expe = new Paragraph("EXPERIENCE PROFESSIONNELLE", f5);
            Expe.add(new Paragraph(" ", f6));
            ExpePro.setBorderColor(BaseColor.WHITE);
            ExpePro.addElement(Expe);

            PdfPCell Experience = new PdfPCell(new Phrase(""));
            Paragraph ExperienceP = new Paragraph("", f1);
            for (ExperiencePro exp : expPros) {
                ExperienceP.add(new Paragraph(" ", f1));
                ExperienceP.add(new Paragraph(exp.getEntreprise(), f1));
                ExperienceP.add(new Paragraph("Adresse : " + exp.getLieu(), f1));
                ExperienceP.add(new Paragraph("Du " + exp.getAnneeDebut() + " au " + exp.getAnneeFin(), f1));
                ExperienceP.add(new Paragraph(exp.getDescription(), f1));
            }

            Experience.addElement(ExperienceP);

            Experience.setBorderColor(BaseColor.WHITE);
            /**
             * Création de la categorie Formation
             */
            PdfPCell Formation = new PdfPCell(new Phrase(""));
            Paragraph Forma = new Paragraph("FORMATION", f5);
            Forma.add(new Paragraph(" ", f6));
            Formation.setBorderColor(BaseColor.WHITE);
            Formation.addElement(Forma);

            /**
             * Création de la categorie compétence
             */
            PdfPCell Competence = new PdfPCell(new Phrase(""));
            Paragraph Compete = new Paragraph("COMPETENCE", f5);
            Compete.add(new Paragraph(" ", f6));
            Competence.setBorderColor(BaseColor.WHITE);
            Competence.addElement(Compete);

            System.out.println(cv.getNomMaitrise2());
            PdfPCell compet = new PdfPCell(new Phrase(""));
            Paragraph competenceP = new Paragraph("", f1);
            competenceP.add(new Paragraph(cv.getNomMaitrise1() + " : " + cv.calculNiveauMaitrise(cv.getMaitrise1()), f1));
            competenceP.add(new Paragraph(cv.getNomMaitrise2() + " : " + cv.calculNiveauMaitrise(cv.getMaitrise2()), f1));
            compet.setBorderColor(BaseColor.WHITE);
            compet.addElement(competenceP);

            /**
             * Création de la barre bleu qui sépare chaque Categorie
             */
            PdfPCell TraitBleu = new PdfPCell(new Phrase(""));
            TraitBleu.setBorderColor(BaseColor.WHITE);
            TraitBleu.setBackgroundColor(WebColors.getRGBColor("#318CE7"));
            TraitBleu.setFixedHeight(1f);
            /**
             * Rajout de Toute les Cellule et Table dans la Table Principale
             */
            Table3.addCell(Para);
            Table3.addCell(Image);
            Table2.addCell(PresentationPhoto);
            Table2.addCell(ExpePro);
            Table2.addCell(TraitBleu);
            Table2.addCell(Experience);
            Table2.addCell(Formation);
            Table2.addCell(TraitBleu);
            Table2.addCell(FormationC);
            Table2.addCell(Competence);
            Table2.addCell(compet);
            Table2.addCell(TraitBleu);
            //Table2.addCell(espaces);
            Table2.addCell(TraitBleu);
            // Table2.addCell(espaces);
            Table2.addCell(TraitBleu);
            // Table2.addCell(espaces);
            Plein.addElement(Table2);
            Table.addCell(Plein);

            document.add(Table);

            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Récupère l'id du CV d'un utilisateur dans la base de donnée.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    private String getIDCV(Integer id) throws SQLException {
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            ResultSet idcv = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv WHERE id_utilisateur = " + id);
            if (idcv.next()) {
                return idcv.getString("id");
            }
        }
        return "";
    }
}
