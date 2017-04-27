package com.st.dao;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.st.entity.Log;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by tao on 2017/4/4 0004.
 */
public class LogDaoTest {

    @Test
    public void testAdd(){
        LogDao ld = new LogDao();
        Log log = new Log(111111,1001,new Date(System.currentTimeMillis()),"这是一条测试日志",8,"中","","通过");
        boolean result = ld.add(log);
        ld.delete(log.getId());
        assertEquals(true,result);
    }
    @Test
    public void testGet(){
        LogDao ld = new LogDao();
        Log log = ld.get(100001);
        assertEquals(100001,log.getId());
    }
    @Test
    public void testDel(){
        LogDao ld = new LogDao();
        Log l = new Log(10003,1001,new Date(System.currentTimeMillis()),"这是一条测试日志",8,"中","","通过");
        ld.add(l);
        boolean result = ld.delete(l.getId());
        assertEquals(true,result);
    }
    @Test
    public void testGetByUid(){
      LogDao ld = new LogDao();
      List<Log> list = new ArrayList<Log>();
      list = ld.getByUid(1001);
      System.out.println(list.get(1));
      System.out.println(list.get(0));
    }

}
