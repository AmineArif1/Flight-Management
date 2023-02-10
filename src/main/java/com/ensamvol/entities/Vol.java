package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private String dateArrivee;
    private String dateDepart;
    private String volName;
    private String volImage;
    private String volDescription;
    private Long volPrix;
    @OneToMany(mappedBy = "vol")
    private Collection<Avion> avion;
    @OneToOne
    private Ville villeDepart;
    @OneToOne
    private Ville villeArrive;


}
