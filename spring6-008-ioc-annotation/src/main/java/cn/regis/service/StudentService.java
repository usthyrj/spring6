package cn.regis.service;

import cn.regis.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Resource(name = "studentDaoImplForMySQL")
    StudentDao studentDao;

    public void deleteStudent() {
        studentDao.deleteById();
    }
}
