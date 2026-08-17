package org.stepbystep.stepbystep.model;

import java.util.List;

public record User(String id, String userName,List<Task> tasks) {
    public List<Task> getUncompletedTasks(){
        return tasks.stream().filter(task -> !task.isCompleted()).toList();
    }
}
