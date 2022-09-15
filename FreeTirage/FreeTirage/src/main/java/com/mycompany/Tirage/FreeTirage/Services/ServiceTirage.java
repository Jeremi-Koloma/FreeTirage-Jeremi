package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;

import java.util.List;

public interface ServiceTirage {
    // Ici on creer nos méthodes;

    // On retourne la liste des postulant pour faire le tirage;
    List<Postulant> creeer(Tirage tirage, List<Postulant> lp, long nbre );

    // Une méthode qui va retourner une liste des Tirages effectués;
    List<Tirage> lire();

    // une méthode qui permet de trouver tirage par libelle;
    Tirage trouverTirageParLibelle(String libelle);
    Long vrai(Long fr);
    Long  Faux(ListePostulant listePostulant);

    List<Tirage> tout(Integer id);
    int aa();
}
