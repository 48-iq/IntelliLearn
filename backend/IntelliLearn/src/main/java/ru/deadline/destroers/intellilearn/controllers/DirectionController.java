package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deadline.destroers.intellilearn.dto.DirectionDto;
import ru.deadline.destroers.intellilearn.entities.Direction;
import ru.deadline.destroers.intellilearn.services.interfaces.DirectionService;

import java.util.List;

@RestController
@RequestMapping("/directions")
@RequiredArgsConstructor
public class DirectionController {
    private final DirectionService directionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Direction> getDirections() {
        return directionService.getAllDirections();
    }

    @GetMapping("/{name}")
    public ResponseEntity<DirectionDto> getDirection(@PathVariable String name) {
        return ResponseEntity.ok(modelMapper.map(directionService.getDirectionByName(name), DirectionDto.class));
    }

    @PostMapping
    public ResponseEntity<DirectionDto> addDirection(@RequestBody Direction direction) {
        return ResponseEntity.ok(modelMapper.map(directionService.createDirection(direction), DirectionDto.class));
    }

    @PutMapping
    public ResponseEntity<DirectionDto> updateDirection(@RequestBody Direction direction) {
        return ResponseEntity.ok(modelMapper.map(directionService.updateDirection(direction), DirectionDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirection(@PathVariable Long id) {
        directionService.deleteDirection(id);
        return ResponseEntity.ok().build();
    }
}
