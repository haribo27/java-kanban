import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskProgressStatus;
import service.TaskManager;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        Task homeworkTask = new Task("Сделать домашнее задание",
                "Уроки по математике", TaskProgressStatus.DONE);
        Task washingTask = new Task("Стирка вещей",
                "Постирать белые вещи", TaskProgressStatus.NEW);
        manager.createTask(homeworkTask);
        manager.createTask(washingTask);

        Epic removalEpic = new Epic("Переезд",
                "Собрать вещи, заказать грузовую машину", TaskProgressStatus.IN_PROGRESS);
        Epic healingEpic = new Epic("Пройти курс лечения",
                "Найти подходящую клинику и пройти курс лечения", TaskProgressStatus.DONE);
        manager.createEpic(removalEpic);
        manager.createEpic(healingEpic);

        SubTask collectClothesSubtask = new SubTask("Сложить в пакеты одежду",
                "Складывать только одежду, ничего более", TaskProgressStatus.NEW, removalEpic);
        SubTask collectFurnitureSubtask = new SubTask("Сложить в газель мебель",
                "Упаковать мебель в пупырчатую пленку и загрузить все в газель",
                TaskProgressStatus.DONE, removalEpic);
        SubTask findClinicSubtask = new SubTask("Найти хорошее мед. учреждение",
                "Учитывать стоимость, рейтинг клиники", TaskProgressStatus.NEW, healingEpic);
        manager.createSubTask(collectClothesSubtask);
        manager.createSubTask(collectFurnitureSubtask);
        manager.createSubTask(findClinicSubtask);


        System.out.println(manager.getEpics() + "\n" + manager.getTasks() + "\n" + manager.getSubTasks());

        SubTask collectClothesSubtaskUpdated = new SubTask("Сложить в пакеты одежду",
                "Складывать только одежду, ничего более", TaskProgressStatus.DONE, removalEpic);
        SubTask collectFurnitureSubtaskUpdated = new SubTask("Сложить в газель мебель",
                "Упаковать мебель в пупырчатую пленку и загрузить все в газель",
                TaskProgressStatus.DONE, removalEpic);
        SubTask findClinicSubtaskUpdated = new SubTask("Найти хорошее мед. учреждение",
                "Учитывать стоимость, рейтинг клиники", TaskProgressStatus.DONE, healingEpic);
        Task homeworkTaskUpdated = new Task("Сделать домашнее задание",
                "Уроки по математике", TaskProgressStatus.NEW);

        manager.updateSubtask(collectClothesSubtaskUpdated, 5);
        manager.updateSubtask(collectFurnitureSubtaskUpdated, 6);
        manager.updateSubtask(findClinicSubtaskUpdated, 7);
        manager.updateTask(homeworkTaskUpdated, 1);
        System.out.println();
        System.out.println(manager.getEpics() + "\n" + manager.getTasks() + "\n" + manager.getSubTasks());

        System.out.println();
        manager.deleteTaskFromId(1);
        manager.deleteEpicFromId(3);
        System.out.println(manager.getEpics() + "\n" + manager.getTasks() + "\n" + manager.getSubTasks());


    }
}
