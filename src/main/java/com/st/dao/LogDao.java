package com.st.dao;

import com.st.entity.Log;
import com.st.util.DBUtil;

import java.sql.Date;
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
        String sql = "insert into log values(?,?,?,?,?,?,?,?)";
        Object[] params = {log.getId(),
                log.getUid(),
                log.getWorkdate(),
                log.getDesribe(),
                log.getWorktime(),
                log.getDifficulty(),
                log.getRemark(),
                log.getStatus()
        };
        int rownum = db.doUpdate(sql,params);//rownum表示影响行数
        return rownum == 1;
    }
    /**
     * 添加一个日志,
     * @param log 日志
     * @return 添加成功:true 添加失败:false
     */
    public boolean addWithoutId(Log log){
        DBUtil db = new DBUtil();
        String sql = "insert into log(uid,workdate,`describe`,worktime,difficulty,remark,`status`) values(?,?,?,?,?,?,?)";
        Object[] params = {
                log.getUid(),
                log.getWorkdate(),
                log.getDesribe(),
                log.getWorktime(),
                log.getDifficulty(),
                log.getRemark(),
                log.getStatus()
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
        String sql = "delete from Log where id = ?";
        Object[] params = {id};
        int rownum = db.doUpdate(sql,params);//rownum表示影响行数
        return rownum == 1;
    }

    /**
     *
     * @param log 日志
     * @return 更新成功:true,更新失败:false
     */
    public boolean update(Log log){
        DBUtil db = new DBUtil();
        String sql = "update Log set uid=?,workdate=?,describe=?,worktime=?,difficulty=?,remark=?,status=? where id =?";
        Object[] params = {
                log.getUid(),
                log.getWorkdate(),
                log.getDesribe(),
                log.getWorktime(),
                log.getDifficulty(),
                log.getRemark(),
                log.getStatus(),
                log.getId()
        };
        int rownum = db.doUpdate(sql,params);//rownum表示影响行数
        return rownum == 1;
    }

    /**
     *
     * @param id 日志ID
     * @return 查找成功:ID为id的日志,查找失败:null
     */
    public Log get(int id){
        DBUtil db = new DBUtil();
        String sql = "select uid,workdate,`describe`,worktime,difficulty,remark,status from log where id = ?";
        Object[] params = {id};
        try {
            ResultSet rs = db.doQuery(sql, params);
            if (rs.next()) {
               int uid = rs.getInt(1);
               Date workdate = rs.getDate(2);
               String describe = rs.getString(3);
               int worktime = rs.getInt(4);
               String diffculty = rs.getString(5);
               String remark = rs.getString(6);
               String status = rs.getString(7);
               Log log = new Log(id,uid,workdate,describe,worktime,diffculty,remark,status);
               return log;
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
     * @param uid 用户ID
     * @return 查找成功:用户ID为uid的所有日志,查找失败:null
     */
    public List<Log> getByUid(int uid){
        List<Log> list = new ArrayList<Log>();
        DBUtil db = new DBUtil();
        String sql = "select id,workdate,`describe`,worktime,difficulty,remark,status from log where uid = ? order by workdate desc";
        Object[] params = {uid};
        try {
            ResultSet rs = db.doQuery(sql, params);
            while (rs.next()) {
                int id = rs.getInt(1);
                Date workdate = rs.getDate(2);
                String describe = rs.getString(3);
                int worktime = rs.getInt(4);
                String diffculty = rs.getString(5);
                String remark = rs.getString(6);
                String status = rs.getString(7);
                Log log = new Log(id,uid,workdate,describe,worktime,diffculty,remark,status);
                list.add(log);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @return 所有日志
     */
    public List<Log> findAll(){
        DBUtil db = new DBUtil();
        String sql = "select * from log order by uid";
        List<Log> list = new ArrayList<Log>();
        try {
            ResultSet rs = db.doQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int uid = rs.getInt(2);
                Date workdate = rs.getDate(3);
                String describe = rs.getString(4);
                int worktime = rs.getInt(5);
                String diffculty = rs.getString(6);
                String remark = rs.getString(7);
                String status = rs.getString(8);
                Log log = new Log(id,uid,workdate,describe,worktime,diffculty,remark,status);
                list.add(log);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
