public class Car {
    private String brand;
    private String model;
    private Wheel[] wheels;

    public Car(String brand, String model, double wheelDiameter) {
        this.brand = brand;
        this.model = model;
        this.wheels = new Wheel[4];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel(wheelDiameter);
        }
    }

    public boolean isAnyWheelPunctured() {
        for (Wheel wheel : wheels) {
            if (wheel.isPunctured()) {
                return true;
            }
        }
        return false;
    }

    public void replacePuncturedWheel() {
        for (Wheel wheel : wheels) {
            if (wheel.isPunctured()) {
                wheel.replaceWheel();
                return;
            }
        }
        System.out.println("No punctured wheels found.");
    }

    public void displayCarInfo() {
        System.out.println("Car: " + brand + " " + model);
        System.out.println("Wheels:");
        for (int i = 0; i < wheels.length; i++) {
            System.out.println("Wheel " + (i + 1) + ": Diameter - " + wheels[i].getDiameter() + " inches, Punctured - " + (wheels[i].isPunctured() ? "Yes" : "No"));
        }
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 16.0);

        car.getWheels()[2].puncture();

        car.displayCarInfo();

        car.replacePuncturedWheel();

        car.displayCarInfo();
    }
}
