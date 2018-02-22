/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.connexion.AdministrateurControleur;
import Modele.Filiere;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aminiscloux
 */
public class JIFFilière extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public JIFFilière() {
        initComponents();
        tableauFiliere();
    }

    private void listerFiliere() {
        ArrayList<Filiere> tabFiliere = AdministrateurControleur.ListeFiliere();
        Vector vecteur = new Vector();
        for (Filiere x : tabFiliere) {
            vecteur.add(x.getLibelle());
        }
        JList liste = new JList(vecteur);

        getContentPane().add(liste, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 400, 300));
    }

    private static void tableauFiliere() {
        DefaultTableModel model = (DefaultTableModel) tabFiliere.getModel();
        
        ArrayList<Filiere> listeFiliere = AdministrateurControleur.ListeFiliere();
        for(int i=0;i<listeFiliere.size();i++) {
            model.addRow(new Object[]{listeFiliere.get(i).getId(), listeFiliere.get(i).getLibelle()});
        }
    }
    
    public static void actualiser(){
        DefaultTableModel model = (DefaultTableModel) tabFiliere.getModel();
        model.addRow(new Object[]{listeFiliere.get(i).getId(), listeFiliere.get(i).getLibelle()});
        }
    }
    
    public static void main(String[] args){
        tableauFiliere();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabFiliere = new javax.swing.JTable();
        jBtnAjouter = new javax.swing.JButton();
        jNomFiliere = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion des filières");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabFiliere.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Libelle"
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
        jScrollPane1.setViewportView(tabFiliere);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        jBtnAjouter.setText("Ajouter");
        jBtnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        jNomFiliere.setText("Nouvelle Filiere");
        jNomFiliere.setToolTipText("");
        jNomFiliere.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jNomFiliereFocusGained(evt);
            }
        });
        jNomFiliere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNomFiliereActionPerformed(evt);
            }
        });
        getContentPane().add(jNomFiliere, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 230, -1));

        setBounds(0, 0, 875, 623);
    }// </editor-fold>//GEN-END:initComponents

    private void jNomFiliereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomFiliereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNomFiliereActionPerformed

    private void jNomFiliereFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jNomFiliereFocusGained
        // TODO add your handling code here:
        jNomFiliere.setText("");
    }//GEN-LAST:event_jNomFiliereFocusGained

    private void jBtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAjouterActionPerformed
        // TODO add your handling code here:
        AdministrateurControleur.AjouterFiliere(jNomFiliere.getText());
    }//GEN-LAST:event_jBtnAjouterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAjouter;
    private javax.swing.JTextField jNomFiliere;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabFiliere;
    // End of variables declaration//GEN-END:variables
}
