package com.ensamvol.entities;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;

import lombok.*;

@Entity
@AllArgsConstructor 
@NoArgsConstructor
@Table(name="aeroport")
public class Aeroport {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idAeroport;
@ManyToOne
@JoinColumn(name="id_ville")
private Ville ville; 

}
