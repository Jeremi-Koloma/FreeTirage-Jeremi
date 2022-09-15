package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;

import java.util.List;

public interface ServiceListPostutant {
    // Ici on creer nos méthodes;

    // Une méthode qui va retouner une ListePostulant;
    ListePostulant creer (ListePostulant listePostulant);

    // Une méthode qui va retourner une ListePostulant;
    List<ListePostulant> lire();

    // Une méthode qui va retourné une ListePostulant pour le Modifier; // ENTITY Name, Nom de la méthode, (ID, ENTITY)
    ListePostulant modifier (Long idPostulant, ListePostulant listePostulant);

    // Une méthode qui va retourné un STRING pour Suppression; // Avec l'ID ENTITY;
    String supprimer(Long idListePostulant);

    // Une méthode permettant de trouver liste par libelle;
    ListePostulant trouverListeParLibelle(String libelle);
    int bb();
}
