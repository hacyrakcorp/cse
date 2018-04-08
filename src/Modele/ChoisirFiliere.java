/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Utilisateur;
import Modele.Filiere;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cécile
 */
public class ChoisirFiliere {

    Utilisateur utilisateur;
    Filiere filiere;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public ChoisirFiliere(Utilisateur utilisateur, Filiere filiere) {
        this.utilisateur = utilisateur;
        this.filiere = filiere;
    }

    public ChoisirFiliere() {
    }

    public static ArrayList getAllListe() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM choisirfiliere "
                    + "ORDER BY id";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    ChoisirFiliere obj = new ChoisirFiliere();
                    obj.setUtilisateur(Utilisateur.getById(rs.getInt("id")));
                    obj.setFiliere(Filiere.getById(rs.getInt("id_Filiere")));

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
                    + "FROM choisirfiliere "
                    + "WHERE id = " + id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    ChoisirFiliere obj = new ChoisirFiliere();
                    obj.setUtilisateur(Utilisateur.getById(rs.getInt("id")));
                    obj.setFiliere(Filiere.getById(rs.getInt("id_Filiere")));

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

    public static ArrayList getByFiliere(int id) {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM choisirfiliere "
                    + "WHERE id_Filiere = " + id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    ChoisirFiliere obj = new ChoisirFiliere();
                    obj.setUtilisateur(Utilisateur.getById(rs.getInt("id")));
                    obj.setFiliere(Filiere.getById(rs.getInt("id_Filiere")));

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

    public static boolean ajouter(Utilisateur user, Filiere filiere) {
        boolean res = false;
        try {
            String sql = "INSERT INTO choisirfiliere "
                    + "VALUES ( " + user.getId() + ", " + filiere.getId() + ")";
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

    public static boolean supprimerByUser(Utilisateur user) {
        boolean res = false;
        try {
            String sql = "DELETE FROM choisirfiliere"
                    + " WHERE id = " + user.getId();
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

    public static boolean supprimer(int user, int filiere) {
        boolean ok = false;
        try {
            String sql = "DELETE FROM choisirfiliere "
                    + "WHERE id = " + user + " "
                    + "AND id_Filiere = " + filiere;
            if (ConnexionParametres.executer(sql)) {
                ok = true;
            };

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }

    public static void main(String[] args) {
        Utilisateur user = Utilisateur.getById(5);
        System.out.println(user.getId());
        System.out.println(user.getNom());
        ChoisirFiliere.supprimerByUser(user);

    }
}
