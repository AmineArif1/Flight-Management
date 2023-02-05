package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    private double numBages;
    private double numPassenger;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Vol vol;


}
