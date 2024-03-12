package model;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<SubTask> subtasks = new ArrayList<>();

    public Epic(String name, String description, TaskProgressStatus taskProgressStatus) {
        super(name, description, taskProgressStatus);
    }

    public ArrayList<SubTask> getSubtasks() {
        return subtasks;
    }

    public void addSubTask(SubTask subTask) {
        subtasks.add(subTask);
    }
}
