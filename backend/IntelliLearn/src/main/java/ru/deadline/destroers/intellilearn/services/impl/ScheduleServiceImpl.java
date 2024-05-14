package ru.deadline.destroers.intellilearn.services.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Group;
import ru.deadline.destroers.intellilearn.entities.GroupScheduleDay;
import ru.deadline.destroers.intellilearn.exceptions.NoSuchDocumentException;
import ru.deadline.destroers.intellilearn.exceptions.NoSuchGroupElement;
import ru.deadline.destroers.intellilearn.services.interfaces.ScheduleService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Value("${}")//дописать из проперти
    private String basedScheduleURL;
    public GroupScheduleDay getCurrentDaySchedule(Group group){
        Map<String,String> groupSchedule = allGroupsURL();
        if(!groupSchedule.containsKey(group.getName())){
            throw new NoSuchGroupElement("No such group name in the Map from parsed HTML");
        }
        //парсить расписание конкретного дня
        try {
            Document document = Jsoup.connect(groupSchedule.get(group.getName())).get();
            Elements currentDay = document.select("div.day.day-current");
            //дописать логику
        }
        catch (IOException e){
            throw new NoSuchDocumentException("No such document on this URL");
        }
    }
    private Map<String,String> allGroupsURL(){
        Map<String, String> groupInfo = new HashMap<>();
        try {
            Document document = Jsoup.connect(basedScheduleURL).get();
            Elements elements = document.select("div.col-auto.group");

            elements.forEach(groupDiv -> {
                Elements links = groupDiv.select("a");

                links.forEach(link -> {

                    String linkText = link.text();

                    String href = link.attr("href");

                    groupInfo.put(linkText, href);
                });
            });

        } catch (IOException e){
            throw new NoSuchDocumentException("No such document on this URL");
        }
        return groupInfo;
    }
}
