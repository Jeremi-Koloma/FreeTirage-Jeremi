package com.mycompany.Tirage.FreeTirage.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // Notre ENTITY.;
@Table(name = "TIRAGE") // DOnner un nom à notre ENTITY au niveau de la base de donnée;
@Getter // Generer les Getters;
@Setter // Generer les Setters;
public class Tirage {
    @Id // notre id;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PRIMARY Key and Auto-Increment;
    private Long idTirage;

    @Column (length = 15)
    private String date;

    @Column(length = 100)
    private String libelle;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idListPost")
    private ListePostulant listePostulant;
}
