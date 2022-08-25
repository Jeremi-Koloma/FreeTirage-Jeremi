package com.mycompany.Tirage.FreeTirage.Services;

import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;
import com.mycompany.Tirage.FreeTirage.Repository.RepositoryTirage;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Cette classe va implémenter l'interface ServicePostulant pour les méthodes;
@Data
@Service // On identifie la classe comme étant un service métier;
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injection de notre RepositoryPostulant;
public class ServiceTirageImpl implements ServiceTirage {
    // Injectons notre repositoryPostulant;
    private final RepositoryTirage repositoryTirage;
    // On implémente nos méthodes;

    @Override
    public  List<Postulant>  creeer(Tirage tirage, List<Postulant> listAtrier, long nbre) {
        // une instance de Random qui va nous donner des nombres aleatoires;
        Random rand = new Random();
        // on prend la liste des postulant on donne un aleas
        List<Postulant> list = new ArrayList<>();
        // On fait une boucle pour parcourir toute la liste;
        for (int i=0; i<nbre;i++)
        {
            // ici on convertie le Random en Int de 1 à la limite de liste à trier;
            Integer idActuel = rand.nextInt(listAtrier.size());
            // On ajoute le postulant à l'ID qui a été générer par le Ramdom;
            list.add(listAtrier.get(idActuel));
            // Et après on supprime id de ce postulant de la liste;
            listAtrier.remove(listAtrier.get(idActuel));

        }
        repositoryTirage.save(tirage);
        return list;
    }

    @Override   // Implementation de la Méthode READ la liste des tirages éffectués;
    public List<Tirage> lire() { // la méthode (findAll) pour la lecture ou liste des postulants;
        return repositoryTirage.findAll();
    }

    @Override
    public Tirage trouverTirageParLibelle(String libelle) {
        return repositoryTirage.findByLibelle(libelle);
    }


}
