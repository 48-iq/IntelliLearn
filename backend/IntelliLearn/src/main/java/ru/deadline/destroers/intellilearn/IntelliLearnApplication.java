package ru.deadline.destroers.intellilearn;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.deadline.destroers.intellilearn.entities.Group;
import ru.deadline.destroers.intellilearn.repositories.GroupRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class IntelliLearnApplication {
    private final GroupRepository groupRepository;

    public static void main(String[] args) {
        SpringApplication.run(IntelliLearnApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Group group = Group.builder()
                        .name("б1-ГРУП-" + i%2 + "" + i%4)
                        .build();
                groupRepository.save(group);
            }
        };
    }

}
