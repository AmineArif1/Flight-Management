package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "personne")
@Data @AllArgsConstructor @NoArgsConstructor
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CIN;
    private String Nom;
    private String Prenom;
    private Date Date_Naissance;
    private String username;
    private String Password;
    @ManyToMany(targetEntity = Role.class, cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
            name = "personne_role",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") }
    )
    private List<Role> roles;
    @OneToOne(mappedBy = "personne",cascade = CascadeType.ALL)
    private Client client;
    @OneToOne(mappedBy = "personne",cascade = CascadeType.ALL)
    private Employee employee;





}
