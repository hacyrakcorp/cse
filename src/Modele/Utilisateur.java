/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import com.mysql.jdbc.Statement;
import java.sql.*;
import Controleur.connexion.ConnexionControleur;
import javax.swing.JOptionPane;


/**
 *
 * @author Cécile
 */
public abstract class Utilisateur {
    String mdp;
    String nom;
    String prenom;
    
    private static Connection laConnexion = 
            ConnexionControleur.getLaConnexionStatique();
    
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //CONSTRUCTEURS
    public Utilisateur(String mdp, String nom, String prenom) {
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur() {
    }
    
    public void readCRUD() {
        try {
            Statement state = (Statement) laConnexion.createStatement();
            String sql = "SELECT *"
                    + "FROM utilisateur"
                    + "ORDER BY nom";
            ResultSet rs = state.executeQuery(sql);
            
            while (rs.next()) {
                String nomU = rs.getString("nom");
            }
                
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
