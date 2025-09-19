package com.marlon.parking.service;

import com.marlon.parking.Entity.Tariff;
import com.marlon.parking.Entity.VehicleType;

import java.util.Optional;

public interface TariffService {
    Tariff findByType(VehicleType type);
}
