/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur.connexion;

import Modele.Bulletin;
import java.util.ArrayList;

/**
 *
 * @author Cécile
 */
public class RFAdministrateur {
    public static ArrayList listeBulletinByEtudiant(int id){
        return Bulletin.getByUtilisateur(id);
    }
}
