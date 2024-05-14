package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deadline.destroers.intellilearn.dto.SubjectDto;
import ru.deadline.destroers.intellilearn.entities.Subject;
import ru.deadline.destroers.intellilearn.repositories.SubjectRepository;
import ru.deadline.destroers.intellilearn.services.impl.SubjectServiceImpl;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectServiceImpl subjectService;
    private final ModelMapper modelMapper;
    private final SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        Subject subject = subjectService.createSubject(modelMapper.map(subjectDto,Subject.class));
        return ResponseEntity.ok(modelMapper.map(subject,SubjectDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateSubject(@RequestBody SubjectDto subjectDto) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectDto.getId());
        if (optionalSubject.isEmpty()) {
            throw new NoSuchElementException("Status with such id does not exist");
        }
        Subject subjectToUpdate= modelMapper.map(subjectDto, Subject.class);
        Subject updatedSubject = subjectRepository.save(subjectToUpdate);
        return ResponseEntity.ok(modelMapper.map(updatedSubject, SubjectDto.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable Long id) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        return subjectOptional.map(subject -> ResponseEntity
                .ok(modelMapper.map(subject, SubjectDto.class))).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable Long id) {
        subjectRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
