public class Wheel {
    private double diameter;
    private boolean isPunctured;

    public Wheel(double diameter) {
        this.diameter = diameter;
        this.isPunctured = false;
    }

    public boolean isPunctured() {
        return isPunctured;
    }

    public void puncture() {
        isPunctured = true;
        System.out.println("The wheel is punctured!");
    }

    public void replaceWheel() {
        isPunctured = false;
        System.out.println("The wheel is replaced.");
    }

    public double getDiameter() {
        return diameter;
    }
}

