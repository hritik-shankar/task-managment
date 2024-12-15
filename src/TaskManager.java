import Model.Task;
import Service.TaskService;
import Service.UserService;
import enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

public class TaskManager {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        UserService userService = new UserService(appConfig.getUserDao());
        TaskService taskService = new TaskService(appConfig.getTaskDao(), appConfig.getFilterByTaskStatus(), appConfig.getFilterByDueDate());

        //Create users
        userService.createUser(1, "Hritik");
        userService.createUser(2, "Roshan");
        userService.createUser(3,"Hemanth");

        //Creating tasks
        LocalDateTime dueDate = LocalDateTime.of(2023, 11, 25, 13, 30);
        taskService.createTask(1, 1, "First Case", TaskStatus.PENDING,false, dueDate);

        dueDate = LocalDateTime.of(2023, 11, 25, 10, 30);
        taskService.createTask(2, 1, "Second Case", TaskStatus.PENDING,false, dueDate);

        //filter task
        List<Task> taskList = taskService.filterTask("DueDate");

        for(Task task: taskList)
            System.out.println(task.getTaskId());

        //Mark task as completed
        taskService.markTaskComplete(2);

        Task task = taskService.getTask(2);

        System.out.println("Task id : " + task.getTaskId());
        System.out.println("Task details : " + task.getTitle());
        System.out.println("Task Completed : " + task.isComplete());

        //View task history
        List<Task> taskHistory = taskService.getTaskHistory();

        System.out.println("**************");
        for(Task task2 : taskHistory){
            System.out.println("Task id : " + task2.getTaskId());
            System.out.println("Task details : " + task2.getTitle());
            System.out.println("Task Completed : " + task2.isComplete());
            System.out.println("Task User : " + task2.getUserId());
        }

        System.out.println("*****ASSIGN OTHER USER*****");
        Integer secondaryUserId = 3;
        Integer primaryUserId = 1;

        if(userService.isValidUser(secondaryUserId) == false){
            throw new IllegalArgumentException("Invalid user");
        }

        taskService.asignTaskToOther(primaryUserId, secondaryUserId, 2);

        taskHistory = taskService.getTaskHistory();

        System.out.println("**************");
        for(Task task2 : taskHistory){
            System.out.println("Task id : " + task2.getTaskId());
            System.out.println("Task details : " + task2.getTitle());
            System.out.println("Task Completed : " + task2.isComplete());
            System.out.println("Task User : " + task2.getUserId());
        }



    }

}
