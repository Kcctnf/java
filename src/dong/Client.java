package dong;

/**
 * Autor : dong
 * Time:2018/11/29
 */
interface Computer1 {
    void printComputer();
}
class MacbookProComputer1 implements Computer1 {
    public void printComputer() {
        System.out.println("This is a MacbookPro");
    }
}
class SurfaceBookComputer1 implements Computer1 {
    public void printComputer() {
        System.out.println("This is a SurfaceBook");
    }
}
interface OperatingSystem {
    void printSystem();
}
class MacOsSystem implements OperatingSystem {
    public void printSystem() {
        System.out.println("This is a mac os");
    }
}
class Windows8System implements OperatingSystem {
    public void printSystem() {
        System.out.println("This is a window 8");
    }
}
interface ProductionFactory {
    Computer1 createComputer();
    OperatingSystem createSystem();
}
class AppleFactory implements ProductionFactory {
    public Computer1 createComputer() {
        return new MacbookProComputer1();
    }
    public OperatingSystem createSystem() {
        return new MacOsSystem();
    }
}
class MsFactory implements ProductionFactory {
    public Computer1 createComputer() {
        return new SurfaceBookComputer1();
    }
    public OperatingSystem createSystem() {
        return new Windows8System();
    }
}
public class Client {
    public void buyComputer(Computer1 computer1) {
        computer1.printComputer();
    }
    public void use(OperatingSystem s) {
        s.printSystem();
    }
    public static void main(String[] args) {
        Client client = new Client();
        ProductionFactory factory = new AppleFactory();
        Computer1 computer1 = factory.createComputer();
        OperatingSystem system = factory.createSystem();
        client.buyComputer(computer1);
        client.use(system);
    }
}

