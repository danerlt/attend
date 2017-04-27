package com.st.dao;

import com.st.entity.User;
import org.junit.Test;
import org.junit.Assert.*;
/**
 * Created by tao on 2017/4/2 0002.
 */
public class UserDaoTest {
    @Test
    public void testAdd(){
//        UserDao ud = new UserDao();
//        User u = new User(1112,"test","24324",1);
//        ud.add(u);
//        System.out.println( ud.get(u.getId()));

    }
    @Test
    public void testGetbyIdandPassword(){
        UserDao ud = new UserDao();
        User u = ud.get(1001,"123456");
        System.out.println(u);

    }
}
