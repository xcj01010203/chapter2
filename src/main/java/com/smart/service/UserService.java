package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean checkHasMatchUser(String name, String password) {
        int matchCount = this.userDao.getMatchCount(name, password);
        return matchCount > 0;
    }

    public User queryUserByName(String name) {
        return this.userDao.findByName(name);
    }


    public void loginSuccess(User user) throws Exception{
        user.setCredits(5 + user.getCredits());
        LoginLog log = new LoginLog();
        log.setIp(user.getLastIp());
        log.setLoginDateTime(user.getLastVisit());
        log.setUserId(user.getId());

        this.userDao.updateLoginInfo(user);
        this.loginLogDao.addOne(log);
    }
}
