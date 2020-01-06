package com.karimandco.pdf;

import com.itextpdf.text.BadElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class VoirPdf extends javax.swing.JPanel {

    private String lienPDF = "";
    public Pdf pdf2 = null;

    /**
     * Creates new form VoirPdf
     */
    public VoirPdf() {
        initComponents();
        lienPDF = "cv";
        this.pdf2 = new Pdf(lienPDF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appercu = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        appercu.setText("Voir le pdf");
        appercu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appercuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(appercu, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(appercu)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String adjouterAuFichierASupprimer() {
        String fichierADelete = this.pdf2.getUrlCv();
        return fichierADelete;
    }

    
    public String ajouterUnCv(){
        String tableau = adjouterAuFichierASupprimer() + "|" + this.pdf2.getUrlCv();
        return tableau;
    }

    public Pdf getPdf() {
        return pdf2;
    }
    
    public Pdf toto(){
        return this.pdf2;
    }

    
    private void appercuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appercuActionPerformed
        this.pdf2 = new Pdf(lienPDF);
        System.out.println(ajouterUnCv());

        if (pdf2.verifPDF()) {
            try {
                pdf2.genererPDF();
                LecteurPDF lecteur = new LecteurPDF(pdf2.getUrlCv());
                //créer le JFrame
                JFrame f = new JFrame("Lecteur PDF");
                f.setSize(1024, 768);
                f.setLocationRelativeTo(this);
                f.getContentPane().add(lecteur);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                if (JFrame.DISPOSE_ON_CLOSE >= 0) {
                    System.out.println(pdf2.getUrlCv());
                    File monfichier = new File(pdf2.getUrlCv());
                    monfichier.deleteOnExit();
                } else {
                    System.out.println("Pas coucou1");
                }

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Erreur", "PDF", JOptionPane.ERROR_MESSAGE);
            } catch (BadElementException ex) {

            } catch (IOException ex) {

            } catch (Exception ex) {
                Logger.getLogger(VoirPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showConfirmDialog(this, "Pas ok, c'est pas bon");
        }
        System.out.println(pdf2.getNomCv());
    }//GEN-LAST:event_appercuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appercu;
    // End of variables declaration//GEN-END:variables
}
