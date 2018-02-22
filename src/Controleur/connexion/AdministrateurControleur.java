/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur.connexion;
import javax.swing.*;
import Modele.Filiere;
import Vue.JIFFilière;
import java.util.ArrayList;
/**
 *
 * @author Cécile
 */
public class AdministrateurControleur {
    public static ArrayList ListeFiliere(){
        return Filiere.getAllList(); 
    }
    
    public static void AjouterFiliere(String nomFiliere, JIFFilière fen){
        if (!nomFiliere.equals("") && !nomFiliere.equals("Nouvelle Filiere")){
            if (Filiere.getByLibelle(nomFiliere.toUpperCase()).getLibelle() == null){
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
    
    public static void SupprimerFiliere(int id, JIFFilière fen){
        if (!Filiere.getById(id).getLibelle().equals(null)){
            if (Filiere.supprimerFiliere(id) == true){
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
}
