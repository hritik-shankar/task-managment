import Filtering.FilterByDueDate;
import Filtering.FilterByTaskStatus;
import Model.User;
import dao.TaskDao;
import dao.UserDao;

public class AppConfig {
    private dao.UserDao userDao = new UserDao();
    private dao.TaskDao taskDao = new TaskDao();
    private FilterByDueDate filterByDueDate = new FilterByDueDate(taskDao);
    private FilterByTaskStatus filterByTaskStatus = new FilterByTaskStatus(taskDao);

    public UserDao getUserDao(){
        return userDao;
    }

    public TaskDao getTaskDao(){
        return taskDao;
    }

    public FilterByDueDate getFilterByDueDate(){
        return filterByDueDate;
    }

    public FilterByTaskStatus getFilterByTaskStatus(){
        return filterByTaskStatus;
    }


}
