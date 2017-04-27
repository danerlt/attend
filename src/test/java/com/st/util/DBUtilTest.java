package com.st.util;

import org.junit.Test;

import java.sql.ResultSet;
import static org.junit.Assert.*;
/**
 * Created by tao on 2017/4/2 0002.
 */

public class DBUtilTest {

    @Test
    public void testConntion(){
       try{
           DBUtil db = new DBUtil();
           ResultSet rs = null;
           String sql = "select username from user where id =?";
           Object[] params = {1001};
           rs = db.doQuery(sql,params);
           if(rs.next()){
              System.out.println(rs.getString(1));
              assertEquals("root",rs.getString(1));
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
