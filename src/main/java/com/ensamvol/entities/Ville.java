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

}
