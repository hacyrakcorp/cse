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
public class Matiere {
    int id;
    String code;
    float coefficient;
    String libelle;
    String commentaire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Matiere(int id, String code, float coefficient, String libelle, String commentaire) {
        this.id = id;
        this.code = code;
        this.coefficient = coefficient;
        this.libelle = libelle;
        this.commentaire = commentaire;
    }

    public Matiere() {
    }
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM matiere";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Matiere obj = new Matiere();
                    obj.setId(rs.getInt("id"));
                    obj.setCode(rs.getString("code"));
                    obj.setCoefficient(rs.getFloat("coefficient"));
                    obj.setLibelle(rs.getString("libelle"));
                    obj.setCommentaire(rs.getString("commentaire"));
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
    
    public static Matiere getById(int id){
        Matiere obj = new Matiere();
        try {
            String sql = "SELECT * "
                    + "FROM matiere "
                    + "WHERE id = "+id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {      
                    obj.setId(rs.getInt("id"));
                    obj.setCode(rs.getString("code"));
                    obj.setCoefficient(rs.getFloat("coefficient"));
                    obj.setLibelle(rs.getString("libelle"));
                    obj.setCommentaire(rs.getString("commentaire"));
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
        ArrayList<Matiere> tab = Matiere.getAllList();
        
        for (Matiere x : tab){
            System.out.println(x.getLibelle());
        }
        System.out.println("");
        System.out.println(Matiere.getById(1).getCommentaire());
    }
}
