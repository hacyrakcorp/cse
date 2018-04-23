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
public class Bulletin {
    int id;
    float moyenneGenerale;
    String appreciation;
    String mention;
    Date date;
    Date dateFin;
    int position;
    Utilisateur eleve;

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(float moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Utilisateur getEleve() {
        return eleve;
    }

    public void setEleve(Utilisateur eleve) {
        this.eleve = eleve;
    }

    public Bulletin(int id, float moyenneGenerale, String appreciation, String mention, Date date, Date dateFin, int position, Utilisateur eleve) {
        this.id = id;
        this.moyenneGenerale = moyenneGenerale;
        this.appreciation = appreciation;
        this.mention = mention;
        this.date = date;
        this.dateFin = dateFin;
        this.position = position;
        this.eleve = eleve;
    }
    
    

    
    

    public Bulletin() {
    }
    
    public static ArrayList getAllList(){
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM bulletin";
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Bulletin obj = new Bulletin();
                    obj.setId(rs.getInt("id"));
                    obj.setAppreciation(rs.getString("appreciation"));
                    obj.setDate(rs.getDate("dateSituation"));
                    obj.setDateFin(rs.getDate("dateFin"));
                    obj.setMention(rs.getString("mention"));
                    obj.setMoyenneGenerale(rs.getFloat("moyenneGenerale"));
                    obj.setPosition(rs.getInt("positionGenerale"));
                    obj.setEleve(Utilisateur.getById(rs.getInt("id_utilisateur")));
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
    
    public static ArrayList getByUtilisateur(int utilisateur){
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM bulletin "
                    + "WHERE id_utilisateur = "+utilisateur;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    Bulletin obj = new Bulletin();
                    obj.setId(rs.getInt("id"));
                    obj.setAppreciation(rs.getString("appreciation"));
                    obj.setDate(rs.getDate("dateSituation"));
                    obj.setDateFin(rs.getDate("dateFin"));
                    obj.setMention(rs.getString("mention"));
                    obj.setMoyenneGenerale(rs.getFloat("moyenneGenerale"));
                    obj.setPosition(rs.getInt("positionGenerale"));
                    obj.setEleve(Utilisateur.getById(rs.getInt("id_utilisateur")));
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
    
    public static Bulletin getById(int id){
        Bulletin obj = new Bulletin();
        try {
            String sql = "SELECT * "
                    + "FROM bulletin "
                    + "WHERE id = "+id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {      
                    obj.setId(rs.getInt("id"));
                    obj.setAppreciation(rs.getString("appreciation"));
                    obj.setDate(rs.getDate("dateSituation"));
                    obj.setDateFin(rs.getDate("dateFin"));
                    obj.setMention(rs.getString("mention"));
                    obj.setMoyenneGenerale(rs.getFloat("moyenneGenerale"));
                    obj.setPosition(rs.getInt("positionGenerale"));
                    obj.setEleve(Utilisateur.getById(rs.getInt("id_utilisateur")));
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
        ArrayList<Bulletin> tab = Bulletin.getAllList();
        
        for (Bulletin x : tab){
            System.out.println(x.getDate());
        }
        System.out.println("");
        System.out.println(Bulletin.getById(1).getAppreciation());
    }
}
