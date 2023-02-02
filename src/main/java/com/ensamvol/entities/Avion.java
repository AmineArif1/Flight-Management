package com.ensamvol.entities;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Table(name="avion")
public class Avion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAvion;
	@ManyToOne
	private Vol vol;
	@ManyToOne
	@JoinColumn(name="idCompany")
	private Company company;
}

