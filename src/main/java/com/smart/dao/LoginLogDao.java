package com.smart.dao;

import com.smart.common.BaseDao;
import com.smart.domain.LoginLog;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao extends BaseDao {

    //保存登陆日志SQL
    private final static String INSERT_LOGIN_LOG_SQL= "INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?)";

    public void insertLoginLog(LoginLog loginLog) {
        Object[] args = { loginLog.getUserId(), loginLog.getIp(),
                loginLog.getLoginDateTime() };
        this.getJdbcTemplate().update(INSERT_LOGIN_LOG_SQL, args);
    }


}
