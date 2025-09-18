package com.marlon.parking.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "registros")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "id_espacio", nullable = false)
    private Space space;

    @Column(name = "hora_entrada", nullable = false)
    private LocalDateTime entryHour;

    @Column(name = "hora_salida", nullable = false)
    private LocalDateTime exitHour;

    @Column(name = "costo", nullable = false)
    private BigDecimal cost;

}

