/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cécile
 */
public class AppartenirPromotion {
    Utilisateur utilisateur;
    Promotion promotion;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public AppartenirPromotion(Utilisateur utilisateur, Promotion promotion) {
        this.utilisateur = utilisateur;
        this.promotion = promotion;
    }

    public AppartenirPromotion() {
    }
    
    public static ArrayList getByAll() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM appartenirpromotion "
                    + "ORDER BY id_Utilisateur";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    AppartenirPromotion obj = new AppartenirPromotion();
                    obj.setUtilisateur(Utilisateur.getById(rs.getInt("id_Utilisateur")));
                    obj.setPromotion(Promotion.getById(rs.getInt("id")));

                    tab.add(obj);
                }
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return tab;
    }
    
    public static ArrayList getByUtilisateur(int id) {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM appartenirpromotion "
                    + "WHERE id_Utilisateur = "+id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    AppartenirPromotion obj = new AppartenirPromotion();
                    obj.setUtilisateur(Utilisateur.getById(rs.getInt("id_Utilisateur")));
                    obj.setPromotion(Promotion.getById(rs.getInt("id")));

                    tab.add(obj);
                }
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return tab;
    }
    
    public static ArrayList getByPromotion(int id) {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM appartenirpromotion "
                    + "WHERE id = "+id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    AppartenirPromotion obj = new AppartenirPromotion();
                    obj.setUtilisateur(Utilisateur.getById(rs.getInt("id_Utilisateur")));
                    obj.setPromotion(Promotion.getById(rs.getInt("id")));

                    tab.add(obj);
                }
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return tab;
    }
}
