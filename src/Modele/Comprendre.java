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
public class Comprendre {
    Bulletin bulletin;
    Matiere matiere;

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Comprendre(Bulletin bulletin, Matiere matiere) {
        this.bulletin = bulletin;
        this.matiere = matiere;
    }

    public Comprendre() {
    }
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM comprendre "
                    + "ORDER BY id_Matiere";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Comprendre obj = new Comprendre();
                    obj.setBulletin(Bulletin.getById(rs.getInt("id")));
                    obj.setMatiere(Matiere.getById(rs.getInt("id_Matiere")));
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
    
    public static ArrayList getByBulletin(int id) {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM comprendre "
                    + "WHERE id = " + id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Comprendre obj = new Comprendre();
                   obj.setBulletin(Bulletin.getById(rs.getInt("id")));
                    obj.setMatiere(Matiere.getById(rs.getInt("id_Matiere")));
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
    
    public static ArrayList getByMatiere(int id) {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM comprendre "
                    + "WHERE id_Matiere = " + id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Comprendre obj = new Comprendre();
                   obj.setBulletin(Bulletin.getById(rs.getInt("id")));
                    obj.setMatiere(Matiere.getById(rs.getInt("id_Matiere")));
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
    
    public static boolean ajouter(Bulletin bulletin, Matiere matiere) {
        boolean res = false;
        try {
            String sql = "INSERT INTO comprendre "
                    + "VALUES ( " + bulletin.getId() + ", " + matiere.getId() + ")";
            if (ConnexionParametres.executer(sql)) {

                res = true;
            };
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }
}
