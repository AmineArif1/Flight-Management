package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "vol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVol;
    private Date dateArrivee;
    private  Date dateDepart;
    private String volName;
    @OneToMany(mappedBy = "vol")
    private Collection<Avion> avion;

}
