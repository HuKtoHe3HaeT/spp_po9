interface Ship {
    void sail();
}

class CargoShip implements Ship {
    @Override
    public void sail() {
        System.out.println("Грузовой корабль плывет по воде.");
    }

    public void loadCargo() {
        System.out.println("Грузовой корабль загружает груз.");
    }
}

class Tanker implements Ship {
    @Override
    public void sail() {
        System.out.println("Танкер плывет по воде.");
    }

    public void loadOil() {
        System.out.println("Танкер загружает нефть.");
    }
}

public class Task_01 {
    public static void main(String[] args) {

        CargoShip cargoShip = new CargoShip();
        Tanker tanker = new Tanker();

        cargoShip.sail();
        cargoShip.loadCargo();

        tanker.sail();
        tanker.loadOil();
    }
}
