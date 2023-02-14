package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompany;
    @Column(unique = true)
    private String companyName;
    @OneToMany(mappedBy = "company")
    private Collection<Avion> avion;

	public Company() {
		super();
	}
	public Company(Integer idCompany, String companyName, Collection<Avion> avion) {
		super();
		this.idCompany = idCompany;
		this.companyName = companyName;
		this.avion = avion;
	}
	public Integer getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Collection<Avion> getAvion() {
		return avion;
	}
	public void setAvion(Collection<Avion> avion) {
		this.avion = avion;
	}




}
