import java.util.List;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.loadProductsFromFile("F:\\Java\\SPP_Lab3\\src\\products.txt");

        List<Product> productList = warehouse.generateProductList();
        System.out.println("\tСписок всех продуктов");
        for (Product product : productList) {
            System.out.println(product.getName() +
                    ":" + product.getManufacturer());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tВведите название товара для поиска:");
        String productName = scanner.nextLine();

        System.out.println("Введите максимальную цену:");
        double maxPrice = scanner.nextDouble();

        System.out.println("\nПродукты с наименованием '" + productName + "':");
        List<Product> namedProducts = warehouse.findProductsByName(productName);
        for (Product product : namedProducts) {
            System.out.println(product.getName() + " - " + product.getManufacturer() + "-" + product.getQuantity() + " шт.");
        }

        System.out.println("\nПродукты с наименованием '" + productName + "' и ценой не более " + maxPrice + ":");
        List<Product> cheapNamedProducts = warehouse.findProductsByNameAndPrice(productName, maxPrice);
        for (Product product : cheapNamedProducts) {
            System.out.println(product.getName() + " - " + product.getManufacturer()+ " - " + product.getPrice());
        }

        System.out.println("\nИстекший срок хранения продуктов:");
        List<Product> expiredProducts = warehouse.findExpiredProducts();
        for (Product product : expiredProducts) {
            System.out.println(product.getName() +"-"+product.getManufacturer());
        }
    }
}
