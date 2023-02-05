package ltd.regis.factory.method;

/**
 * 抽象工厂角色
 */
public abstract class WeaponFactory {
    /**
     * 这个方法不是静态的
     * @return
     */
    public abstract Weapon get();
}
