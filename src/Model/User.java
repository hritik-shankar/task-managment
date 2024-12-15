package Model;

import apple.laf.JRSUIUtils;

public class User {
    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }


}
