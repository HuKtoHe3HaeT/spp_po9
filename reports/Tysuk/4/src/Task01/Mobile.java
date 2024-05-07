import java.util.HashMap;
import java.util.Map;

public class Mobile {

    private class PhoneModel {
        private String modelName;
        private String brand;
        private int yearReleased;

        public PhoneModel(String modelName, String brand, int yearReleased) {
            this.modelName = modelName;
            this.brand = brand;
            this.yearReleased = yearReleased;
        }

        public String getModelName() {
            return modelName;
        }

        public String getBrand() {
            return brand;
        }

        public int getYearReleased() {
            return yearReleased;
        }
    }

    private Map<String, PhoneModel> phoneModels;

    public Mobile() {
        phoneModels = new HashMap<>();
    }

    public void addPhoneModel(String modelName, String brand, int yearReleased) {
        PhoneModel model = new PhoneModel(modelName, brand, yearReleased);
        phoneModels.put(modelName, model);
    }

    public void getPhoneModelInfo(String modelName) {
        PhoneModel model = phoneModels.get(modelName);
        if (model != null) {
            System.out.println("Model Name: " + model.getModelName());
            System.out.println("Brand: " + model.getBrand());
            System.out.println("Year Released: " + model.getYearReleased());
        } else {
            System.out.println("Model not found!");
        }
    }

    public void displayAllPhoneModels() {
        System.out.println("All Phone Models:");
        for (PhoneModel model : phoneModels.values()) {
            System.out.println("Model Name: " + model.getModelName() +
                    ", Brand: " + model.getBrand() +
                    ", Year Released: " + model.getYearReleased());
        }
    }

    public static void main(String[] args) {
        Mobile mobile = new Mobile();

        mobile.addPhoneModel("iPhone 13", "Apple", 2021);
        mobile.addPhoneModel("Galaxy S21", "Samsung", 2021);
        mobile.addPhoneModel("Pixel 6", "Google", 2021);

        mobile.getPhoneModelInfo("iPhone 13");

        mobile.displayAllPhoneModels();
    }
}
