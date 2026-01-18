package org.example.entity;

import java.util.Objects;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task>... taskSets) {
        this.annsTasks = taskSets[0];
        this.bobsTasks = taskSets[1];
        this.carolsTasks = taskSets[2];
        this.unassignedTasks = taskSets[3];
    }


    public Set<Task> getTasks(String name){

        switch (name){
            case "ann":
                return annsTasks;

            case "bob":
                return bobsTasks;

            case "carol":
                return carolsTasks;

            default:
                return unassignedTasks;
        }
    }

    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2){
        set1.addAll(set2);
        return set1;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        set1.retainAll(set2);
        return set1;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        set1.removeAll(set2);
        return set1;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TaskData taskData)) return false;
        return Objects.equals(annsTasks, taskData.annsTasks) && Objects.equals(bobsTasks, taskData.bobsTasks) && Objects.equals(carolsTasks, taskData.carolsTasks) && Objects.equals(unassignedTasks, taskData.unassignedTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
    }
}
