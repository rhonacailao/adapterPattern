// Target
interface PowerOutlet {
    void plugIn();
}

// Adaptee
class Laptop {
    public void charge() {
        System.out.println("Charging laptop..");
    }
}

class Refrigerator {
    public void startCooling() {
        System.out.println("Started cooling..");
    }
}

class SmartphoneCharger {
    public void chargePhone() {
        System.out.println("Charging phone..");
    }
}

// Adapter
class LaptopAdapter implements PowerOutlet {
    private Laptop laptop = new Laptop();

    @Override
    public void plugIn() {
        laptop.charge();
    }
}

class RefrigeratorAdapter implements PowerOutlet {
    private Refrigerator refrigerator = new Refrigerator();

    @Override
    public void plugIn() {
        refrigerator.startCooling();
    }
}

class SmartphoneChargerAdapter implements PowerOutlet {
    private SmartphoneCharger smartphoneCharger = new SmartphoneCharger();

    @Override
    public void plugIn() {
        smartphoneCharger.chargePhone();
    }
}

// Client Code
public class Main {
    public static void clientCode(PowerOutlet system) {
        system.plugIn();
    }

    public static void main(String[] args) {

        System.out.println("Plugging Devices into Power Outlets");
        // Using the Adapter
        LaptopAdapter laptopAdapter = new LaptopAdapter();
        clientCode(laptopAdapter);

        RefrigeratorAdapter refrigeratorAdapter = new RefrigeratorAdapter();
        clientCode(refrigeratorAdapter);

        SmartphoneChargerAdapter smartphoneChargerAdapter = new SmartphoneChargerAdapter();
        clientCode(smartphoneChargerAdapter);
    }
}