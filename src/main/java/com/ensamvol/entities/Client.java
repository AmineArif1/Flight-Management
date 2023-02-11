package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
    private List<Billet> billet;
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public String getNumPassport() {
		return numPassport;
	}
	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}
	public Personne getPersonne() {
		return personne;
	}
	
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public List<Billet> getBillets() {
		return billet;
	}
	public void setBillets(List<Billet> billet) {
		this.billet = billet;
	}

}
