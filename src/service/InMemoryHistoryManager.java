package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private final List<Task> historyTaskList;

    public InMemoryHistoryManager() {
        historyTaskList = new ArrayList<>();
    }

    @Override
    public void add(Task task) {
        if (isFullHistoryList()) {
            historyTaskList.removeFirst();
        }
        historyTaskList.add(task);
    }

    @Override
    public List<Task> getHistory() {
        return historyTaskList;
    }

    private boolean isFullHistoryList() {
        return historyTaskList.size() >= 10;
    }
}
