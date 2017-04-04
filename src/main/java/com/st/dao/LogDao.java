package com.st.dao;

import com.st.entity.Log;
import com.st.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2017/4/4 0004.
 */
public class LogDao {
    /**
     * 添加一个日志,
     * @param log 日志
     * @return 添加成功:true 添加失败:false
     */
    public boolean add(Log log){
        DBUtil db = new DBUtil();
        String sql = "insert into log values(?,?,?,?,?,?,?)";
        Object[] params = {log.getId(),
                log.getUid(),
                log.getWorkdate(),
                log.getDesribe(),
                log.getWorktime(),
                log.getDifficulty(),
                log.getRemark()
        };
        int rownum = db.doUpdate(sql,params);//rownum表示影响行数
        return rownum == 1;
    }
    /**
     * 添加一个日志,
     * @param id 日志ID
     * @return 删除成功:true 删除失败:false
     */
    public boolean delete(int id){
        DBUtil db = new DBUtil();
        String sql = "delete from user where id = ?";
        Object[] params = {id};
        int rownum = db.doUpdate(sql,params);//rownum表示影响行数
        return rownum == 1;
    }

    /**
     *
     * @param u 日志
     * @return 更新成功:true,更新失败:false
     */
    public boolean update(User u){
        DBUtil db = new DBUtil();
        String sql = "update user set username=?,password=?,level=? where id =?";
        Object[] params = {
                u.getUsername(),
                u.getPassword(),
                u.getLevel(),
                u.getId()
        };
        int rownum = db.doUpdate(sql,params);//rownum表示影响行数
        return rownum == 1;
    }

    /**
     *
     * @param id 日志ID
     * @return 查找成功:ID为id的日志,查找失败:null
     */
    public User get(int id){
        DBUtil db = new DBUtil();
        String sql = "select username,password,level from user where id = ?";
        Object[] params = {id};
        try {
            ResultSet rs = db.doQuery(sql, params);
            if (rs != null) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                int level = rs.getInt(3);
                User u = new User(id, username, password, level);
                return u;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param id 日志ID
     * @param password 日志密码
     * @return 查找成功:ID为id的日志,查找失败:null
     */
    public User get(int id,String password){
        DBUtil db = new DBUtil();
        String sql = "select username,`password`,`level` from `user` where id = "+id;
        // Object[] params = {id};
        try {
            //ResultSet rs = db.doQuery(sql, params);
            ResultSet rs = db.doQuery(sql);
            if (rs.next()) {
                String pass = rs.getString(2);
                if(pass.equals(password)){
                    //表示从数据库取出的密码和给定的密码符合
                    String username = rs.getString(1);
                    int level = rs.getInt(3);
                    User u = new User(id,username,password,level);
                    return u;
                }else{
                    return null;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param username
     * @return 查找成功:所用名为username的日志,查找失败:null
     */
    public List<User> get(String username){
        DBUtil db = new DBUtil();
        String sql = "select id,pssword,level where username = ?";
        String[] params = {username};
        List<User> list = new ArrayList<User>();
        try {
            ResultSet rs = db.doQuery(sql, params);
            while (rs.next()) {
                int id = rs.getInt(1);
                String password = rs.getString(2);
                int level = rs.getInt(3);
                User u = new User(id,username,password,level);
                list.add(u);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return 所用日志
     */
    public List<User> findAll(){
        DBUtil db = new DBUtil();
        String sql = "select * where username";
        List<User> list = new ArrayList<User>();
        try {
            ResultSet rs = db.doQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int level = rs.getInt(4);
                User u = new User(id,username,password,level);
                list.add(u);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
