package org.hww.jdbctemplate.databasepools;

/**
 * Spring数据库连接池操作
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        userDao.add();
    }

}
