package ltd.regis.simple.factory;

/**
 * 工厂类角色
 */
public class WeaponFactory {

    /**
     * 静态方法，要获取什么产品看你传什么参数
     * 简单工厂模式有个静态方法，所以被称为静态方法工厂模式
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType) {
        Weapon weapon = null;
        switch (weaponType) {
            case "TANK":
                weapon = new Tank();break;
            case "DAGGER":
                weapon = new Dagger();break;
            case "FIGHTER":
                weapon = new Fighter();break;
            default: throw new RuntimeException("不支持该类型武器生产");
        }
        return weapon;

    }
}
