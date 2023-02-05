package cn.regis.dao.impl;

import cn.regis.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除学生信息....");
    }
}
