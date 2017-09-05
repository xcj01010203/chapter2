package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser() {
        boolean b1 = userService.checkHasMatchUser("admin", "123456");
        boolean b2 = userService.checkHasMatchUser("admin", "1111");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void testFindUserByName()throws Exception{
        for(int i =0; i< 100;i++) {
            User user = userService.queryUserByName("admin");
            assertEquals(user.getName(), "admin");
        }
    }

    @Test
    public void testAddLoginLog() throws Exception {
        User user = userService.queryUserByName("admin");
        user.setId(1);
        user.setName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        this.userService.loginSuccess(user);
    }
}
