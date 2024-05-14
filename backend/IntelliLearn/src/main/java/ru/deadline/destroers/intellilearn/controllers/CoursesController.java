package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deadline.destroers.intellilearn.dto.CourseDto;
import ru.deadline.destroers.intellilearn.entities.Course;
import ru.deadline.destroers.intellilearn.services.interfaces.CoursesService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {
    private final CoursesService coursesService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(coursesService.getAllCourses()
                .stream().map(course -> modelMapper.map(course, CourseDto.class)).toList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String name) {
        return ResponseEntity.ok(modelMapper.map(coursesService.getCourseByName(name), CourseDto.class));
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        course = coursesService.createCourse(course);
        return ResponseEntity.ok(modelMapper.map(course, CourseDto.class));
    }

    @PutMapping
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        course = coursesService.updateCourse(course);
        return ResponseEntity.ok(modelMapper.map(course, CourseDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {

        coursesService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }


}
