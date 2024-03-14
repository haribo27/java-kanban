package model;

import service.TaskManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task {

    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();

    public Epic(String name, String description, TaskProgressStatus taskProgressStatus) {
        super(name, description, taskProgressStatus);
    }

    public HashMap<Integer, SubTask> getSubtasks() {
        return subtasks;
    }

    public void addSubTask(int id, SubTask subTask) {
        subtasks.put(id, subTask);
    }

    @Override
    public String toString() {
        return "model.Epic: " + getName() + " Description: " + getDescription()
                + " Status: " + getTaskProgressStatus();
    }
}
