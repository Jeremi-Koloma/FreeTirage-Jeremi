package com.mycompany.Tirage.FreeTirage.Controllers;

import com.mycompany.Tirage.FreeTirage.Modeles.Excel;
import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import com.mycompany.Tirage.FreeTirage.Services.ServiceListPostutant;
import com.mycompany.Tirage.FreeTirage.Services.ServicePostulant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController // Identifier la classe comme un Controller;
@CrossOrigin("*") // FrontEnd
@RequestMapping("/postulant") // le nom du Path ou pour le Navigateur;
@Data
@AllArgsConstructor // Un constructeur avec tous les arguments pour l'injection de notre ServicePostulants;
public class ControllerPostulant {
    // injection de notre ServicePostulant;
    private final ServicePostulant servicePostulant;
    private final ServiceListPostutant serviceListPostutant;

    // Controller pour la méthode Ajouter;
    @PostMapping("/create") // Pour une requête de type (POST) // public ENTITY avec param (ENTITY entity)
    public Postulant create(@RequestBody Postulant postulant){ // pour envoyé de donné de body dans l'Entity;
        return servicePostulant.creer(postulant);
    }

     //Controller pour méthode Lire;
     @GetMapping("/read")
        public List<Postulant> read(){ // pour une requête de type (GET)
            return servicePostulant.lire();
        }

    // Controller pour la méthode Modifier;
    @PutMapping("/update/{idPostulant}")
    public Postulant update(@PathVariable Long idPostulant, @RequestBody Postulant postulant){ // public Entity, un Nom de méthode, avec par (ID Entity, ENTITY entity)
        return servicePostulant.modifier(idPostulant, postulant); // idEntity et Entity;
    }

    // Controller pour la méthode Supprimer;
    @DeleteMapping("/delete/{idPostulant}")
    public String delete(@PathVariable Long idPostulant){ // public String, nom methode, avec param(Id Entity)
        return servicePostulant.supprimer(idPostulant);
    }

    @PostMapping("listePostulant/{libelle}")
    @ResponseBody
    public List<Postulant> list(@RequestParam("file") MultipartFile file, ListePostulant liste, String libelle) throws InterruptedException {

        List<Postulant> postulants = Excel.postulantsExcel(file);

        liste.setDate(new Date());
        ListePostulant l = serviceListPostutant.creer(liste);
        for (Postulant p: postulants){
            p.setListePostulant(l);
            servicePostulant.creer(p);
        }

        return Excel.postulantsExcel(file);
    }

}
