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
	public int getIdBillet() {
		return idBillet;
	}
	public void setIdBillet(int idBillet) {
		this.idBillet = idBillet;
	}
	public double getBilletPrix() {
		return billetPrix;
	}
	public void setBilletPrix(double billetPrix) {
		this.billetPrix = billetPrix;
	}
	public double getNumBages() {
		return numBages;
	}
	public void setNumBages(double numBages) {
		this.numBages = numBages;
	}
	public double getNumPassenger() {
		return numPassenger;
	}
	public void setNumPassenger(double numPassenger) {
		this.numPassenger = numPassenger;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}


}
