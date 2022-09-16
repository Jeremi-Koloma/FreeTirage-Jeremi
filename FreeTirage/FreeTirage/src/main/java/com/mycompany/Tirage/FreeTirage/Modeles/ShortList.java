package com.mycompany.Tirage.FreeTirage.Modeles;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // Definit comme ENTITY.
@Table(name = "SHORTLIST") // Donner un Nom au niveau de de la base de donnée;
@Getter // Generer les getters
@Setter // Générer les setters
public class ShortList {
    @Id // Generer notre id;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PRIMARY KEY Auto-Increment;
    private Long idShortList;

    @Column(length = 30)
    private String nom;

    @Column(length = 30)
    private String prenom;

    @Column(length = 15)
    private String numero;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idTriage")
    private Tirage tirage;

    public static class Postulant {
    }
}
