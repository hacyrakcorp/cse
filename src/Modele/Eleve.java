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
public class Eleve extends Utilisateur {
    Utilisateur user;
    ArrayList filiere;
    ArrayList promo;
    int age;
    int numRue;
    String libelleRue;
    String ville;
    int codePostal;

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public ArrayList getFiliere() {
        return filiere;
    }

    public void setFiliere(ArrayList filiere) {
        this.filiere = filiere;
    }

    public ArrayList getPromo() {
        return promo;
    }

    public void setPromo(ArrayList promo) {
        this.promo = promo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getLibelleRue() {
        return libelleRue;
    }

    public void setLibelleRue(String libelleRue) {
        this.libelleRue = libelleRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Eleve(Utilisateur user, ArrayList filiere, ArrayList promo, int age, int numRue, String libelleRue, String ville, int codePostal) {
        this.user = user;
        this.filiere = filiere;
        this.promo = promo;
        this.age = age;
        this.numRue = numRue;
        this.libelleRue = libelleRue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Eleve() {
    }
    
    public static ArrayList getAllList() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM eleve, choisirfiliere "
                    + "WHERE eleve.id = choisirfiliere.id "
                    + "GROUP BY eleve.id";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Eleve obj = new Eleve();
                    obj.setUser(Utilisateur.getById(rs.getInt("id")));
                    obj.setFiliere(ChoisirFiliere.getByUtilisateur(rs.getInt("id")));
                    obj.setPromo(AppartenirPromotion.getByUtilisateur(rs.getInt("id"))); 
                    obj.setAge(rs.getInt("age"));
                    obj.setNumRue(rs.getInt("numRue"));
                    obj.setLibelleRue(rs.getString("libelleRue"));
                    obj.setVille(rs.getString("ville"));
                    obj.setCodePostal(rs.getInt("codePostal"));
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
    
    public static void main(String[] args) {
        Eleve user = new Eleve();

        ArrayList<Eleve> tabUser = new ArrayList<Eleve>();
        tabUser = user.getAllList();

        System.out.println(tabUser);
        
        for (Eleve x : tabUser) {//foreach JAVA
            System.out.println(x.getUser().getPrenom());
            System.out.println(x.getUser().getNom());
            System.out.println(x.getAge());
            System.out.println(x.getVille());
            ArrayList<ChoisirFiliere> tabFil = new ArrayList<ChoisirFiliere>();
            tabFil = x.getFiliere();
            for (ChoisirFiliere y : tabFil){
                System.out.println(y.getFiliere().getLibelle());
            }
            ArrayList<AppartenirPromotion> tabPromo = new ArrayList<AppartenirPromotion>();
            tabPromo = x.getPromo();
            for (AppartenirPromotion z : tabPromo) {
                System.out.println(z.getPromotion().getAnnee());
            }
           // System.out.println(x.getFiliere());
        }
    }
}
