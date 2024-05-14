abstract class Transport {
    protected String name;
    protected int passengers;
    protected double cargoCapacity;

    public Transport(String name, int passengers, double cargoCapacity) {
        this.name = name;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
    }

    public abstract double calculatePassengerTime();

    public abstract double calculateCargoTime(double cargoWeight);

    public void displayInfo() {
        System.out.println("Транспортное средство: " + name);
        System.out.println("Количество пассажиров: " + passengers);
        System.out.println("Грузоподъемность: " + cargoCapacity + " кг");
    }
}

class Car extends Transport {
    private double speed;

    public Car(String name, int passengers, double cargoCapacity, double speed) {
        super(name, passengers, cargoCapacity);
        this.speed = speed;
    }

    @Override
    public double calculatePassengerTime() {
        double distance = 100;
        return distance / speed;
    }

    @Override
    public double calculateCargoTime(double cargoWeight) {
        return cargoWeight / cargoCapacity;
    }
}

class Bicycle extends Transport {
    private int speed;

    public Bicycle(String name, int passengers, double cargoCapacity, int speed) {
        super(name, passengers, cargoCapacity);
        this.speed = speed;
    }

    @Override
    public double calculatePassengerTime() {
        double distance = 100;
        return distance / speed;
    }

    @Override
    public double calculateCargoTime(double cargoWeight) {
        return 0;
    }
}

class Cart extends Transport {
    private int speed;

    public Cart(String name, int passengers, double cargoCapacity, int speed) {
        super(name, passengers, cargoCapacity);
        this.speed = speed;
    }

    @Override
    public double calculatePassengerTime() {
        double distance = 100;
        return distance / speed;
    }

    @Override
    public double calculateCargoTime(double cargoWeight) {
        return cargoWeight / cargoCapacity;
    }
}

public class Task_02 {
    public static void main(String[] args) {
        Transport car = new Car("Машина", 3, 500, 80);
        Transport bicycle = new Bicycle("Велосипед", 1, 10, 20);
        Transport cart = new Cart("Повозка", 2, 200, 10);

        car.displayInfo();
        System.out.println("Время перевозки пассажиров в машине: " + car.calculatePassengerTime() + " ч");
        System.out.println("Время перевозки груза в машине: " + car.calculateCargoTime(300) + " ч");

        bicycle.displayInfo();
        System.out.println("Время перевозки пассажира на велосипеде: " + bicycle.calculatePassengerTime() + " ч");

        cart.displayInfo();
        System.out.println("Время перевозки груза на повозке: " + cart.calculateCargoTime(150) + " ч");
    }
}
