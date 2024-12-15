package Service;

import Model.User;
import dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void createUser(Integer userId, String userName){

        userDao.createUser(userId, userName);
    }

    public User getUser(Integer userId){
        return userDao.getUser(userId);
    }

    public boolean isValidUser(Integer userId){
        User user = userDao.getUser(userId);

        if(user == null){
            return false;
        }

        return true;
    }
}
