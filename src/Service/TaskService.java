package Service;

import Filtering.FilterByDueDate;
import Filtering.FilterByTaskStatus;
import Filtering.Filtering;
import Model.Task;
import dao.TaskDao;
import enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.*;

public class TaskService {
    private TaskDao taskDao;
    private FilterByDueDate filterByDueDate;
    private FilterByTaskStatus filterByTaskStatus;
    private Map<String, Filtering> filterRegistry = new HashMap<>();

    public TaskService(TaskDao taskDao, FilterByTaskStatus filterByTaskStatus, FilterByDueDate filterByDueDate){
        this.taskDao = taskDao;
        filterRegistry.put("DueDate", filterByDueDate);
        filterRegistry.put("TaskStaus", filterByTaskStatus);

    }

    public void createTask(Integer taskId, Integer userId, String title, TaskStatus taskStatus, Boolean isComplete, LocalDateTime dueTime){
        Task task = new Task(taskId, title, userId, taskStatus, isComplete, dueTime);
        taskDao.createTask(taskId, task);
    }

    public Task getTask(Integer taskId){
        Task task = taskDao.getTask(taskId);

        if(Objects.isNull(task)){
            throw new IllegalArgumentException("Task not found");
        }

        return task;
    }

    public List<Task> filterTask(String keyword){
        Filtering filter = filterRegistry.get(keyword);

        if(Objects.isNull(filter))
            throw new IllegalArgumentException("Invalid");


        return filter.filtering(keyword);
    }

    public List<Task> getTaskHistory(){
        return new ArrayList<>(taskDao.getTaskList().values());
    }

    public void markTaskComplete(Integer taskId){
        Task task = taskDao.getTask(taskId);

        if(task == null){
            throw new IllegalArgumentException("Invalid task");
        }

        taskDao.markTaskComplete(taskId);
    }

    public Task getTaskDetails(Integer taskId){
        Task task = taskDao.getTask(taskId);
        if(task == null){
            throw new IllegalArgumentException("Invalid task id");
        }
        return task;
    }

    public void asignTaskToOther(Integer primaryUserId, Integer secondaryUserId, Integer taskId){
        Task task = taskDao.getTask(taskId);

        if(task == null){
            throw new IllegalArgumentException("Invalid task");
        }

        if(!task.getUserId().equals(primaryUserId)){
            throw new IllegalArgumentException("Invalid primary user");
        }

        task.setUserId(secondaryUserId);
    }
}
