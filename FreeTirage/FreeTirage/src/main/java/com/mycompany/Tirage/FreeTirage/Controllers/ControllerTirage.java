package com.mycompany.Tirage.FreeTirage.Controllers;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;
import com.mycompany.Tirage.FreeTirage.Repository.RepositoryListPostulant;
import com.mycompany.Tirage.FreeTirage.Services.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController // Identifier la classe comme un Controller;
@RequestMapping("/tirage") // le nom du Path ou pour le Navigateur;
@Data
@AllArgsConstructor // Un constructeur avec tous les arguments pour l'injection de notre ServicePostulants;
public class ControllerTirage {
    // injection de notre ServicePostulant;
    private final ServiceTirage serviceTirage;

    // Controller pour la méthode qui va Afficher la liste des tirages effectués;
    @GetMapping("/read")
    public List<Tirage> read(){ // pour une requête de type (GET)
        return serviceTirage.lire();
    }

    // Injections de nos Services
    private final ServiceListPostutant serviceListPostutant;
    private final ServicePostulant servicePostulant;
    private final ServiceShortList serviceShortList;

    private final RepositoryListPostulant repositoryListPostulant;

    // Controller pour faire le Tirage;
    @PostMapping(value = "/createTirage/{libelle}/{nbre}")
    //@RequestBoby pour recupérer le texte qui sera dans le boby et l'envoyer dans la base de donnée;
    // @PathVariable pour la valeur qui sera dans l'URL;
    public Object create(@RequestBody Tirage tirage, @PathVariable String libelle, @PathVariable long nbre){
        // on appel notre méthode trouvertirageparlibelle;
        if (serviceTirage.trouverTirageParLibelle(tirage.getLibelle()) == null) {
            // on appel on méthode trouver liste par libelle;
        ListePostulant liste = serviceListPostutant.trouverListeParLibelle(libelle);

        tirage.setListePostulant(liste);

            // on appel on méthode trouver idPostulant par liste ;
        List<Postulant> post = servicePostulant.TrouverIdPostList(liste.getIdListePostulant());
        // On appel la méthode qui va nous permettre de faire le tirage;
        List<Postulant> lp = serviceTirage.creeer(tirage,post,nbre);
        // Notre id tirage de type Long recevera comme valeur (trouverTirageParLibele)
        Long idTirage =serviceTirage.trouverTirageParLibelle(tirage.getLibelle()).getIdTirage();
            // on fait une boucle sur la liste;
            for (Postulant p :lp){
                // on appel notre méthode qui nous permet de créer notre short liste;
                serviceShortList.creer(p.getIdPostulant(),p.getEmail(),p.getNom(),p.getPrenom(),p.getNumero(),idTirage);
                // le postulant qui a été ajouté, on le supprime de la liste;
                servicePostulant.supprimer(p.getIdPostulant());
            }
            return "Tirage effectué avec succès ! \uD83D\uDE09 \uD83D\uDE09";
        }
        else {
            return "Ce tirage est déjà éffectuer !";
        }

    }
    @GetMapping("/reaf/{id}")
    public List<Tirage> li(@PathVariable Integer id){ // pour une requête de type (GET)
        return serviceTirage.tout(id);
    }
    @GetMapping("/vrai/{id}")
    public Object li(@PathVariable Long id){ // pour une requête de type (GET)

        ListePostulant listePostulant=repositoryListPostulant.findById(id).get();
        return serviceTirage.Faux(listePostulant);
    }
    @GetMapping("/cont")
    public int ov (){ // pour une requête de type (GET)
        return serviceTirage.aa();
    }
}
