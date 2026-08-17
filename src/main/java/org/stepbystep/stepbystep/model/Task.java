package org.stepbystep.stepbystep.model;

import java.util.List;

public record Task(String id, String name, List<Step> steps) {
    public boolean isCompleted(){
        return this.steps.stream().allMatch(Step::isCompleted);
    }

    public float getCompletionPercentage(){
        if (steps.isEmpty()) return 0f;
        long completed = steps.stream().filter(Step::isCompleted).count();
        return (float) completed / steps.size() * 100;
    }
}
