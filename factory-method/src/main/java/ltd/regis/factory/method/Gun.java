package ltd.regis.factory.method;

/**
 * 具体产品角色
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("Gun attacking...");
    }
}
