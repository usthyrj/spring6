package ltd.regis.spring6.bean;

public class People {
    private String name;
    private int age;
    private  boolean gender;

//    c命名空间是简化构造注入的
    public People(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public People() {

    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
