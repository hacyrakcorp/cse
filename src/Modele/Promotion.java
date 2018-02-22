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
public class Promotion {
    int id;
    int annee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Promotion(int id, int annee) {
        this.id = id;
        this.annee = annee;
    }
    
    public Promotion() {
        
    }
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM promotion "
                    + "ORDER BY annee";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Promotion obj = new Promotion();
                    obj.setId(rs.getInt("id"));
                    obj.setAnnee(rs.getInt("annee"));

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
    
    public static Promotion getById(int id){
        Promotion obj = new Promotion();
        try {
            String sql = "SELECT * "
                    + "FROM promotion "
                    + "WHERE id = "+id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {      
                    obj.setId(rs.getInt("id"));
                    obj.setAnnee(rs.getInt("annee"));
                }
                
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return obj;
    }

}
