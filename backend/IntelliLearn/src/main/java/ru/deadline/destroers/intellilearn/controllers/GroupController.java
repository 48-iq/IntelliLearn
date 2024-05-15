package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deadline.destroers.intellilearn.dto.GroupDto;
import ru.deadline.destroers.intellilearn.dto.UserDto;
import ru.deadline.destroers.intellilearn.repositories.GroupRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
    private final GroupRepository groupRepository;

    @GetMapping("")
    public ResponseEntity<List<GroupDto>> getGroups() {

        List<GroupDto> groupDtos = groupRepository.findAll().stream().map(group -> GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .students(group.getStudents().stream()
                        .map((student) -> UserDto.builder()
                                .id(student.getId())
                                .groupName(group.getName())
                                .username(student.getUsername())
                                .password(student.getPassword())
                                .role(student.getRole())
                                .build()).toList()
                ).build()).toList();

        return ResponseEntity.ok(groupDtos);
    }
}
