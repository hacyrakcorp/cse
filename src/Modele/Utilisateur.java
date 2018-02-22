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
public class Utilisateur {

    int id;
    String mdp;
    String nom;
    String prenom;
    Statut id_statut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Statut getId_statut() {
        return id_statut;
    }

    public void setId_statut(Statut id_statut) {
        this.id_statut = id_statut;
    }

    //CONSTRUCTEURS
    public Utilisateur(int id, String mdp, String nom, String prenom) {
        this.id = id;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur() {
    }

    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM utilisateur "
                    + "ORDER BY nom";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Utilisateur obj = new Utilisateur();
                    obj.setId(rs.getInt("id"));
                    obj.setNom(rs.getString("nom"));
                    obj.setPrenom(rs.getString("prenom"));
                    obj.setMdp(rs.getString("motDePasse"));
                    obj.setId_statut(Statut.getById(rs.getInt("id_Statut")));

                    tab.add(obj);
                }
                rs.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }

        return tab;
    }

    public static Utilisateur getById(int id) {
        Utilisateur obj = new Utilisateur();
        try {
            String sql = "SELECT * "
                    + "FROM utilisateur "
                    + "WHERE id = " + id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    obj.setId(rs.getInt("id"));
                    obj.setNom(rs.getString("nom"));
                    obj.setPrenom(rs.getString("prenom"));
                    obj.setMdp(rs.getString("motDePasse"));
                    obj.setId_statut(Statut.getById(rs.getInt("id_Statut")));
                   
                }
                rs.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return obj;
    }
    
    public static Utilisateur getByLogin(String login) {
        Utilisateur obj = new Utilisateur();
        try {
            String sql = "SELECT * "
                    + "FROM utilisateur "
                    + "WHERE nom = '" + login+"'";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    obj.setId(rs.getInt("id"));
                    obj.setNom(rs.getString("nom"));
                    obj.setPrenom(rs.getString("prenom"));
                    obj.setMdp(rs.getString("motDePasse"));
                    obj.setId_statut(Statut.getById(rs.getInt("id_Statut")));
                }
                rs.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return obj;
    }

    public static void main(String[] args) {
        Utilisateur user = new Utilisateur();

        ArrayList<Utilisateur> tabUser = new ArrayList<Utilisateur>();
        tabUser = user.getAllList();

        System.out.println(tabUser);

        for (Utilisateur x : tabUser) {//foreach JAVA
            System.out.println(x.getPrenom());
            System.out.println(x.getNom());
        }


    }

}
