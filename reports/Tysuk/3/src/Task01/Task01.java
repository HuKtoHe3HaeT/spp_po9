import java.util.ArrayList;

public class Task01 {
    private ArrayList<Double> numbers;

    public Task01() {
        this.numbers = new ArrayList<>();
    }

    public Task01(ArrayList<Double> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public void add(double number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public void remove(double number) {
        numbers.remove(number);
    }

    public boolean contains(double number) {
        return numbers.contains(number);
    }

    public Task01 intersection(Task01 otherSet) {
        ArrayList<Double> intersectionList = new ArrayList<>();
        for (Double num : numbers) {
            if (otherSet.contains(num)) {
                intersectionList.add(num);
            }
        }
        return new Task01(intersectionList);
    }

    public void print() {
        System.out.println(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task01 that = (Task01) obj;
        return numbers.equals(that.numbers);
    }

    public static void main(String[] args) {
        Task01 set1 = new Task01();
        set1.add(1.5);
        set1.add(2.5);
        set1.add(3.5);
        System.out.println("Set 1: " + set1);

        Task01 set2 = new Task01();
        set2.add(2.5);
        set2.add(3.5);
        set2.add(4.5);
        System.out.println("Set 2: " + set2);

        Task01 intersectionSet = set1.intersection(set2);
        System.out.println("Intersection: " + intersectionSet);

        System.out.println("Does set 1 equal set 2? " + set1.equals(set2));
        System.out.println("Does set 1 equal itself? " + set1.equals(set1));
    }
}

