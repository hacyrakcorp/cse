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
    
    public static void AjouterFiliere(String nomFiliere){
        if (!nomFiliere.equals("") && !nomFiliere.equals("Nouvelle Filiere")){
            if (Filiere.getByLibelle(nomFiliere.toUpperCase()).getLibelle() == null){
               if (Filiere.creerFiliere(nomFiliere.toUpperCase()) == true) {
                   JIFFilière.actualiser();
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
}
