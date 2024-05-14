package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Direction;

import java.util.List;

public interface DirectionService {
    Direction getDirection(Long id);
    Direction createDirection(Direction direction);
    Direction updateDirection(Direction direction);
    void deleteDirection(Long directionId);
    List<Direction> getAllDirections();
    Direction getDirectionByName(String directionName);
}
