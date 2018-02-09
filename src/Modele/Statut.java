/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cécile
 */
public class Statut {
    
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

    public Statut(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Statut() {
    }
    
    
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM statut";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Statut obj = new Statut();
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
    
    public static Statut getById(int id){
        Statut obj = new Statut();
        try {
            String sql = "SELECT * "
                    + "FROM statut "
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

    public static void main(String[] args) {
        Statut user = new Statut();
        
        ArrayList<Statut> tabUser = new ArrayList<Statut>();
        tabUser = user.getAllList();
        
        System.out.println(tabUser);
        
        for (Statut x : tabUser){//foreach JAVA
            System.out.println(x.getLibelle());
        }
        
        Statut statut = Statut.getById(1);

            System.out.println(statut.getId());
            System.out.println(statut.getLibelle());

        
    }

}
