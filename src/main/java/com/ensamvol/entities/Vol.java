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
    private String dateArrivee;
    private  String dateDepart;
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
	public Long getIdVol() {
		return idVol;
	}
	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}
	public String getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getVolName() {
		return volName;
	}
	public void setVolName(String volName) {
		this.volName = volName;
	}
	public String getVolImage() {
		return volImage;
	}
	public void setVolImage(String volImage) {
		this.volImage = volImage;
	}
	public String getVolDescription() {
		return volDescription;
	}
	public void setVolDescription(String volDescription) {
		this.volDescription = volDescription;
	}
	public Long getVolPrix() {
		return volPrix;
	}
	public void setVolPrix(Long volPrix) {
		this.volPrix = volPrix;
	}
	public Collection<Avion> getAvion() {
		return avion;
	}
	public void setAvion(Collection<Avion> avion) {
		this.avion = avion;
	}
	public Ville getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}
	public Ville getVilleArrive() {
		return villeArrive;
	}
	public void setVilleArrive(Ville villeArrive) {
		this.villeArrive = villeArrive;
	}


}
