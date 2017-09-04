package com.smart.dao;

import com.smart.common.BaseDao;
import com.smart.domain.User;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao extends BaseDao {

    private  final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  " +
            " WHERE name =? and password=? ";
    private  final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " lastVisit=?,lastIp=?,credits=?  WHERE id =?";

    public int getMatchCount(String name, String password) {

        return this.getJdbcTemplate().queryForObject(MATCH_COUNT_SQL, new Object[]{name, password}, Integer.class);
    }

    public User findByName(final String name) {
        String sqlStr = " SELECT id,name,credits "
                + " FROM t_user WHERE name =? ";
        final User user = new User();
        this.getJdbcTemplate().query(sqlStr, new Object[] {name},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setId(rs.getInt("id"));
                        user.setName(name);
                        user.setCredits(rs.getInt("credits"));
                    }
                });
        return user;
    }

    public void updateLoginInfo(User user) {
        this.getJdbcTemplate().update(UPDATE_LOGIN_INFO_SQL, new Object[] { user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getId()});
    }
}
