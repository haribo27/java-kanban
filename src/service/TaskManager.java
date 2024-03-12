package service;

import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskProgressStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private int id = 0;
    private final HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();

    private final HashMap<Integer, Task> tasks = new HashMap<>();

    public void createSubTask(SubTask subTask) {
        subTask.setId(id++);
        subTasks.put(subTask.getId(), subTask);
    }

    public void createEpic(Epic epic) {
        ArrayList<SubTask> subTasks = epic.getSubtasks();
        boolean statusInProgress = subTasks.stream()
                .anyMatch(x -> x.getTaskProgressStatus() == TaskProgressStatus.IN_PROGRESS || x.getTaskProgressStatus() == TaskProgressStatus.DONE);
        boolean statusDone = subTasks.stream().allMatch(x -> x.getTaskProgressStatus() == TaskProgressStatus.DONE);
        if (statusDone) {
            epic.setTaskProgressStatus(TaskProgressStatus.DONE);
        } else if (statusInProgress) {
            epic.setTaskProgressStatus(TaskProgressStatus.IN_PROGRESS);
        } else {
            epic.setTaskProgressStatus(TaskProgressStatus.NEW);
        }
        epic.setId(id++);
        epics.put(epic.getId(), epic);
    }

    public void createTask(Task task) {
        task.setId(id++);
        tasks.put(task.getId(), task);
    }

    public HashMap<Integer, SubTask> getSubTasks() {
        return subTasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public void deleteSubtasks() {
        subTasks.clear();
    }

    public void deleteEpics() {
        epics.clear();
    }

    public void deleteTask() {
        tasks.clear();
    }

    public SubTask getSubtaskFromId(int id) {
        return subTasks.get(id);
    }

    public Epic getEpicFromId(int id) {
        return epics.get(id);
    }

    public Task getTaskFromId(int id) {
        return tasks.get(id);
    }

    public void getEpicSubtasks(Epic epic) {
        for (Map.Entry<Integer, Epic> pair : epics.entrySet()) {
            if (pair.getValue().equals(epic)) {
                System.out.println(pair.getValue().getSubtasks());
            }
        }
    }

    public void updateSubtask(SubTask subTask, int id) {
        subTasks.put(id, subTask);
    }

    public void updateEpic(Epic epic, int id) {
        epics.put(id, epic);
    }

    public void updateTask(Task task, int id) {
        tasks.put(id, task);
    }

    public void deleteEpicFromId(int id) {
        epics.remove(id);
    }

    public void deleteSubtaskFromId(int id) {
        subTasks.remove(id);
    }

    public void deleteTaskFromId(int id) {
        tasks.remove(id);
    }

    public ArrayList<SubTask> getEpicsSubtasks(Epic epic) {
        return epic.getSubtasks();
    }
}
