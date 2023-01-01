package com.java.crud.board;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void contextLoads() {

    }

    @Test
    public void testByApplicationContext() {
        try {
            System.out.println("=====================");
            System.out.println(context.getBean("sqlSessionFactory"));
            System.out.println("=====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBySqlSessionFactory() {
        try {
            System.out.println("=====================");
            System.out.println(sqlSessionFactory.toString());
            System.out.println("=====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testByBeanIsEquals() {
        Object contextBean = context.getBean("sqlSessionFactory");
        Object sqlSessionFactor = sqlSessionFactory.toString();
        System.out.println(contextBean);
        System.out.println(sqlSessionFactor);
        assertThat(contextBean.equals(sqlSessionFactor));
    }
    // DBConfig 에서 ApplicationContext(컨테이너)에 등록한 sqlSessionFactory 객체랑
    // Autowired 로 주입한 sqlSessionFactory 가 같은지 테스트
}
