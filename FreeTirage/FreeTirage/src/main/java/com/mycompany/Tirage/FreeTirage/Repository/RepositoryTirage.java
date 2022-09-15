package com.mycompany.Tirage.FreeTirage.Repository;

import com.mycompany.Tirage.FreeTirage.Modeles.ListePostulant;
import com.mycompany.Tirage.FreeTirage.Modeles.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

// Cette classe va étendre de l'interface JPA Repository avec avec ENTITY <Tirage, id>;
public interface RepositoryTirage extends JpaRepository<Tirage, Long> {
    Tirage findByLibelle(String libelle);

    @Query(value = "select * from tirage WHERE tirage.id_list_post=:idliste",nativeQuery = true)
    List<Tirage> ok(int idliste);

    //    @Modifying
    @Query(value = "SELECT COUNT(*)  FROM tirage WHERE tirage.id_list_post=:list",nativeQuery = true)
    Long obd(Long list);
    @Query(value = " SELECT COUNT(*) FROM tirage",nativeQuery = true)
    int ob();
    List<Tirage> findByListePostulant(ListePostulant listePostulant);
}
