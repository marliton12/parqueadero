package com.marlon.parking.service.Implementation;

import com.marlon.parking.Dto.responses.SpaceResponseDto;
import com.marlon.parking.Dto.responses.VehicleResponseDto;
import com.marlon.parking.Entity.Space;
import com.marlon.parking.Repository.SpaceRepository;
import com.marlon.parking.service.SpaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceServiceImp implements SpaceService {

    private final SpaceRepository repository;

    public SpaceServiceImp(SpaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SpaceResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(space -> new SpaceResponseDto(
                        space.getId(),
                        space.getCode(),
                        space.getType().name(),
                        space.getAvailable()
                ))
                .toList();
    }

    @Override
    public void disable(Long id) {
        Space space = repository.findById(id).get();
        space.setAvailable(false);
        repository.save(space);
    }

    @Override
    public void enable(Long id) {
        Space space = repository.findById(id).get();
        space.setAvailable(true);
        repository.save(space);
    }

    @Override
    public Space findById(Long id) {
        return repository.findById(id).get();
    }

}
