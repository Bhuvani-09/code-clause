import java.util.Scanner;

public class ECommerceSystem {
    private static Product[] products = {
        new Product("Laptop", 999.99),
        new Product("Smartphone", 499.99),
        new Product("Headphones", 149.99)
    };

    private static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    checkout();
                    running = false;
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void viewProducts() {
        System.out.println("Available Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    private static void addToCart(Scanner scanner) {
        viewProducts();
        System.out.println("Enter the product number to add to cart:");
        int productNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (productNumber > 0 && productNumber <= products.length) {
            cart.addProduct(products[productNumber - 1]);
            System.out.println(products[productNumber - 1].getName() + " added to cart.");
        } else {
            System.out.println("Invalid product number.");
        }
    }

    private static void checkout() {
        cart.viewCart();
        System.out.println("Thank you for your purchase! Your total is $" + cart.getTotal());
    }
}
