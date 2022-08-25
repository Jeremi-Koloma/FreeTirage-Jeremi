package com.mycompany.Tirage.FreeTirage.Repository;

import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

// Cette classe va étendre de l'interface JPA Repository avec avec ENTITY <Tirage, id>;
public interface RepositoryTirage extends JpaRepository<Tirage, Long> {
    Tirage findByLibelle(String libelle);
}
