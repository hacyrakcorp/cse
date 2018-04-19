/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Cécile
 */
public class Note {
    int id;
    float note;
    Date date;
    int coef;
    Utilisateur eleve;
    Utilisateur formateur;
    TypeEvaluation typeEvaluation;
    Matiere matiere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public Utilisateur getEleve() {
        return eleve;
    }

    public void setEleve(Utilisateur eleve) {
        this.eleve = eleve;
    }

    public Utilisateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Utilisateur formateur) {
        this.formateur = formateur;
    }

    public TypeEvaluation getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Note(int id, float note, Date date, int coef, Utilisateur eleve, 
            Utilisateur formateur, TypeEvaluation typeEvaluation, 
            Matiere matiere) {
        this.id = id;
        this.note = note;
        this.date = date;
        this.coef = coef;
        this.eleve = eleve;
        this.formateur = formateur;
        this.typeEvaluation = typeEvaluation;
        this.matiere = matiere;
    }

    public Note() {
    }
    
    public static ArrayList getAllList(){
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM note";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Note obj = new Note();
                    obj.setId(rs.getInt("id"));
                    obj.setNote(rs.getFloat("note"));
                    obj.setDate(rs.getDate("dateSituation"));
                    obj.setCoef(rs.getInt("coefficient"));
                    obj.setEleve(
                            Utilisateur.getById(rs.getInt("id_Utilisateur")));
                    obj.setFormateur(
                            Utilisateur.getById(rs.getInt("id_Utilisateur_1")));
                    obj.setTypeEvaluation(
                            TypeEvaluation.getById(rs.getInt("id_TypeEvaluation")));
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
}
