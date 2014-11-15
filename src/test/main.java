package test;

import bean.User;
import bean.UserBussiness;


public class main {
    public static void main(String[] args) {

        User user = new User();
        user.setUserName("123456789");
        user.setUserPsd("asdf");

        UserBussiness bussiness = new UserBussiness();
        bussiness.findAll();
    }
}
