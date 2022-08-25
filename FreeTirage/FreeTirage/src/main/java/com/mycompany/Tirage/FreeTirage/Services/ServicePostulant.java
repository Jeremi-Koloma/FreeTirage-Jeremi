package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;

import java.util.List;

public interface ServicePostulant {
    // Ici on creer nos méthodes;

    // Une méthode qui va retouner un Postulant;
    Postulant creer (Postulant postulant);

    // Une méthode qui va retourner une Liste;
    List<Postulant> lire();

    // Une méthode qui va retourné un Postulant pour le Modifier; // ENTITY Name, Nom de la méthode, (ID, ENTITY)
    Postulant modifier (Long idPostulant, Postulant postulant);

    // Une méthode qui va retourné un STRING pour Suppression; // Avec l'ID ENTITY;
    String supprimer(Long idPostulant);

    // Une méthode pour trouver id postulant par liste;
    List<Postulant> TrouverIdPostList(long idListePost);
}
