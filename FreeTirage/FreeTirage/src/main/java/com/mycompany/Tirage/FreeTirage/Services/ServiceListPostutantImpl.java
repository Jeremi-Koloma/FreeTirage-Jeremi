package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;
import com.mycompany.Tirage.FreeTirage.Repository.RepositoryListPostulant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

// Cette classe va implémenter l'interface ServicePostulant pour les méthodes;
@Service // On identifie la classe comme étant un service métier;
@Data
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injection de notre RepositoryPostulant;
public class ServiceListPostutantImpl implements ServiceListPostutant {
    // Injectons notre repositoryPostulant;
    private final RepositoryListPostulant repositoryListPostulant;

    // On implémente nos 04 méthodes; // Méthode CREATE
    @Override
    public ListePostulant creer(ListePostulant listepostulant) { // pour la persistance des données dans la base de donnée;
        return repositoryListPostulant.save(listepostulant); // méthode (Save) pour enregristement dans la base de donnée;
    }

    @Override   // Méthode READ
    public List<ListePostulant> lire() { // la méthode (findAll) pour la lecture ou liste des postulants;
        return repositoryListPostulant.findAll();
    }

    @Override // Méthode UPDATE
    public ListePostulant modifier(Long idListPostulant, ListePostulant listepostulant) {
        return repositoryListPostulant.findById(idListPostulant) // Cherchons par ID si on trouve,
                .map(p->{ // Si on trouve, on fait le mappage
                    p.setDate(listepostulant.getDate());
                    p.setLibelle(listepostulant.getLibelle());
                    return repositoryListPostulant.save(p);
                }).orElseThrow(()-> new RuntimeException("ListePostulant non trouvé !"));
    }

    @Override // Méthode DELETE
    public String supprimer(Long idListePostulant) {
        repositoryListPostulant.deleteById(idListePostulant); // Supprimer l'ID;
        return "ListePostulant Supprimer !";
    }

    @Override
    public ListePostulant trouverListeParLibelle(String libelle) {
        return repositoryListPostulant.findByLibelle(libelle);
    }
}
