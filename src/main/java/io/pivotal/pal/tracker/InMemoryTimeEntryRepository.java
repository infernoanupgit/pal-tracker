package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    List<TimeEntry> list = new ArrayList<>();
    Long currId = 1L;


    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry createdTimeEntry = new TimeEntry(currId++, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        list.add(createdTimeEntry);

        return createdTimeEntry;
    }



    public TimeEntry find(long id) {

        for (TimeEntry timeEntry:
        list) {
            if (timeEntry.getId() == id){
                return timeEntry;
            }
        }

       return null;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        for (TimeEntry timeEntryIn:
                list) {
            if (timeEntryIn.getId() == id){
                timeEntryIn.setDate(timeEntry.getDate());
                timeEntryIn.setHours(timeEntry.getHours());
                timeEntryIn.setProjectId(timeEntry.getProjectId());
                timeEntryIn.setUserId(timeEntry.getUserId());

                return timeEntryIn;
            }
        }
        return null;
    }


    public void delete(long id) {
        for (TimeEntry timeEntryIn:
                list) {
            if (timeEntryIn.getId() == id){

                list.remove(timeEntryIn);
                break;
            }
        }
    }

    public List<TimeEntry> list() {

        return list;
    }
}
