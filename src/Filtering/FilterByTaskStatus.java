package Filtering;

import Model.Task;
import dao.TaskDao;

import java.util.*;

public class FilterByTaskStatus implements Filtering{
    TaskDao taskDao;

    public FilterByTaskStatus(TaskDao taskDao){
        this.taskDao = taskDao;
    }
    @Override
    public List<Task> filtering(String keyword) {
        Map<Integer, Task> taskList = taskDao.getTaskList();

        if (taskList == null || taskList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Task> taskList1 = new ArrayList<>(taskList.values());
        taskList1.sort(Comparator.comparing(Task::getTaskStatus));


        return taskList1;
    }
}
