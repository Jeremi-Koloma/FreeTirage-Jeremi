package com.mycompany.Tirage.FreeTirage.Repository;

import com.mycompany.Tirage.FreeTirage.Modeles.ShortList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

// Cette classe va étendre de l'interface JPA Repository avec avec ENTITY <ShortList, id>;
public interface RepositoryShortList extends JpaRepository<ShortList, Long> {
    // Insertion des postulant dans la table ShortList dans la base de donnée;
    @Modifying
    @Transactional
    @Query(value="INSERT INTO shortlist(id_short_list,email,nom,prenom,numero,id_triage)VALUES(?,?,?,?,?,?)",nativeQuery = true)
    public int INSERTPOSTTIRE(long idShortList,String email,String nom,String prenom,String numero, long idTriage);

    @Query(value = "SELECT * FROM shortlist,tirage WHERE tirage.id_tirage=shortlist.id_short_list and tirage.libelle=:libelle",nativeQuery = true)
    public Iterable<ShortList> lirePostulantTireparnom(String libelle);


}