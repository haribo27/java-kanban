import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskProgressStatus;
import service.*;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = Managers.getDefault();

        Task homeworkTask = new Task("Сделать домашнее задание",
                "Уроки по математике", TaskProgressStatus.DONE);
        Task washingTask = new Task("Стирка вещей",
                "Постирать белые вещи", TaskProgressStatus.NEW);
        manager.addNewTask(homeworkTask);
        manager.addNewTask(washingTask);

        Epic removalEpic = new Epic("Переезд",
                "Собрать вещи, заказать грузовую машину", TaskProgressStatus.IN_PROGRESS);
        Epic healingEpic = new Epic("Пройти курс лечения",
                "Найти подходящую клинику и пройти курс лечения", TaskProgressStatus.DONE);
        manager.addNewEpic(removalEpic);
        manager.addNewEpic(healingEpic);

        SubTask collectClothesSubtask = new SubTask("Сложить в пакеты одежду",
                "Складывать только одежду, ничего более", TaskProgressStatus.DONE, removalEpic);
        SubTask collectFurnitureSubtask = new SubTask("Сложить в газель мебель",
                "Упаковать мебель в пупырчатую пленку и загрузить все в газель",
                TaskProgressStatus.IN_PROGRESS, removalEpic);
        SubTask findClinicSubtask = new SubTask("Найти хорошее мед. учреждение",
                "Учитывать стоимость, рейтинг клиники", TaskProgressStatus.NEW, healingEpic);
        manager.addNewSubtask(collectClothesSubtask);
        manager.addNewSubtask(collectFurnitureSubtask);
        manager.addNewSubtask(findClinicSubtask);

        printAllTasks(manager);
    }

    private static void printAllTasks(TaskManager manager) {

        manager.getTask(2);
        manager.getTask(1);
        manager.getEpic(4);
        manager.getSubtask(6);
        manager.getSubtask(7);

        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Task epic : manager.getEpics()) {
            System.out.println(epic);

            for (Task task : manager.getEpicSubtasks(epic.getId())) {
                System.out.println("--> " + task);
            }
        }
        System.out.println("Подзадачи:");
        for (Task subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistoryManager().getHistory()) {
            System.out.println(task);
        }
    }
}
