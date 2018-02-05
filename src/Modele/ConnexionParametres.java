/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Cécile
 */
public class ConnexionParametres {
    private String nomUtilisateur;
    private String motDePasse;
    private String serveurBD;
    private String driverSGBD; 

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getServeurBD() {
        return serveurBD;
    }

    public void setServeurBD(String serveurBD) {
        this.serveurBD = serveurBD;
    }

    public String getDriverSGBD() {
        return driverSGBD;
    }

    public void setDriverSGBD(String driverSGBD) {
        this.driverSGBD = driverSGBD;
    }

    public ConnexionParametres() {
        nomUtilisateur = "root";
        motDePasse = "root";
        driverSGBD = "com.mysql.jdbc.Driver";
        serveurBD = "jdbc:mysql://localhost/cse";
    }
    
    
}
