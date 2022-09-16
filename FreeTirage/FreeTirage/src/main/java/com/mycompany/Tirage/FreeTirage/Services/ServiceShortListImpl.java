package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.ShortList;
import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;
import com.mycompany.Tirage.FreeTirage.Repository.RepositoryShortList;
import com.mycompany.Tirage.FreeTirage.Repository.RepositoryTirage;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;

// Cette classe va implémenter l'interface ServiceShortList pour les méthodes;
@Service // On identifie la classe comme étant un service métier;
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injection de notre RepositoryShortList;
@Data
public class ServiceShortListImpl implements ServiceShortList {
    // Injectons notre repositoryShortList;
    private final RepositoryShortList repositoryShortList;
    private final RepositoryTirage repositoryTirage;
    // On implémente nos méthodes;

    @Override   // implementation de la Méthode READ ou Afficher la ShortList
    public List<ShortList> lire() { // la méthode (findAll) pour la lecture ou liste des shortLists;
        return repositoryShortList.findAll();
    }

    @Override // implementation de la Méthode DELETE la ShortList
    public String supprimer(Long idShortList) {
        repositoryShortList.deleteById(idShortList); // Supprimer l'ID;
        return "ShortList Supprimer !";
    }


    @Override // implementation de la méthode trouverTirageparLibelle;
    public Tirage trouverTirageParLibelle(String libelle) {
        return repositoryTirage.findByLibelle(libelle);
    }

    @Override // implementation de la methode creer shortList;
    public int creer(long idShortList, String nom, String prenom, String numero, String email, long idTirage) {
        return repositoryShortList.INSERTPOSTTIRE(idShortList,nom,prenom,numero,email,idTirage);
    }

    @Override // implementation de la méthode lirePostulantTireparnom;
    public Iterable<ShortList> lirePostulantTireparnom(String libelle) {
        return repositoryShortList.lirePostulantTireparnom(libelle);
    }

    @Override
    public List<ShortList> lireP(Long libelle) {
        return repositoryShortList.lirePostulant(libelle);
    }

    @Override
    public List<Object> nbrePost(Long nbrPos) {
        return repositoryShortList.nombrePost(nbrPos);
    }


}
