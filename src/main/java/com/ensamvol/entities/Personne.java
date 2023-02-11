package com.ensamvol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "personne")
@Data @AllArgsConstructor @NoArgsConstructor
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CIN;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String username;
    private String password;
    @ManyToMany(targetEntity = Role.class, cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
            name = "personne_role",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") }
    )
    private List<Role> roles;
    @OneToOne(mappedBy = "personne",cascade = CascadeType.ALL)
    private Client client;
    @OneToOne(mappedBy = "personne",cascade = CascadeType.ALL)
    private Employee employee;
	public Integer getCIN() {
		return CIN;
	}
	public void setCIN(Integer cIN) {
		CIN = cIN;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}





}
