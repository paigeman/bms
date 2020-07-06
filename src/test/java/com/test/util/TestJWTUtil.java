package com.test.util;

import com.ncu.bms.util.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJWTUtil {

    @Test
    public void testSign(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1002);
        map.put("userName", "张晓明");
        map.put("age", 12);
        map.put("address", "山东省青岛市李沧区");
        String token = JWTUtil.createToken(map);
        System.out.println(token);
    }

    @Test
    public void testDeSign(){
        System.out.println(JWTUtil.verifyToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNGRjNzgxMS05YTJkLTRiNjEtOGIzNS1kNjVlYzRmMWFhY2QiLCJpYXQiOjE1OTMwODM2NjcsImV4cCI6MTU5MzA4NzI2NywiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lI" +
                "joi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.M7CthnVyp3OXdjpm63drHCQ4kAE2gO5tQQSheLIR7R4"));
    }

    @Test
    public void testParseToken(){
        System.out.println(JWTUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNGRjNzgxMS05YTJkLTRiNjEtOGIzNS1kNjVlYzRmMWFhY2QiLCJpYXQiOjE1OTMwODM2NjcsImV4cCI6MTU5MzA4NzI2NywiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lI" +
                "joi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.M7CthnVyp3OXdjpm63drHCQ4kAE2gO5tQQSheLIR7R4"));
        Map<String,Object> map = JWTUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNGRjNzgxMS05YTJkLTRiNjEtOGIzNS1kNjVlYzRmMWFhY2QiLCJpYXQiOjE1OTMwODM2NjcsImV4cCI6MTU5MzA4NzI2NywiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lI" +
                "joi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.M7CthnVyp3OXdjpm63drHCQ4kAE2gO5tQQSheLIR7R4");
        if(map.containsKey("address")){
            System.out.println("right");
        }
    }

}
