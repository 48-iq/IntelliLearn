package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Status;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.StatusRepository;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.StatusService;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    @Override
    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void pinStatusToUser(Long statusId, Long userId) {
        User user=userRepository.findById(userId).orElseThrow();
        if(user.getPostedStatusList()==null){
            user.setPostedStatusList(new ArrayList<>());
        }
        if(user.getPostedStatusList().stream().noneMatch((status)->status.getId().equals(statusId))){
            user.getPostedStatusList().add(statusRepository.findById(statusId).orElseThrow());
        }
    }

    @Override
    public void unpinStatusFromUser(Long statusId, Long userId) {
        User user=userRepository.findById(userId).orElseThrow();
        if(user.getPostedStatusList()==null){
            user.setPostedStatusList(new ArrayList<>());
        }
        if(user.getPostedStatusList().stream().anyMatch((status)->status.getId().equals(statusId))){
            user.getPostedStatusList().remove(statusRepository.findById(statusId).orElseThrow());
        }
    }

    @Override
    public void deleteStatus(Long statusId) {
        statusRepository.deleteById(statusId);
    }

    @Override
    public List<Status> getAllUsersStatuses(Long userId) {
        return statusRepository.findByOwnerId(userId);
    }
}
