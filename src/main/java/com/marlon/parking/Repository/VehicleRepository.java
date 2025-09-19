package com.marlon.parking.Repository;

import com.marlon.parking.Entity.User;
import com.marlon.parking.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE v.plate = :plate")
    Optional<Vehicle> findByPlate(String plate);

    void deleteByPlate(String plate);

}
