package dao;

import Model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDao {
    private final Map<Integer, User> userList = new ConcurrentHashMap<>();

    public UserDao(){

    }

    public void createUser(Integer userId, String userName){
        try {
            User user = new User(userId, userName);
            userList.put(userId, user);
            System.out.println("User created with user id : " + userId);
        }
        catch (IllegalArgumentException e){
            System.out.println("Error");
        }
    }

    public User getUser(Integer userId){
        return userList.get(userId);
    }

}
