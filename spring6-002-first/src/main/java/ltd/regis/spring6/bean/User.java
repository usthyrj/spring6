package ltd.regis.spring6.bean;

public class User {
    /*
    * Spring默认调用无参构造方法创建bean,实现原理为反射机制
    * */
    public User() {
        System.out.println("User的无参构造方法");
    }
}
