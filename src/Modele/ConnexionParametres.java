/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.connexion.ConnexionControleur;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cécile
 */
public class ConnexionParametres {
    private String nomUtilisateur;
    private String motDePasse;
    private String serveurBD;
    private String driverSGBD; 

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getServeurBD() {
        return serveurBD;
    }

    public void setServeurBD(String serveurBD) {
        this.serveurBD = serveurBD;
    }

    public String getDriverSGBD() {
        return driverSGBD;
    }

    public void setDriverSGBD(String driverSGBD) {
        this.driverSGBD = driverSGBD;
    }

    public ConnexionParametres() {
        nomUtilisateur = "root";
        motDePasse = "root";
        driverSGBD = "com.mysql.jdbc.Driver";
        serveurBD = "jdbc:mysql://localhost/cse";
    }
    
    
    
    public static ResultSet requeter(String sql) throws SQLException {
        Connection laConnexion = ConnexionControleur.getLaConnexionStatique();
        ResultSet rs = null;
        try{
            Statement state = (Statement) laConnexion.createStatement();
            rs = state.executeQuery(sql);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return rs; 
    }
    
    public static boolean executer(String sql) throws SQLException {
        Connection laConnexion = ConnexionControleur.getLaConnexionStatique();
        boolean verif = false;
        try{
            Statement state = (Statement) laConnexion.createStatement();
            PreparedStatement pst = laConnexion.prepareStatement(sql);
            state.execute(sql);
            verif = true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return verif;
    }
    
    
}
