package com.ensamvol.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ville")
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idville;
	@Column(unique = true)
    private String villeName;
	@OneToMany(mappedBy = "ville")
	private Collection<Aeroport> aeroport;
	public Integer getIdville() {
		return idville;
	}
	public void setIdville(Integer idville) {
		this.idville = idville;
	}
	public String getVilleName() {
		return villeName;
	}
	public void setVilleName(String villeName) {
		this.villeName = villeName;
	}
	public Collection<Aeroport> getAeroport() {
		return aeroport;
	}
	public void setAeroport(Collection<Aeroport> aeroport) {
		this.aeroport = aeroport;
	}

}
