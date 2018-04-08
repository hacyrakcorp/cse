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

    public ArrayList<ChoisirFiliere> getFiliere() {
        return filiere;
    }

    public void setFiliere(ArrayList filiere) {
        this.filiere = filiere;
    }

    public ArrayList<AppartenirPromotion> getPromo() {
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
    
    public static ArrayList getAll() {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM eleve";
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
    
    public static ArrayList getByNom(String nom) {
        ArrayList tab = new ArrayList();
        try {
            String sql = "SELECT * "
                    + "FROM eleve, choisirfiliere, utilisateur "
                    + "WHERE eleve.id = utilisateur.id "
                    + "AND eleve.id = choisirfiliere.id "
                    + "AND utilisateur.nom ='"+nom+"' "
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
    
    public static ArrayList getByPromo(String promo) {
        ArrayList tab = new ArrayList();
        Promotion promotion = Promotion.getByLibelle(promo);
        try {
            String sql = "SELECT * "
                    + "FROM eleve, choisirfiliere, utilisateur, appartenirpromotion "
                    + "WHERE eleve.id = utilisateur.id "
                    + "AND eleve.id = choisirfiliere.id "
                    + "AND eleve.id = appartenirpromotion.id_Utilisateur "
                    + "AND appartenirpromotion.id = "+promotion.getId()+" "
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
    
    public static ArrayList getByFiliere(String filiere) {
        ArrayList tab = new ArrayList();
        Filiere fil = Filiere.getByLibelle(filiere);
        try {
            String sql = "SELECT * "
                    + "FROM eleve, choisirfiliere, utilisateur, appartenirpromotion "
                    + "WHERE eleve.id = utilisateur.id "
                    + "AND eleve.id = choisirfiliere.id "
                    + "AND choisirfiliere.id_Filiere = "+fil.getId()+" "
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
    
    public static ArrayList getByFilierePromo(String filiere, String promotion) {
        ArrayList tab = new ArrayList();
        Filiere fil = Filiere.getByLibelle(filiere);
        Promotion promo = Promotion.getByLibelle(promotion);
        try {
            String sql = "SELECT * "
                    + "FROM eleve, choisirfiliere, utilisateur, appartenirpromotion "
                    + "WHERE eleve.id = utilisateur.id "
                    + "AND eleve.id = choisirfiliere.id "
                    + "AND eleve.id = appartenirpromotion.id_Utilisateur "
                    + "AND choisirfiliere.id_Filiere = "+fil.getId()+" "
                    + "AND appartenirpromotion.id = "+promo.getId()+" "
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

    public static Eleve getById(int id) {
        Eleve obj = new Eleve();
        try {
            String sql = "SELECT * "
                    + "FROM eleve "
                    + "WHERE id = " + id;
            ResultSet rs = ConnexionParametres.requeter(sql);
            if (rs != null) {
                while (rs.next()) {
                    obj.setUser(Utilisateur.getById(rs.getInt("id")));
                    obj.setFiliere(ChoisirFiliere.getByUtilisateur(rs.getInt("id")));
                    obj.setPromo(AppartenirPromotion.getByUtilisateur(rs.getInt("id")));
                    obj.setAge(rs.getInt("age"));
                    obj.setNumRue(rs.getInt("numRue"));
                    obj.setLibelleRue(rs.getString("libelleRue"));
                    obj.setVille(rs.getString("ville"));
                    obj.setCodePostal(rs.getInt("codePostal"));
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

    public static boolean supprimerEleve(int id) {
        boolean ok = false;
        try {
            String sql = "DELETE FROM eleve "
                    + "WHERE id = " + id;
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

    public static boolean ajouterEleve(int age, int numero, String rue,
            String ville, int CP, int user) {
        boolean ok = false;
        try {
            String sql = "INSERT INTO eleve "
                    + "VALUES (" + age + "," + numero + ",'" + rue + "',"
                    + "'" + ville + "'," + CP + "," + user + ")";
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
    
    public static boolean ajouterEleve(int user) {
        boolean ok = false;
        try {
            String sql = "INSERT INTO eleve (id) "
                    + "VALUES (" + user + ")";
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
    
    public static boolean modifierEleve(int id, int age, int numRue, int cp,
            String nomRue, String ville, String nom, String prenom) {
        boolean ok = false;
        try {
            String sql = "UPDATE utilisateur"
                    + " SET nom = '"+nom+"',"
                    + " prenom = '"+prenom+"'"
                    + " WHERE id = "+id;
            if (ConnexionParametres.executer(sql)) {
                String sql2 = "UPDATE eleve"
                        + " SET age = "+age+","
                        + " numRue = "+numRue+","
                        + " codePostal = "+cp+","
                        + " libelleRue = '"+nomRue+"',"
                        + " ville = '"+ville+"'"
                        + " WHERE id = "+id;
                if (ConnexionParametres.executer(sql2)) {
                    ok = true;
                }
            };
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return ok;
    }

    public static void main(String[] args) {
        Eleve eleve = new Eleve();
        ArrayList<Eleve> tab = new ArrayList<Eleve>();
        tab = Eleve.getByPromo("2017");
        System.out.println(tab);
        for (Eleve x : tab){
            System.out.println(x.getUser().getNom());
        }
        
        
    }
}
