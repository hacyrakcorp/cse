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
public class TypeEvaluation {
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

    public TypeEvaluation(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public TypeEvaluation() {
    }
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM typeevaluation";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    TypeEvaluation obj = new TypeEvaluation();
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
    
    public static TypeEvaluation getById(int id){
        TypeEvaluation obj = new TypeEvaluation();
        try {
            String sql = "SELECT * "
                    + "FROM typeevaluation "
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
         TypeEvaluation user = new TypeEvaluation();
        
        ArrayList<TypeEvaluation> tabUser = new ArrayList<TypeEvaluation>();
        tabUser = user.getAllList();
        
        System.out.println(tabUser);
        
        for (TypeEvaluation x : tabUser){//foreach JAVA
            System.out.println(x.getLibelle());
        }
        
        TypeEvaluation test = TypeEvaluation.getById(1);

            System.out.println(test.getId());
            System.out.println(test.getLibelle());
    }
}
