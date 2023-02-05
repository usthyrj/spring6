package ltd.regis.factory.method;

/**
 * 具体产品角色
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("Dagger attacking...");
    }
}
