/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur.connexion;

import Modele.Utilisateur;
import Vue.FenConnexion;
import Vue.FenMenuPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Cécile
 */
public class AuthentificationControleur {

    public static void traitementLogIn(String login, String mdp, FenConnexion fenCo) {
        //Récupération du login / mdp
        //Si les champs sont remplis
        if (!login.isEmpty() && !mdp.isEmpty()) {
            //Si on recupere un Utilisateur
            if (Utilisateur.getByLogin(login) != null) {
                //Si mdp correct
                if (!Utilisateur.getByLogin(login).getMdp().equals("")){
                if (Utilisateur.getByLogin(login).getMdp().equals(mdp)) {
                    //Récupere le statut (getById_statut)
                    
                    //Rediriger vers la fenetre correspondante
                    FenMenuPrincipal laFenetre = new FenMenuPrincipal();
                    laFenetre.setVisible(true);
                    fenCo.dispose();

                } else { // Erreur mdp
                    JOptionPane.showMessageDialog(null,
                            "Identifiants incorrects. Ré-essayer !",
                            "Résultat", JOptionPane.ERROR_MESSAGE);
                }
                } else {//Statut eleve
                    JOptionPane.showMessageDialog(null,
                            "Interdiction de se connecter",
                            "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            } else { //Erreur login
                JOptionPane.showMessageDialog(null,
                        "Identifiants incorrects. Ré-essayer !",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
            }
        } else { //Remplir les champs
            JOptionPane.showMessageDialog(null,
                    "Veuillez remplir tout les champs",
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }
}
