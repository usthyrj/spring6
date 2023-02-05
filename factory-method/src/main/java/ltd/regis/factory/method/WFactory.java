package ltd.regis.factory.method;

public class WFactory {
    public static WeaponFactory get(String factoryType) {
        WeaponFactory wf = null;
        switch (factoryType) {
            case "DOGGER":
                wf = new DoggerFactory();break;
            case "GUN":
                wf = new GunFactory(); break;
            default: throw new RuntimeException("No Such Factory now!");
        }
        return wf;
    }
}
