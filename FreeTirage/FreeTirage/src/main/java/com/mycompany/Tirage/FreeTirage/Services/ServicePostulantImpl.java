package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import com.mycompany.Tirage.FreeTirage.Repository.RepositoryPostulant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

// Cette classe va implémenter l'interface ServicePostulant pour les méthodes;
@Service // On identifie la classe comme étant un service métier;
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injection de notre RepositoryPostulant;
@Data
public class ServicePostulantImpl implements ServicePostulant {
    // Injectons notre repositoryPostulant;
    private final RepositoryPostulant repositoryPostulant;

    // On implémente nos 04 méthodes; // Méthode CREATE
    @Override
    public Postulant creer(Postulant postulant) { // pour la persistance des données dans la base de donnée;
        return repositoryPostulant.save(postulant); // méthode (Save) pour enregristement dans la base de donnée;
    }

    @Override   // Méthode READ
    public List<Postulant> lire() { // la méthode (findAll) pour la lecture ou liste des postulants;
        return repositoryPostulant.findAll();
    }

    @Override // Méthode UPDATE
    public Postulant modifier(Long idPostulant, Postulant postulant) {
        return repositoryPostulant.findById(idPostulant) // Cherchons par ID si on trouve,
                .map(p->{ // Si on trouve, on fait le mappage
                    p.setNom(postulant.getNom());
                    p.setPrenom(postulant.getPrenom());
                    p.setNumero(postulant.getNumero());
                    p.setEmail(postulant.getEmail());
                    return repositoryPostulant.save(p);
                }).orElseThrow(()-> new RuntimeException("Postulant non trouvé !"));
    }

    @Override // Méthode DELETE
    public String supprimer(Long idPostulant) {
        repositoryPostulant.deleteById(idPostulant); // Supprimer l'ID;
        return "Postulant Supprimer !";
    }

    @Override
    public List<Postulant> TrouverIdPostList(long idListePost) {
        return repositoryPostulant.FINDIDPOSTLIST(idListePost);
    }
}
