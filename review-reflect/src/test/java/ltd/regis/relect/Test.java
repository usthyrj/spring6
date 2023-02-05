package ltd.regis.relect;

public class Test {
    public static void main(String[] args) {
        SomeService ss = new SomeService();
        ss.doSome();
        String ss1 = ss.doSome("ss");
        String ss2 = ss.doSome("ss", 1);
        System.out.println(ss1);
        System.out.println(ss2);
    }
}
