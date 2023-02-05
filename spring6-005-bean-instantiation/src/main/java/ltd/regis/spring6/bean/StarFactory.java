package ltd.regis.spring6.bean;

public class StarFactory {
    public static Star get() {
        System.out.println("Star---get");
        return new Star();
    }
}
