/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur.connexion;

import Modele.AppartenirPromotion;
import Modele.ChoisirFiliere;
import Modele.Eleve;
import javax.swing.*;
import Modele.Filiere;
import Modele.Promotion;
import Modele.Statut;
import Modele.Utilisateur;
import Vue.JIFEtudiant;
import Vue.JIFFilière;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cécile
 */
public class AdministrateurControleur {

    public static ArrayList ListeFiliere() {
        return Filiere.getAllList();
    }

    public static ArrayList ListePromotion() {
        return Promotion.getAllList();
    }

    public static ArrayList ListeEtudiant() {
        return Eleve.getAllList();
    }

    public static ArrayList AllListEtudiant() {
        return Eleve.getAll();
    }

    public static void AjouterFiliere(String nomFiliere, JIFFilière fen) {
        if (!nomFiliere.equals("") && !nomFiliere.equals("Nouvelle Filiere")) {
            if (Filiere.getByLibelle(nomFiliere.toUpperCase()).getLibelle() == null) {
                if (Filiere.creerFiliere(nomFiliere.toUpperCase()) == true) {
                    fen.tableauFiliere();
                    fen.viderNomFiliere();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La filière n'a pu être enregistrée",
                            "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "La filière existe déjà",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Veuillez remplir le champs",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void SupprimerFiliere(int id, JIFFilière fen) {
        if (!Filiere.getById(id).getLibelle().equals(null)) {
            if (Filiere.supprimerFiliere(id) == true) {
                fen.tableauFiliere();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Impossible de supprimer la filière",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Impossible de supprimer la filière",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void SupprimerEleve(int id, JIFEtudiant fen) {

        if (Eleve.supprimerEleve(id) == true && Eleve.supprimerUtilisateur(id) == true) {
            JOptionPane.showMessageDialog(null,
                    "Suppression de l'élève réussi.",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
            fen.tableau();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Impossible de supprimer",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void AjouterEleve(String nom, String prenom, String sAge, String sNum, String rue, String sCp, String ville, JTable filiere, JTable promotion, JIFEtudiant fen) throws SQLException {
       
        if (Eleve.ajouterUtilisateur(nom, prenom, Statut.ELEVE) == true) {
            int user = Utilisateur.dernierID();
            Utilisateur utilisateur = Utilisateur.getById(user);
            int age = 0;
            if (!sAge.equals("")){
                age = Integer.parseInt(sAge);
            } 
            int num = 0;
            if (!sNum.equals("")){
             num = Integer.parseInt(sNum);
            }
            int cp = 0;
            if (!sCp.equals("")){
                cp = Integer.parseInt(sCp);
            }
            DefaultTableModel model = (DefaultTableModel) filiere.getModel();
            for (int i = 0; i<filiere.getRowCount(); i++){
                Filiere uneFiliere = Filiere.getByLibelle(model.getValueAt(i, 0).toString());
                //Ajouter filiere
                if (ChoisirFiliere.ajouter(utilisateur, uneFiliere)){
                    //System.out.println("ok");
                }else {
                    JOptionPane.showMessageDialog(null,
                        "Erreur lors de l'ajout de la filiere",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            }
            DefaultTableModel mod = (DefaultTableModel) promotion.getModel();
            for (int i = 0; i<promotion.getRowCount(); i++){
                Promotion unePromo = Promotion.getByLibelle(mod.getValueAt(i, 0).toString());
                //Ajouter promotion
                if (AppartenirPromotion.ajouter(utilisateur, unePromo)){
                   //System.out.println("ok");
                }else {
                    JOptionPane.showMessageDialog(null,
                        "Erreur lors de l'ajout de la promotion",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if (Eleve.ajouterEleve(age, num, rue, ville, cp, user)) {
                JOptionPane.showMessageDialog(null,
                        "Ajout de l'élève réussi.",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                fen.tableau();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Impossible d'ajouter l'élève",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Impossible d'ajouter l'utilisateur",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void ModifierEleve(int id, String nom, String prenom, String sAge, 
            String sNum, String rue, String sCp, String ville, JTable filiere, 
            JTable promotion, JIFEtudiant fen) throws SQLException {
        //Récupère élève
        Eleve eleve = Eleve.getById(id);
        if (eleve != null){
            int age = 0;
            if (!sAge.equals("")){age = Integer.parseInt(sAge);} 
            int num = 0;
            if (!sNum.equals("")){num = Integer.parseInt(sNum);}
            int cp = 0;
            if (!sCp.equals("")){cp = Integer.parseInt(sCp);}
            
            //Mise à jour des filières
            DefaultTableModel model = (DefaultTableModel) filiere.getModel();
            ChoisirFiliere.supprimerByUser(eleve.getUser());
            for (int i = 0; i<filiere.getRowCount(); i++){
                Filiere uneFiliere = Filiere.getByLibelle(model.getValueAt(i, 0).toString());
                //Ajouter filiere
                if (ChoisirFiliere.ajouter(eleve.getUser(), uneFiliere)){
                    //System.out.println("ok");
                }else {
                    JOptionPane.showMessageDialog(null,
                        "Erreur lors de la modification de la filiere",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            //Mise à jour des promotions
            DefaultTableModel mod = (DefaultTableModel) promotion.getModel();
            AppartenirPromotion.supprimerByUser(eleve.getUser());
            for (int i = 0; i<promotion.getRowCount(); i++){
                Promotion unePromo = Promotion.getByLibelle(mod.getValueAt(i, 0).toString());
                //Ajouter promotion
                if (AppartenirPromotion.ajouter(eleve.getUser(), unePromo)){
                   //System.out.println("ok");
                }else {
                    JOptionPane.showMessageDialog(null,
                        "Erreur lors de l'ajout de la promotion",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            //Mise à jour de l'élève
            if (Eleve.modifierEleve(id, age, num, cp, rue, ville, nom, prenom)) {
                JOptionPane.showMessageDialog(null,
                        "Modification de l'élève réussi.",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                fen.tableau();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Impossible de modifier l'élève",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        
    }

    public static Eleve SelectedEtudiant(int iduser) {
        Eleve selected = new Eleve();
        selected = Eleve.getById(iduser);
        return selected;
    }

}
