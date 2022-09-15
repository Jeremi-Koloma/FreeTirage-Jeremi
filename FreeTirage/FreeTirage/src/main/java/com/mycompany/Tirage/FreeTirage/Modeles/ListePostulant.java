package com.mycompany.Tirage.FreeTirage.Modeles;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity // Definit la classe comme ENTITY;
@Table(name = "LISTEPOSTULANT") // Donner un Nom à notre ENTITY dans la base de donnée;
@Getter // Génerer les getters;
@Setter // Génerer les setters;
@Data
public class ListePostulant {
    @Id // Définie cet attrubit comme ID;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PRIMARY Key et Auto-Increment;
    private Long idListePostulant;

    private Date date;

    @Column (length = 100)
    private String libelle;

    @OneToMany(mappedBy = "listePostulant")
    List<Tirage> tirages=new ArrayList<>();
}
