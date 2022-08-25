package com.mycompany.Tirage.FreeTirage.Controllers;

import com.mycompany.Tirage.FreeTirage.Modeles.ShortList;
import com.mycompany.Tirage.FreeTirage.Services.ServiceShortList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Identifier la classe comme un Controller;
@RequestMapping("/shortList") // le nom du Path ou pour le Navigateur;
@Data
@AllArgsConstructor // Un constructeur avec tous les arguments pour l'injection de notre ServiceShortList;
public class ControllerShortList {
    // injection de notre ServiceShortList;
    private final ServiceShortList serviceShortList;

    // Controller pour méthode Lire ou Afficher la ShortList;
    @GetMapping("/read")
    public List<ShortList> read(){ // pour une requête de type (GET)
        return serviceShortList.lire();
    }

    // Controller pour la méthode Supprimer la ShortList;
    @DeleteMapping("/delete/{idShortList}")
    public String delete(@PathVariable Long idShortList){ // public String, nom methode, avec param(Id Entity)
        return serviceShortList.supprimer(idShortList);
    }
}
