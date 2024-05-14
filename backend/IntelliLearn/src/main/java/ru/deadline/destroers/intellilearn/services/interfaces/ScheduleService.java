package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.GroupScheduleDay;
import ru.deadline.destroers.intellilearn.entities.LectorScheduleDay;

import java.util.List;

public interface ScheduleService {
    public List<GroupScheduleDay> getGroupSchedule();
    public List<LectorScheduleDay> getLectorSchedule();
}
