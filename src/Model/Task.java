package Model;

import enums.TaskStatus;

import java.time.LocalDateTime;

public class Task {
    private Integer taskId;
    private String title;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer userId;
    private TaskStatus taskStatus;

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    private boolean isComplete;
    private LocalDateTime dueTime;

    public Integer getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }



    public Task(Integer taskId, String title, Integer userId, TaskStatus taskStatus, boolean isComplete, LocalDateTime dueTime) {
        this.taskId = taskId;
        this.title = title;
        this.userId = userId;
        this.taskStatus = taskStatus;
        this.isComplete = isComplete;
        this.dueTime = dueTime;
    }
}