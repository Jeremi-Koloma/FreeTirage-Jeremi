package com.mycompany.Tirage.FreeTirage.Repository;

import com.mycompany.Tirage.FreeTirage.Modeles.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Cette classe va étendre de l'interface JPA Repository avec avec ENTITY <Postulant, id>;
public interface RepositoryPostulant extends JpaRepository<Postulant, Long> {
    @Query(value = "SELECT * FROM postulant where id_liste_post=:id_liste_post",nativeQuery = true)
    public List<Postulant> FINDIDPOSTLIST(@Param("id_liste_post") long id_liste_post);

    @Query(value = "DELETE * from postulant where id_liste_post =:idListePost",nativeQuery = true)
    String supp(@PathVariable Long idListePost);
}
