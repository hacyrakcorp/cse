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
import Modele.Utilisateur;
import java.awt.Font;
import java.sql.SQLException;
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
        jBtnModifier.setFont(new Font("Arial", Font.PLAIN, 20));
        jBtnSupprimer.setFont(new Font("Arial", Font.PLAIN, 20));
        jBtnVider.setFont(new Font("Arial", Font.PLAIN, 20));
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
        //ArrayList<Eleve> liste = AdministrateurControleur.ListeEtudiant();
        ArrayList<Eleve> liste = AdministrateurControleur.AllListEtudiant();
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

    public void comboFiliere() {
        jFiliere.removeAllItems();
        jFiltreFiliere.removeAllItems();
        jFiliere.addItem("");
        jFiltreFiliere.addItem("");
        ArrayList<Filiere> list = AdministrateurControleur.ListeFiliere();
        for (Filiere x : list) {
            jFiltreFiliere.addItem(x.getLibelle());
            jFiliere.addItem(x.getLibelle());
        }
    }

    public void comboPromo() {
        jPromotion.removeAllItems();
        jFiltrePromotion.removeAllItems();
        jPromotion.addItem("");
        jFiltrePromotion.addItem("");
        ArrayList<Promotion> list = AdministrateurControleur.ListePromotion();
        for (Promotion x : list) {
            jPromotion.addItem(Integer.toString(x.getAnnee()));
            jFiltrePromotion.addItem(Integer.toString(x.getAnnee()));
        }
    }

    public void viderFormulaire() {
        jIdEtu.setText("");
        jNom.setText("");
        jPrenom.setText("");
        jAge.setText("");
        jNumRue.setText("");
        jRue.setText("");
        jCP.setText("");
        jVille.setText("");
        DefaultTableModel model = (DefaultTableModel) jTableFiliere.getModel();
        model.setRowCount(0);
        jTableFiliere.repaint();//Actualiser tableau
        DefaultTableModel model1 = (DefaultTableModel) jTablePromotion.getModel();
        model1.setRowCount(0);
        jTablePromotion.repaint();//Actualiser tableau
        jFiliere.setSelectedItem("");
        jPromotion.setSelectedItem("");
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
        jPanel3 = new javax.swing.JPanel();
        jIdEtu = new javax.swing.JTextField();
        jNom = new javax.swing.JTextField();
        jPrenom = new javax.swing.JTextField();
        jFiliere = new javax.swing.JComboBox<>();
        jPromotion = new javax.swing.JComboBox<>();
        jAge = new javax.swing.JTextField();
        jNumRue = new javax.swing.JTextField();
        jRue = new javax.swing.JTextField();
        jCP = new javax.swing.JTextField();
        jVille = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFiliere = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePromotion = new javax.swing.JTable();
        jBtnSupprimer = new javax.swing.JButton();
        jBtnModifier = new javax.swing.JButton();
        jBtnVider = new javax.swing.JButton();
        jBtnAjouter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
                    .addComponent(jFiltreFiliere, 0, 231, Short.MAX_VALUE)
                    .addComponent(jFiltrePromotion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(357, 357, 357)
                .addComponent(jBtnValider, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFiltreLayout.setVerticalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltreLayout.createSequentialGroup()
                .addComponent(jLabelFiltre)
                .addGap(21, 21, 21)
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFiltreFiliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFiltrePromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnValider))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelFiltre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 830, 240));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jIdEtu.setEditable(false);
        jIdEtu.setText("Id");

        jFiliere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jFiliere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFiliereActionPerformed(evt);
            }
        });

        jPromotion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPromotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPromotionActionPerformed(evt);
            }
        });

        jTableFiliere.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filiere"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFiliere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFiliereMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableFiliere);

        jTablePromotion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Promotion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePromotion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePromotionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePromotion);

        jBtnSupprimer.setText("Supprimer");
        jBtnSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnSupprimerMouseClicked(evt);
            }
        });

        jBtnModifier.setText("Modifier");
        jBtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModifierActionPerformed(evt);
            }
        });

        jBtnVider.setText("Vider");
        jBtnVider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnViderActionPerformed(evt);
            }
        });

        jBtnAjouter.setText("Ajouter");
        jBtnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom");

        jLabel2.setText("Prénom");

        jLabel3.setText("Age");

        jLabel4.setText("N°");

        jLabel5.setText("Rue");

        jLabel6.setText("CP");

        jLabel7.setText("Ville");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCP)
                                .addComponent(jNumRue, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jAge, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jNom, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jFiliere, 0, 258, Short.MAX_VALUE))
                            .addComponent(jIdEtu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPrenom)
                            .addComponent(jVille)
                            .addComponent(jRue)
                            .addComponent(jPromotion, 0, 240, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jBtnVider)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jBtnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jIdEtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFiliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnVider)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSupprimer)
                    .addComponent(jBtnModifier)
                    .addComponent(jBtnAjouter))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 880, 870));

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
        jTableEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEtudiantMouseClicked(evt);
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
            jTableEtudiant.getColumnModel().getColumn(6).setMinWidth(60);
            jTableEtudiant.getColumnModel().getColumn(6).setPreferredWidth(60);
            jTableEtudiant.getColumnModel().getColumn(6).setMaxWidth(60);
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

    private void jTableEtudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEtudiantMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int iduser = Integer.parseInt(jTableEtudiant.getValueAt(row, 0).toString());

        Eleve selected = AdministrateurControleur.SelectedEtudiant(iduser);
        jIdEtu.setText(Integer.toString(selected.getUser().getId()));
        jNom.setText(selected.getUser().getNom());
        jPrenom.setText(selected.getUser().getPrenom());
        jAge.setText(Integer.toString(selected.getAge()));
        jNumRue.setText(Integer.toString(selected.getNumRue()));
        jRue.setText(selected.getLibelleRue());
        jCP.setText(Integer.toString(selected.getCodePostal()));
        jVille.setText(selected.getVille());
        DefaultTableModel model = (DefaultTableModel) jTableFiliere.getModel();
        model.getDataVector().clear();
        ArrayList<ChoisirFiliere> liste = selected.getFiliere();
        //Recupere la liste des filieres d'un étudiant
        for (int i = 0; i < liste.size(); i++) {
            model.addRow(new Object[]{
                liste.get(i).getFiliere().getLibelle(),});
        }
        jTableFiliere.repaint();
        DefaultTableModel model1 = (DefaultTableModel) jTablePromotion.getModel();
        model1.getDataVector().clear();
        ArrayList<AppartenirPromotion> liste1 = selected.getPromo();
        //Recupere la liste des filieres d'un étudiant
        for (int i = 0; i < liste1.size(); i++) {
            model1.addRow(new Object[]{
                liste1.get(i).getPromotion().getAnnee()
            });
        }
        jTablePromotion.repaint();


    }//GEN-LAST:event_jTableEtudiantMouseClicked

    private void jBtnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModifierActionPerformed
        int idUser;
        //Si le champs id est vide, on peut pas modifier sinon erreur
        if (jIdEtu.getText().equals("Id") || jIdEtu.getText().equals("")) {
            idUser = -1; //
        } else {
            idUser = Integer.parseInt(jIdEtu.getText());
        }
        if (idUser != -1) {
            try {
                AdministrateurControleur.ModifierEleve(idUser,jNom.getText(), 
                        jPrenom.getText(), 
                        jAge.getText(),
                        jNumRue.getText(),
                        jRue.getText(),
                        jCP.getText(),
                        jVille.getText(),
                        jTableFiliere,
                        jTablePromotion,
                        this);
                this.viderFormulaire();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "Erreur : impossible de modifier l'étudiant",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erreur modification. Sélectionner un étudiant",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jBtnModifierActionPerformed

    private void jBtnSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSupprimerMouseClicked
        // TODO add your handling code here:
        int idUser;
        if (jIdEtu.getText().equals("")) {
            idUser = -1;
        } else {
            idUser = Integer.parseInt(jIdEtu.getText());
        }
        if (idUser != -1) {
            AdministrateurControleur.SupprimerEleve(idUser, this);
            this.viderFormulaire();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erreur suppression, sélectionner un élève.",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnSupprimerMouseClicked

    private void jBtnViderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnViderActionPerformed
        // TODO add your handling code here:
        this.viderFormulaire();
    }//GEN-LAST:event_jBtnViderActionPerformed

    private void jBtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAjouterActionPerformed
        int idUser;
        //Si le champs id est vide, on peut ajouter sinon erreur
        if (jIdEtu.getText().equals("Id") || jIdEtu.getText().equals("")) {
            idUser = -1; //
        } else {
            idUser = Integer.parseInt(jIdEtu.getText());
        }
        
        if (idUser == -1) {
            try {
                AdministrateurControleur.AjouterEleve(jNom.getText(), 
                        jPrenom.getText(), 
                        jAge.getText(),
                        jNumRue.getText(),
                        jRue.getText(),
                        jCP.getText(),
                        jVille.getText(),
                        jTableFiliere,
                        jTablePromotion,
                        this);
                this.viderFormulaire();
            } catch (SQLException ex) {
                //Logger.getLogger(JIFEtudiant.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,
                        "Erreur ajout",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erreur ajout, vider le formulaire.",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAjouterActionPerformed

    private void jFiliereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFiliereActionPerformed
        // Ajouter filiere dans le tableau
        if (jFiliere.getSelectedIndex() != 0) {
            DefaultTableModel model = (DefaultTableModel) jTableFiliere.getModel();
            // model.getDataVector().clear();
            boolean existe = false;
            int i = jTableFiliere.getRowCount();
            for (int j = 0; j <i; j++) {
                if (jTableFiliere.getValueAt(j, 0).equals(jFiliere.getSelectedItem()) ) {
                    existe = true;
                }
                
            }
            if (existe == false) {
                model.addRow(new Object[]{jFiliere.getSelectedItem()});
            } else {
                JOptionPane.showMessageDialog(null,
                        "Déjà présent.",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jFiliereActionPerformed

    private void jTableFiliereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFiliereMouseClicked
        //Suppression d'une filiere du tableau
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        //Filiere selected = Filiere.getByLibelle(source.getValueAt(row,0).toString());
        //Utilisateur user = Utilisateur.getById(Integer.parseInt(jIdEtu.getText()));
        DefaultTableModel model = (DefaultTableModel) jTableFiliere.getModel();
        model.removeRow(row);
        jTableFiliere.repaint();
        //ChoisirFiliere.supprimer(selected.getId(), user.getId());
    }//GEN-LAST:event_jTableFiliereMouseClicked

    private void jPromotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPromotionActionPerformed
        //Ajouter une promotion au tableau
        if (jPromotion.getSelectedIndex() != 0) {
            DefaultTableModel model = (DefaultTableModel) jTablePromotion.getModel();
            // model.getDataVector().clear();
            boolean existe = false;
            int i = jTablePromotion.getRowCount();
            for (int j = 0; j < i; j++) {
                if (jTablePromotion.getValueAt(j, 0).toString().equals(jPromotion.getSelectedItem()) ) {
                    existe = true;
                }
            }
            if (existe == false) {
                model.addRow(new Object[]{jPromotion.getSelectedItem()});
            } else {
                JOptionPane.showMessageDialog(null,
                        "Déjà présent.",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jPromotionActionPerformed

    private void jTablePromotionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePromotionMouseClicked
        //suppression d'une promotion du tableau
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        DefaultTableModel model = (DefaultTableModel) jTablePromotion.getModel();
        model.removeRow(row);
        jTablePromotion.repaint();
    }//GEN-LAST:event_jTablePromotionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAge;
    private javax.swing.JButton jBtnAjouter;
    private javax.swing.JButton jBtnModifier;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JButton jBtnValider;
    private javax.swing.JButton jBtnVider;
    private javax.swing.JTextField jCP;
    private javax.swing.JComboBox<String> jFiliere;
    private javax.swing.JComboBox<String> jFiltreFiliere;
    private javax.swing.JComboBox<String> jFiltrePromotion;
    private javax.swing.JTextField jIdEtu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFiltre;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JTextField jNom;
    private javax.swing.JTextField jNumRue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFiltre;
    private javax.swing.JTextField jPrenom;
    private javax.swing.JComboBox<String> jPromotion;
    private javax.swing.JTextField jRue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableEtudiant;
    private javax.swing.JTable jTableFiliere;
    private javax.swing.JTable jTablePromotion;
    private javax.swing.JTextField jTextNom;
    private javax.swing.JTextField jVille;
    // End of variables declaration//GEN-END:variables
}
