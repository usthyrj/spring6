package ltd.regis.factory.method;

public class Test {
    public static void main(String[] args) {
        WeaponFactory wf = WFactory.get("DOGGER");
        Weapon dogger = wf.get();
        dogger.attack();
        wf = WFactory.get("GUN");
        Weapon gun = wf.get();
        gun.attack();
    }
}
