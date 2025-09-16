package com.marlon.parking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculos")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo", nullable = false)
    private Long id;

    @Column(name = "placa", nullable = false)
    private String plate;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private VehicleType type;

    @Column(name = "color", nullable = false)
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;
}
