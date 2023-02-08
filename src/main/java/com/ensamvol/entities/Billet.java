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
    private  Integer idBillet;
    private double billetPrix;
    private double numPassenger;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne(cascade = CascadeType.ALL)
    private Vol vol;


}
