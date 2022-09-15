package com.mycompany.Tirage.FreeTirage.Repository;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


// Cette classe va étendre de l'interface JPA Repository avec avec ENTITY <ListePostulant, id>;
public interface RepositoryListPostulant extends JpaRepository<ListePostulant,Long> {
    //
    ListePostulant findByLibelle(String libelle);

    @Query(value = "SELECT COUNT(*)FROM listepostulant",nativeQuery = true)
    int obdd();

}
