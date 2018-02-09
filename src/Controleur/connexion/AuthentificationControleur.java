/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur.connexion;

/**
 *
 * @author Cécile
 */
public class AuthentificationControleur {
    public static void traitementLogIn(String login,String mdp){
        //Récupération du login / mdp
        //Si les champs sont remplis
        if (!login.isEmpty() && !mdp.isEmpty()){
            //Récupère un Utilisateur selon le login (getByLogin)    
            //Si on recupere un Utilisateur
                //Récupere le mdp (getByMdp)
                //Comparaison avec le mdp récupéré
                //Si mdp correct
                    //Récupere le statut (getById_statut)
                        //Faire une session est authentifié
                        //Faire une session Statut
                        //Faire une session Utilisateur
                        //Rediriger vers la fenetre correspondante
                //Sinon
                    //Erreur identifiant incorrect
            //Sinon Utilisateur est vide
                //Erreur identifiant incorrect
        } else {
        //Sinon les champs sont vides
            //Erreur
        }
    }
}
