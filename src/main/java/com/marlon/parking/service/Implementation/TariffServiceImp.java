package com.marlon.parking.service.Implementation;

import com.marlon.parking.Entity.Tariff;
import com.marlon.parking.Entity.VehicleType;
import com.marlon.parking.Exception.TariffNotFoundException;
import com.marlon.parking.Repository.TariffRepository;
import com.marlon.parking.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TariffServiceImp implements TariffService {

    private final TariffRepository tariffRepository;

    @Override
    public Tariff findByType(VehicleType type) {
        return tariffRepository.findByType(type).orElseThrow(TariffNotFoundException::new);
    }
}
