package com.marlon.parking.Repository;

import com.marlon.parking.Entity.Tariff;
import com.marlon.parking.Entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TariffRepository  extends JpaRepository<Tariff, Long> {
    Optional<Tariff> findByType(VehicleType type);
}
