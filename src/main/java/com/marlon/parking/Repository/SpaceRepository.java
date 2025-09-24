package com.marlon.parking.Repository;

import com.marlon.parking.Entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, Long> {
}
