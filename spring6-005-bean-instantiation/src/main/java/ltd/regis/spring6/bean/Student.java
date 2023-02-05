package ltd.regis.spring6.bean;

import java.util.Date;

public class Student {

//    java.util.Date在Spring被当做简单类型，注入的日期格式有要求
//    java.util.Date在Spring也可以被当做非简单类型

    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
