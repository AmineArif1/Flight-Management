package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(unique = true)
    private String numPassport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="id_client")
    private Personne personne;
    @OneToMany(mappedBy = "client")
    private Collection<Billet> billet;
}
