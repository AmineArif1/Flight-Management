package com.ensamvol.entities;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer idReservation;
@ManyToOne
@JoinColumn(name="id_client")
private Client client; 

}
