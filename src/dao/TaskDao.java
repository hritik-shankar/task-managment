package dao;

import Model.Task;
import enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskDao {
    private final Map<Integer, Task> taskList = new ConcurrentHashMap<>();

    public TaskDao(){

    }

    private LocalDateTime dueTime;

    public void createTask(Integer taskId, Task task){
        try {
            taskList.put(taskId, task);
            System.out.println("Task created with user id : " + taskId);
        }
        catch (IllegalArgumentException e){

        }
    }

    public Task getTask(Integer taskId){
        return taskList.get(taskId);
    }

    public Map<Integer, Task> getTaskList(){
        return taskList;
    }

    public void markTaskComplete(Integer taskId){
        Task task = taskList.get(taskId);
        task.setComplete(true);
    }
}
