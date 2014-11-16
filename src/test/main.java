package test;

import model.User;
import db.UserBussiness;


public class main {
    public static void main(String[] args) {

        User user = new User();
        user.setUserName("123456789");
        user.setUserPsd("asdf");

        UserBussiness bussiness = new UserBussiness();
        bussiness.findAll();
    }
}
