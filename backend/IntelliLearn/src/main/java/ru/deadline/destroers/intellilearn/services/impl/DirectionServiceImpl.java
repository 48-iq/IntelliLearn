package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Direction;
import ru.deadline.destroers.intellilearn.repositories.DirectionRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.DirectionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {
    private final DirectionRepository directionRepository;
    @Override
    public Direction getDirection(Long id) {
        return directionRepository.findById(id).orElseThrow();
    }

    @Override
    public Direction createDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    @Override
    public Direction updateDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    @Override
    public void deleteDirection(Long id) {
        directionRepository.deleteById(id);
    }

    @Override
    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }

    @Override
    public Direction getDirectionByName(String directionName) {
        return directionRepository.findByName(directionName)
                .orElseThrow();
    }
}
