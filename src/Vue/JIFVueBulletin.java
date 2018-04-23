/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.connexion.AdministrateurControleur;
import Controleur.connexion.RFAdministrateur;
import Modele.AppartenirPromotion;
import Modele.Bulletin;
import Modele.ChoisirFiliere;
import Modele.Comprendre;
import Modele.Eleve;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aminiscloux
 */
public class JIFVueBulletin extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFVueBulletin
     */
    public JIFVueBulletin() {
        initComponents();
        this.tableau("");
    }
    
    public void tableau(String filtre) {
        DefaultTableModel model = (DefaultTableModel) jTableEtudiant.getModel();
        model.getDataVector().clear();
        ArrayList<Eleve> liste = AdministrateurControleur.ListeEtudiant();
        /*ArrayList<Eleve> liste = AdministrateurControleur.EtudiantFiltre(filtre,
                jTextNom.getText(), jFiltreFiliere.getSelectedItem().toString(),
                jFiltrePromotion.getSelectedItem().toString());*/
        int tailleLigne = 0;
        for (int i = 0; i < liste.size(); i++) {
            //Recupere la liste des filieres d'un étudiant
            ArrayList<ChoisirFiliere> tabFiliere = liste.get(i).getFiliere();
            String listFiliere = "";
            for (ChoisirFiliere s : tabFiliere) {
                listFiliere += s.getFiliere().getLibelle() + System.getProperty("line.separator");
            }
            //Multiligne
            JLabel test = new JLabel();
            String listFiliereBr = listFiliere.replace("\n", "<br>");
            test.setText("<html>" + listFiliereBr + "</html>");

            //Recupere la liste des promotions de l'élève
            ArrayList<AppartenirPromotion> tabPromo = liste.get(i).getPromo();
            String listPromo = "";
            for (AppartenirPromotion t : tabPromo) {
                listPromo += t.getPromotion().getAnnee() + System.getProperty("line.separator");
            }
            //Multiligne
            JLabel test1 = new JLabel();
            String listPromoBr = listPromo.replace("\n", "<br>");
            test1.setText("<html>" + listPromoBr + "</html>");

            //Ajoute les lignes au tableau élève
            model.addRow(new Object[]{
                liste.get(i).getUser().getId(),
                liste.get(i).getUser().getNom(),
                liste.get(i).getUser().getPrenom(),
                liste.get(i).getFiliere(),
                test.getText(), // multiligne
                //listFiliere.substring(0, listFiliere.length() - 2), //moins le '; ' final
                liste.get(i).getPromo(),
                test1.getText(),});
            //listPromo.substring(0, listPromo.length() - 2),});
            //Adpater la taille des lignes
            int filiere = calculHauteur(test.getText());
            int promo = calculHauteur(test1.getText());
            if (filiere >= promo) {
                tailleLigne = filiere;
            } else {
                tailleLigne = promo;
            }
            jTableEtudiant.setRowHeight(i, tailleLigne);
        }
    }

    private int calculHauteur(String s) {
        //nombre de lignes dans la chaine
        String[] lignes = s.split("<br>");
        int nbLignes = 0;
        for (String ligne : lignes) {
            nbLignes += 1;
        }
        //taille d'une ligne dans le tableau
        int tailleLigne = 0;
        for (int i = 0; i < nbLignes; i++) {
            tailleLigne += 26;
        }
        return tailleLigne;
    }
    
    private void viderTable(DefaultTableModel model, JTable table){
        model.setRowCount(0);
        table.setModel(model);
        table.repaint();
    }
    
    private void viderFormulaire() {
        jFormattedTxtDate.setText("");
        jTextAreaAppreciation.setText("");
        jTxtMoyGene.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboFiliere = new javax.swing.JComboBox<>();
        jComboPromotion = new javax.swing.JComboBox<>();
        jBtnValider = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEtudiant = new javax.swing.JTable();
        jLabEntete = new javax.swing.JLabel();
        jFormattedTxtDate = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabMoyGene = new javax.swing.JLabel();
        jTxtMoyGene = new javax.swing.JTextField();
        jLabAppreciation = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaAppreciation = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableBulletin = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Affichage des bulletins");
        setPreferredSize(new java.awt.Dimension(2160, 1440));

        jComboFiliere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SLAM", "SISR", "TC", "DEUG" }));
        jComboFiliere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFiliereActionPerformed(evt);
            }
        });

        jComboPromotion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018" }));

        jBtnValider.setText("Valider");

        jTableEtudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom", "IdFiliere", "Filiere", "IdPromotion", "Promotion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEtudiant.setColumnSelectionAllowed(true);
        jTableEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEtudiantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEtudiant);
        jTableEtudiant.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableEtudiant.getColumnModel().getColumnCount() > 0) {
            jTableEtudiant.getColumnModel().getColumn(0).setMinWidth(0);
            jTableEtudiant.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableEtudiant.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableEtudiant.getColumnModel().getColumn(3).setMinWidth(0);
            jTableEtudiant.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTableEtudiant.getColumnModel().getColumn(3).setMaxWidth(0);
            jTableEtudiant.getColumnModel().getColumn(5).setMinWidth(0);
            jTableEtudiant.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTableEtudiant.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jLabEntete.setText("Bulletin du : ");

        jFormattedTxtDate.setText("JJ/MM/AAAA");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matière", "Moyenne", "Commentaire"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabMoyGene.setText("Moyenne générale");

        jLabAppreciation.setText("Appréciation générale :");

        jTextAreaAppreciation.setColumns(20);
        jTextAreaAppreciation.setRows(5);
        jScrollPane3.setViewportView(jTextAreaAppreciation);

        jTableBulletin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBulletin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBulletinMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableBulletin);
        if (jTableBulletin.getColumnModel().getColumnCount() > 0) {
            jTableBulletin.getColumnModel().getColumn(0).setMinWidth(0);
            jTableBulletin.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableBulletin.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboFiliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jBtnValider))
                    .addComponent(jComboPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabMoyGene)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtMoyGene, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabEntete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jFormattedTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabAppreciation)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jComboPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboFiliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnValider))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabEntete)
                            .addComponent(jFormattedTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabMoyGene)
                            .addComponent(jTxtMoyGene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabAppreciation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1136, 655);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboFiliereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFiliereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFiliereActionPerformed

    private void jTableEtudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEtudiantMouseClicked
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        viderTable(mod,jTable1);
        viderFormulaire();
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int iduser = Integer.parseInt(jTableEtudiant.getValueAt(row, 0).toString());
        
        ArrayList<Bulletin> tabBulletin = RFAdministrateur.listeBulletinByEtudiant(iduser);
        
        DefaultTableModel model = (DefaultTableModel) jTableBulletin.getModel();
        model.getDataVector().clear();
        viderTable(model, jTableBulletin);
        for (Bulletin unBulletin : tabBulletin){
            model.addRow(new Object[]{
                unBulletin.getId(),
                unBulletin.getDate()});
        }
    }//GEN-LAST:event_jTableEtudiantMouseClicked

    private void jTableBulletinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBulletinMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int id = Integer.parseInt(jTableBulletin.getValueAt(row, 0).toString());
        
        Bulletin selected = Bulletin.getById(id);
        
        //Date
        jFormattedTxtDate.setText(selected.getDate().toString());
        //Appréciation
        jTextAreaAppreciation.setText(selected.getAppreciation());
        //Moyenne Général
        jTxtMoyGene.setText(String.valueOf(selected.getMoyenneGenerale()));
        
        ArrayList<Comprendre> tabComprendre = Comprendre.getByBulletin(id);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().clear();
        viderTable(model, jTable1);
        
        //Moyenne par matiere
        //Tous les notes de l'élève / matiere / compris entre les dates 
        //Du bulletin
                
        for(Comprendre x : tabComprendre){
            model.addRow(new Object[]{
                x.getMatiere().getLibelle(),
                0,
                x.getCommentaire()});
        }

    }//GEN-LAST:event_jTableBulletinMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnValider;
    private javax.swing.JComboBox<String> jComboFiliere;
    private javax.swing.JComboBox<String> jComboPromotion;
    private javax.swing.JFormattedTextField jFormattedTxtDate;
    private javax.swing.JLabel jLabAppreciation;
    private javax.swing.JLabel jLabEntete;
    private javax.swing.JLabel jLabMoyGene;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableBulletin;
    private javax.swing.JTable jTableEtudiant;
    private javax.swing.JTextArea jTextAreaAppreciation;
    private javax.swing.JTextField jTxtMoyGene;
    // End of variables declaration//GEN-END:variables
}
