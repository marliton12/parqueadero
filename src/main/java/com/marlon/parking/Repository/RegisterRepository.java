package com.marlon.parking.Repository;

import com.marlon.parking.Entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegisterRepository extends JpaRepository<Register, Long> {

}
