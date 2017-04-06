package com.st.entity;

import com.alibaba.fastjson.annotation.JSONType;

import java.sql.Date;

/**
 * Created by tao on 2017/4/2 0002.
 */

@JSONType(orders={"id","uid","workdate","desribe","worktime","difficulty","remark"})
public class Log {
    private int id ;
    private int uid;
    private Date workdate;
    private String desribe;
    private int worktime;
    private String difficulty;
    private String remark;
    private String status;

    public Log(int id,int uid,Date workdate,String desribe,int worktime,String difficulty,String remark,String status){
        this.id = id;
        this.uid = uid;
        this.workdate = workdate;
        this.desribe = desribe;
        this.worktime = worktime;
        this.difficulty = difficulty;
        this.remark = remark;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public String getDesribe() {
        return desribe;
    }

    public void setDesribe(String desribe) {
        this.desribe = desribe;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;

        Log log = (Log) o;

        if (getId() != log.getId()) return false;
        if (getUid() != log.getUid()) return false;
        if (getWorktime() != log.getWorktime()) return false;
        if (getWorkdate() != null ? !getWorkdate().equals(log.getWorkdate()) : log.getWorkdate() != null) return false;
        if (getDesribe() != null ? !getDesribe().equals(log.getDesribe()) : log.getDesribe() != null) return false;
        if (getDifficulty() != null ? !getDifficulty().equals(log.getDifficulty()) : log.getDifficulty() != null)
            return false;
        if (getRemark() != null ? !getRemark().equals(log.getRemark()) : log.getRemark() != null) return false;
        return getStatus() != null ? getStatus().equals(log.getStatus()) : log.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUid();
        result = 31 * result + (getWorkdate() != null ? getWorkdate().hashCode() : 0);
        result = 31 * result + (getDesribe() != null ? getDesribe().hashCode() : 0);
        result = 31 * result + getWorktime();
        result = 31 * result + (getDifficulty() != null ? getDifficulty().hashCode() : 0);
        result = 31 * result + (getRemark() != null ? getRemark().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", uid=" + uid +
                ", workdate=" + workdate +
                ", desribe='" + desribe + '\'' +
                ", worktime=" + worktime +
                ", difficulty='" + difficulty + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
