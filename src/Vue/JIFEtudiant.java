/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.connexion.AdministrateurControleur;
import Modele.AppartenirPromotion;
import Modele.ChoisirFiliere;
import Modele.Eleve;
import Modele.Filiere;
import Modele.Promotion;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aminiscloux
 */
public class JIFEtudiant extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public JIFEtudiant() {
        initComponents();
        this.sizeFont();
        this.tableau();
        this.comboFiliere();
        this.comboPromo();

    }

    public void sizeFont() {
        jBtnValider.setFont(new Font("Arial", Font.PLAIN, 20));
        jBtnAjouter.setFont(new Font("Arial", Font.PLAIN, 20));
        jFiltreFiliere.setFont(new Font("Arial", Font.PLAIN, 20));
        jFiltrePromotion.setFont(new Font("Arial", Font.PLAIN, 20));
        jLabelNom.setFont(new Font("Arial", Font.PLAIN, 20));
        jLabelFiltre.setFont(new Font("Arial", Font.PLAIN, 20));
        jTableEtudiant.setFont(new Font("Arial", Font.PLAIN, 20));
        jTextNom.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public void tableau() {
        DefaultTableModel model = (DefaultTableModel) jTableEtudiant.getModel();
        model.getDataVector().clear();

        ArrayList<Eleve> liste = AdministrateurControleur.ListeEtudiant();
        for (int i = 0; i < liste.size(); i++) {
            //Recupere la liste des filieres d'un étudiant
            ArrayList<ChoisirFiliere> tabFiliere = liste.get(i).getFiliere();
            String listFiliere = "";
            for (ChoisirFiliere s : tabFiliere) {
                listFiliere += s.getFiliere().getLibelle() + System.getProperty("line.separator");
            }
            //Multiligne
            JLabel test = new JLabel();
            String listFiliereBr = listFiliere.replace("\n","<br>");
            test.setText("<html>" + listFiliereBr + "</html>");
            //Recupere la liste des promotions de l'élève
            ArrayList<AppartenirPromotion> tabPromo = liste.get(i).getPromo();
            String listPromo = "";
            for (AppartenirPromotion t : tabPromo) {
                listPromo += t.getPromotion().getAnnee() + "; ";
            }
            //Ajoute les lignes au tableau élève
            model.addRow(new Object[]{
                liste.get(i).getUser().getId(),
                liste.get(i).getUser().getNom(),
                liste.get(i).getUser().getPrenom(),
                liste.get(i).getFiliere(),
                test.getText(), // multiligne
                //listFiliere.substring(0, listFiliere.length() - 2), //moins le '; ' final
                liste.get(i).getPromo(),
                listPromo.substring(0, listPromo.length() - 2),});
            //Adpater la taille des lignes
            jTableEtudiant.setRowHeight(calculHauteur(test.getText()));
        }
    }
    
    private int calculHauteur(String s) {
        //nombre de lignes dans la chaine
        String[] lignes = s.split("<br>");
        int nbLignes = 0;
        for (String ligne : lignes) {
            nbLignes += 1;
        }
        System.out.println(nbLignes);
        //taille d'une ligne dans le tableau
        int tailleLigne = 0;
        for (int i = 0; i<nbLignes;i++){
            tailleLigne += 26;
        }
        System.out.println(tailleLigne);
        return tailleLigne;
    }

    private void updateRowHeights() {
        for (int row = 0; row < jTableEtudiant.getRowCount(); row++) {
            int rowHeight = jTableEtudiant.getRowHeight();

            for (int column = 0; column < jTableEtudiant.getColumnCount(); column++) {
                Component comp = jTableEtudiant.prepareRenderer(jTableEtudiant.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }
            jTableEtudiant.setRowHeight(row, rowHeight);
        }
    }

    public void comboFiliere() {
        jFiltreFiliere.removeAllItems();
        jFiltreFiliere.addItem("");
        ArrayList<Filiere> list = AdministrateurControleur.ListeFiliere();
        for (Filiere x : list) {
            jFiltreFiliere.addItem(x.getLibelle());
        }
    }

    public void comboPromo() {
        jFiltrePromotion.removeAllItems();
        jFiltrePromotion.addItem("");
        ArrayList<Promotion> list = AdministrateurControleur.ListePromotion();
        for (Promotion x : list) {
            jFiltrePromotion.addItem(Integer.toString(x.getAnnee()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFiltre = new javax.swing.JPanel();
        jLabelNom = new javax.swing.JLabel();
        jTextNom = new javax.swing.JTextField();
        jLabelFiltre = new javax.swing.JLabel();
        jBtnValider = new javax.swing.JButton();
        jFiltreFiliere = new javax.swing.JComboBox<>();
        jFiltrePromotion = new javax.swing.JComboBox<>();
        jBtnAjouter = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEtudiant = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion des filières");
        setPreferredSize(new java.awt.Dimension(2160, 1440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFiltre.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNom.setText("Nom");

        jLabelFiltre.setText("Filtre :");

        jBtnValider.setText("Valider");

        jFiltreFiliere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jFiltrePromotion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBtnAjouter.setText("Ajouter un utilisateur");

        javax.swing.GroupLayout jPanelFiltreLayout = new javax.swing.GroupLayout(jPanelFiltre);
        jPanelFiltre.setLayout(jPanelFiltreLayout);
        jPanelFiltreLayout.setHorizontalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFiltre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFiltreLayout.createSequentialGroup()
                        .addComponent(jLabelNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFiltreFiliere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFiltrePromotion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(357, 357, 357)
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAjouter)
                    .addComponent(jBtnValider, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelFiltreLayout.setVerticalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltreLayout.createSequentialGroup()
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFiltre)
                    .addComponent(jBtnAjouter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFiltreFiliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFiltrePromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnValider))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelFiltre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 830, 240));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 880, 880));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableEtudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Prénom", "idFiliere", "Filière", "idPromotion", "Promotion"
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
        jScrollPane2.setViewportView(jTableEtudiant);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 830, 610));

        setBounds(0, 0, 1774, 956);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAjouter;
    private javax.swing.JButton jBtnValider;
    private javax.swing.JComboBox<String> jFiltreFiliere;
    private javax.swing.JComboBox<String> jFiltrePromotion;
    private javax.swing.JLabel jLabelFiltre;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFiltre;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEtudiant;
    private javax.swing.JTextField jTextNom;
    // End of variables declaration//GEN-END:variables
}
