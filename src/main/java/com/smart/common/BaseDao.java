package com.smart.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 数据访问层基类
 */
public class BaseDao<T> {

//    Logger logger = ;

    private final String TABLE_NAME_FIELD = "TABLE_NAME";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public int getResultCount(String sql, Object[] args) {
        sql = "select count(*) from ("+ sql +") res";
        return this.jdbcTemplate.queryForObject(sql, args, Integer.class);

    }

    /**
     * 自动insert方法 obj必须为一个与数据库表相对应的一个实体类并且字段名也必须和数据库的字段名相同。
     * 实体类中必须有一个名为TABLE_NAME属性，并赋值为相对应的表名。
     * 如果id属性为空，则系统会自动赋值
     * @param obj
     * @return
     */
    public int addOne(Object obj) throws Exception {
        if (obj == null) {
            return 0;
        }


        Class<?> clz = obj.getClass();

        // 获取实体类的所有属性，返回Field数组
        Field fieldTableName = clz.getField(this.TABLE_NAME_FIELD);
        if (fieldTableName == null) {
//            logger.info("error:insert object "+ obj.getClass().getName() +" do not have TABLE_NAME field");
            return 0;
        }

        String tableName = (String) fieldTableName.get(obj);

        //TODO 为id赋默认值

        Field[] fields = clz.getDeclaredFields();
        StringBuffer insertSql = new StringBuffer();
        insertSql.append("insert into ");
        insertSql.append(tableName);
        insertSql.append(" (");

        List<Object> list = new ArrayList<Object>();

        for (Field field : fields) {

            if (this.TABLE_NAME_FIELD.equals(field.getName())) {
                continue;
            }

            Method m = obj.getClass().getMethod("get" + getMethodName(field.getName()));

            Object val = m.invoke(obj);
            if (val != null) {
                insertSql.append(field.getName());
                insertSql.append(",");
                list.add(val);
            }
        }
        insertSql = new StringBuffer(insertSql.substring(0,
                insertSql.length() - 1));
        insertSql.append(" ) values (");
        objArray = new Object[list.size()];

        for (int i = 0; i < list.size(); i++) {
            objArray[i] = list.get(i);
            insertSql.append("?,");
        }

        insertSql = new StringBuffer(insertSql.substring(0,
                insertSql.length() - 1));
        insertSql.append(" ) ");
        return this.jdbcTemplate.update(insertSql.toString(),
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps)
                            throws SQLException {
                        for (int i = 0; i < objArray.length; i++) {
                            ps.setObject(i + 1, objArray[i]);
                        }
                    }
                });

        return 1;

    }

}
