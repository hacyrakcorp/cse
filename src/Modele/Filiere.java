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
public class Filiere {
    
    int id;
    String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Filiere(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Filiere() {
    }
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM filiere "
                    + "ORDER BY libelle";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Filiere obj = new Filiere();
                    obj.setId(rs.getInt("id"));
                    obj.setLibelle(rs.getString("libelle"));

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
    
    public static Filiere getById(int id){
        Filiere obj = new Filiere();
        try {
            String sql = "SELECT * "
                    + "FROM filiere "
                    + "WHERE id = "+id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {      
                    obj.setId(rs.getInt("id"));
                    obj.setLibelle(rs.getString("libelle"));
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
    
    public static Filiere getByLibelle(String libelle){
        Filiere obj = new Filiere();
        try {
            String sql = "SELECT * "
                    + "FROM filiere "
                    + "WHERE libelle = '"+libelle+"'";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {      
                    obj.setId(rs.getInt("id"));
                    obj.setLibelle(rs.getString("libelle"));
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
    
    public static boolean creerFiliere(String libelle){
        boolean ok = false;
        try {
            String sql = "INSERT INTO filiere "
                    + "VALUES ("+null+", '"+libelle+"')";
            ConnexionParametres.executer(sql);
            ResultSet rs = ConnexionParametres.requeter("SELECT * FROM filiere");
            rs.afterLast();
            GETLASTINSERTED :
            while (rs.previous()){
                if (rs.getObject(2).equals(libelle)){
                    ok = true;
                }
                break GETLASTINSERTED;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }
    
    public static boolean supprimerFiliere(int id){
        boolean ok = false;
        try {
            String sql = "DELETE FROM filiere "
                    + "WHERE id = "+ id;
            if (ConnexionParametres.executer(sql)) {
                ok = true;
            };
           /* ResultSet rs = ConnexionParametres.requeter("SELECT * FROM filiere");
            rs.afterLast();
            GETLASTINSERTED :
            while (rs.previous()){
                if (rs.getObject(1).equals(id)){
                    ok = true;
                }
                break GETLASTINSERTED;
            }*/
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }
    
    
}
