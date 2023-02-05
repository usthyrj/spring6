package ltd.regis.simple.factory;

/**
 * This sis client
 */
public class Test {
    public static void main(String[] args) {

//        对于客户端来说不需要关心坦克的生产细节
//        达到了职责分离
//        生产者消费者分离，这就是简单工厂模式的作用
        Weapon tank = WeaponFactory.get("TANK");
        Weapon dagger = WeaponFactory.get("DAGGER");
        Weapon fighter = WeaponFactory.get("FIGHTER");
        tank.attack();
        dagger.attack();
        fighter.attack();
        Weapon ada = WeaponFactory.get("ADA");
    }
}
