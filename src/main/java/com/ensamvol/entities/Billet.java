package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "billet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idBillet;
    private double billetPrix;
    @ManyToOne
    private Client client;
    @ManyToOne
    private vol vole;

}
