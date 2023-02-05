package ltd.regis.relect;

public class SomeService {
    public void doSome() {
        System.out.println("public void doSome()...");
    }

    public String doSome(String s) {
        System.out.println("public void doSome(String s)...");
        return s;
    }

    public String doSome(String s, int i) {
        System.out.println("public void doSome(String s, int i)...");
        return s;
    }

}
