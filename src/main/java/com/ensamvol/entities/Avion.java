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
	@ManyToMany(targetEntity=Vol.class, cascade = { CascadeType.ALL },fetch = FetchType.LAZY)
	 @JoinTable(
	            name = "vol_avion",
	            joinColumns = { @JoinColumn(name = "id_avion") },
	            inverseJoinColumns = { @JoinColumn(name = "id_vol") }
	    )
	private List<Vol> vol;
}
