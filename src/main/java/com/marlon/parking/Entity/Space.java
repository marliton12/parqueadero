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
@Table(name = "espacios")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_espacio", nullable = false)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String code;

    @Column(name = "tipo", nullable = false)
    private VehicleType type;

    @Column(name = "disponible", nullable = false)
    private Boolean available;

    @ManyToOne()
//    @JoinColumn(name = "id_espacio")
    private Register register;
}
