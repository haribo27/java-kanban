package model;

public class SubTask extends Task {

    private Epic epic;

    public SubTask(String name, String description, TaskProgressStatus taskProgressStatus, Epic epic) {
        super(name, description, taskProgressStatus);
        this.epic = epic;
    }

    public Epic getEpic() {
        return epic;
    }
}
