package com.mycompany.Tirage.FreeTirage.Controllers;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;
import com.mycompany.Tirage.FreeTirage.Services.ServiceListPostutant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController // Identifier la classe comme un Controller;
@RequestMapping("/listePostulant") // le nom du Path ou pour le Navigateur;*
@Data
@AllArgsConstructor // Un constructeur avec tous les arguments pour l'injection de notre ServiceListPostulants;
public class ControllerListPostulant {
    // injection de notre ServiceListePostulant;
    private final ServiceListPostutant serviceListPostutant;

    // Controller pour méthode Lire ou Afficher la liste des postulants;
    @GetMapping("/read")
    public List<ListePostulant> read(){ // pour une requête de type (GET)
        return serviceListPostutant.lire();
    }

    // Controller pour la méthode Modifier une liste de postulants;
    @PutMapping("/update/{idListePostulant}")
    public ListePostulant update(@PathVariable Long idListePostulant, @RequestBody ListePostulant listePostulant){ // public Entity, un Nom de méthode, avec par (ID Entity, ENTITY entity)
        return serviceListPostutant.modifier(idListePostulant, listePostulant); // idEntity et Entity;
    }

    // Controller pour la méthode Supprimer une liste de postulant;
    @DeleteMapping("/delete/{idListePostulant}")
    public String delete(@PathVariable Long idListePostulant){ // public String, nom methode, avec param(Id Entity)
        return serviceListPostutant.supprimer(idListePostulant);
    }
}
