package com.mycompany.Tirage.FreeTirage.Modeles;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // Identifier cette classe comme une ENTITY;
@Table(name = "POSTULANT") // Donner un Nom à notre ENTITY dans la base de donée;
@Getter // Générer les Getters;
@Setter // Génerer les setters;
public class Postulant {
    @Id // Identifier cette classe comme notre ID;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PRIAMARY key and Auto-incriment;
    private Long idPostulant;

    @Column(length = 30)
    private String nom;

    @Column(length = 30)
    private String prenom;

    @Column(length = 15)
    private String numero;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idListePost")
    private ListePostulant listePostulant;
}
