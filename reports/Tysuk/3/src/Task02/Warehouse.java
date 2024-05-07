import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products;

    public Warehouse() {
        products = new ArrayList<>();
    }

    public void loadProductsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String upc = parts[2];
                String manufacturer = parts[3];
                double price = Double.parseDouble(parts[4]);
                int shelfLife = Integer.parseInt(parts[5]);
                int quantity = Integer.parseInt(parts[6]);
                Product product = new Product(id, name, upc, manufacturer, price, shelfLife, quantity);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> generateProductList() {
        return new ArrayList<>(products);
    }


    public List<Product> findProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductsByNameAndPrice(String name, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findExpiredProducts() {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getShelfLife() == 0) {
                result.add(product);
            }
        }
        return result;
    }
}
