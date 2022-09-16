package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import com.mycompany.Tirage.FreeTirage.Modeles.ShortList;
import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;

import java.util.List;

public interface ServiceShortList {
    // Ici on creer nos méthodes;

    // Une méthode qui va retourner une ShortList;
    List<ShortList> lire();

    // Une méthode qui va retourné un STRING pour Suppression de la ShortList; // Avec l'ID ENTITY;
    String supprimer(Long idShortList);

    Tirage trouverTirageParLibelle(String libelle);

    // Une méthode qui va nous permettre de creer une short liste;
    int creer(long idShortList, String email,String nom, String prenom,String numero, long id_tirage);

    Iterable <ShortList> lirePostulantTireparnom(String libelle);
    List <ShortList> lireP(Long libelle);

    //Nombre postulants;
    List<Object> nbrePost(Long nbrPos);

}
