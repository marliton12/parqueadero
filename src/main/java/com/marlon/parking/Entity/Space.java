package com.marlon.parking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private VehicleType type;

    @Column(name = "disponible", nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private List<Register> registers = new ArrayList<>();

    public Space(Long id) {
        this.id = id;
    }
}
