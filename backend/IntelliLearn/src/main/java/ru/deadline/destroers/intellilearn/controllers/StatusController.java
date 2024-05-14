package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deadline.destroers.intellilearn.dto.StatusDto;
import ru.deadline.destroers.intellilearn.entities.Status;
import ru.deadline.destroers.intellilearn.repositories.StatusRepository;
import ru.deadline.destroers.intellilearn.services.impl.StatusServiceImpl;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {

    private final StatusServiceImpl statusService;
    private final ModelMapper modelMapper;
    private final StatusRepository statusRepository;

    @PostMapping
    public ResponseEntity<StatusDto> createStatus(@RequestBody StatusDto statusDto) {
        Status status = statusService.createStatus(modelMapper.map(statusDto, Status.class));
        return ResponseEntity.ok(modelMapper.map(status, StatusDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDto> updateStatus(@RequestBody StatusDto statusDto) {
        Optional<Status> optionalStatus = statusRepository.findById(statusDto.getId());
        if (optionalStatus.isEmpty()) {
            throw new NoSuchElementException("Status with such id does not exist");
        }
        Status statusToUpdate = modelMapper.map(statusDto, Status.class);
        Status updatedStatus = statusRepository.save(statusToUpdate);
        return ResponseEntity.ok(modelMapper.map(updatedStatus,StatusDto.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> getStatusById(@PathVariable Long id) {
        Optional<Status> statusOptional = statusRepository.findById(id);
        return statusOptional.map(status -> ResponseEntity
                .ok(modelMapper.map(status, StatusDto.class))).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatusById(@PathVariable Long id) {
        statusRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
