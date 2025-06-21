import java.util.*;

class Product {
    int id;
    String name;
    String category;

    Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String toString() {
        return id + " - " + name + " (" + category + ")";
    }
}

public class Main {
    
    // Linear search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.id == targetId)
                return p;
        }
        return null;
    }

    // Binary search (assumes products sorted by id)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].id == targetId)
                return products[mid];
            else if (products[mid].id < targetId)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Shampoo", "Personal Care"),
            new Product(103, "Mobile", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(104, "Book", "Education")
        };

        // Linear Search
        int targetId = 104;
        Product result1 = linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not found"));

        // Binary Search (sort first by ID)
        Arrays.sort(products, Comparator.comparingInt(p -> p.id));
        Product result2 = binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not found"));
    }
}
