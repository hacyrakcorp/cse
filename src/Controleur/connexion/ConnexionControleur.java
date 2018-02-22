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
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import Modele.ConnexionParametres;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ConnexionControleur {

    static ConnexionParametres lesParametres;
    static boolean etatConnexion;
    static Connection laConnexionStatique;

    static {
        boolean ok = true;
        lesParametres = new ConnexionParametres();
        try {
            Class.forName(lesParametres.getDriverSGBD());
            etatConnexion = true;
           /* JOptionPane.showMessageDialog(null,
                    "OK");*/
        } catch (ClassNotFoundException ex) {
           /* JOptionPane.showMessageDialog(null,
                    "Classe non trouvée pour le chargement du pilote JDBC Mysql",
                    "ALERT", JOptionPane.ERROR_MESSAGE);*/
            ok = false;
            etatConnexion = false;
        }
        
        if (ok) {
            try {
                // Récupération des paramètres présents 
                // dans la classe ConnexionParametres
                String urlBD = lesParametres.getServeurBD();
                String nomUtilisateur = lesParametres.getNomUtilisateur();
                String motDePasse = lesParametres.getMotDePasse();
                
                //Création de la connexion
                laConnexionStatique = (Connection) DriverManager
                        .getConnection(urlBD, nomUtilisateur, motDePasse);
                etatConnexion = true;
                //JOptionPane.showMessageDialog(null,"OK OK OK");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Impossible de se connecter à la base de données",
                        "ALERTE", JOptionPane.ERROR_MESSAGE);
                etatConnexion = false;
                
            }
        }
    }

    public static boolean isEtatConnexion() {
        return etatConnexion;
    }
    
    public static ConnexionParametres getLesParametres() {
        return lesParametres;
    }

    public static Connection getLaConnexionStatique() {
        return laConnexionStatique;
    }
    
    public static boolean controle(String Nom, String MotDePasse) {
        // Vérification de la saisie
        boolean verificationSaisie;
        if (Nom.equals(lesParametres.getNomUtilisateur()) 
                && MotDePasse.equals(lesParametres.getMotDePasse())){
            verificationSaisie = true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Vérifier votre saisie.",
                    "ERREUR", JOptionPane.ERROR_MESSAGE);
            verificationSaisie = false;
        }
        return verificationSaisie;
    }

    public static void fermetureSession() {
        try {
            laConnexionStatique.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, 
                    "Problème rencontré à  la fermeture de la connexion",
                    "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        
    }
}
