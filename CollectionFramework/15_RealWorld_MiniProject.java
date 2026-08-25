import java.util.*;
import java.util.stream.Collectors;

/**
 * ==============================================================================
 * MODULE 15: REAL-WORLD MINI PROJECT - E-COMMERCE ORDER & INVENTORY HUB
 * ==============================================================================
 * 
 * INTEGRATES ALL CORE COLLECTION CONCEPTS:
 * 1. Map<String, Product>: Fast O(1) inventory lookup and quantity tracking.
 * 2. Set<String>: Category catalog and unique SKU enforcement.
 * 3. PriorityQueue<Order>: Expedited vs Standard order processing queue (Heap).
 * 4. Deque<AuditLog>: Activity undo/audit trail (sliding window / recent events).
 * 5. List<OrderItem>: Order cart representation.
 * 6. Stream API: Aggregations, revenue analytics, and stock filtering.
 */

// Model: Product
class Product {
    private final String sku;
    private final String name;
    private final String category;
    private double price;
    private int stock;

    public Product(String sku, String name, String category, double price, int stock) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int qty) { this.stock -= qty; }
    public void addStock(int qty) { this.stock += qty; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() { return Objects.hash(sku); }

    @Override
    public String toString() {
        return String.format("[%s] %-20s | Cat: %-12s | Price: $%-7.2f | Stock: %d",
                sku, name, category, price, stock);
    }
}

// Model: Order with Priority (1 = Express/VIP, 2 = Standard)
class Order {
    private final int orderId;
    private final String customerName;
    private final Map<String, Integer> items; // SKU -> Quantity
    private final int priorityLevel; // 1 (High/Express), 2 (Standard)
    private final double totalAmount;

    public Order(int orderId, String customerName, Map<String, Integer> items, int priorityLevel, double totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.priorityLevel = priorityLevel;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public Map<String, Integer> getItems() { return items; }
    public int getPriorityLevel() { return priorityLevel; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        String tier = (priorityLevel == 1) ? "EXPRESS" : "STANDARD";
        return String.format("Order #%d [%s] Customer: %-12s | Total: $%-7.2f | Items: %s",
                orderId, tier, customerName, totalAmount, items);
    }
}

// Main Store Service
class WarehouseService {
    // 1. Inventory Map (SKU -> Product)
    private final Map<String, Product> inventory = new HashMap<>();

    // 2. Set of Unique Categories
    private final Set<String> categories = new TreeSet<>();

    // 3. Priority Order Queue (Express orders served before standard orders)
    private final PriorityQueue<Order> orderQueue = new PriorityQueue<>(
        Comparator.comparingInt(Order::getPriorityLevel)
                  .thenComparingInt(Order::getOrderId)
    );

    // 4. Activity Log (Recent 10 operations)
    private final Deque<String> recentAuditLogs = new ArrayDeque<>();

    public void addProduct(Product p) {
        inventory.put(p.getSku(), p);
        categories.add(p.getCategory());
        logAction("Added Product: " + p.getName() + " (" + p.getSku() + ")");
    }

    public void placeOrder(int id, String customer, Map<String, Integer> cart, boolean isExpress) {
        double total = 0;
        // Verify stock
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String sku = entry.getKey();
            int qty = entry.getValue();
            Product p = inventory.get(sku);
            if (p == null || p.getStock() < qty) {
                System.out.println("❌ Cannot place order #" + id + ": Insufficient stock for SKU " + sku);
                return;
            }
            total += p.getPrice() * qty;
        }

        // Deduct inventory
        cart.forEach((sku, qty) -> inventory.get(sku).reduceStock(qty));

        Order order = new Order(id, customer, cart, isExpress ? 1 : 2, total);
        orderQueue.offer(order);
        logAction("Placed " + (isExpress ? "EXPRESS " : "") + "Order #" + id + " for " + customer);
        System.out.println("✅ Order Placed Successfully: " + order);
    }

    public void fulfillNextOrder() {
        Order order = orderQueue.poll();
        if (order == null) {
            System.out.println("No pending orders in queue.");
            return;
        }
        System.out.println("📦 FULFILLING: " + order);
        logAction("Fulfilled Order #" + order.getOrderId());
    }

    private void logAction(String action) {
        if (recentAuditLogs.size() >= 5) {
            recentAuditLogs.pollFirst(); // Remove oldest log
        }
        recentAuditLogs.offerLast(action);
    }

    public void printInventorySummary() {
        System.out.println("\n================ CURRENT INVENTORY ================");
        inventory.values().forEach(System.out::println);
        System.out.println("Available Categories: " + categories);
    }

    public void printAnalytics() {
        System.out.println("\n================ STORE ANALYTICS (STREAMS) ================");
        
        // Total value of in-stock inventory
        double totalStockValue = inventory.values().stream()
            .mapToDouble(p -> p.getPrice() * p.getStock())
            .sum();
        System.out.printf("Total Inventory Value: $%,.2f%n", totalStockValue);

        // Low stock items (stock < 10)
        List<Product> lowStock = inventory.values().stream()
            .filter(p -> p.getStock() < 10)
            .collect(Collectors.toList());
        System.out.println("Low Stock Warning (< 10 units): " + lowStock.stream().map(Product::getName).collect(Collectors.toList()));

        // Products grouped by category
        System.out.println("\nProducts Count by Category:");
        Map<String, Long> countByCat = inventory.values().stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        countByCat.forEach((cat, count) -> System.out.printf("  %-15s -> %d items%n", cat, count));
    }

    public void printAuditLogs() {
        System.out.println("\n================ RECENT AUDIT TRAIL (DEQUE) ================");
        recentAuditLogs.forEach(log -> System.out.println("  • " + log));
    }
}

class RealWorld_MiniProject {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   WELCOME TO SMART WAREHOUSE & ORDER FULFILLMENT HUB   ");
        System.out.println("==================================================================");

        WarehouseService warehouse = new WarehouseService();

        // 1. Seed Products
        warehouse.addProduct(new Product("SKU-101", "MacBook Pro M3", "Electronics", 1999.99, 15));
        warehouse.addProduct(new Product("SKU-102", "Sony Headphones", "Audio", 349.99, 8));
        warehouse.addProduct(new Product("SKU-103", "Mechanical Keyboard", "Accessories", 129.99, 25));
        warehouse.addProduct(new Product("SKU-104", "Dell 4K Monitor", "Electronics", 599.99, 5));
        warehouse.addProduct(new Product("SKU-105", "Logitech Mouse", "Accessories", 79.99, 30));

        warehouse.printInventorySummary();

        // 2. Place Orders (Mix of Standard and Express)
        System.out.println("\n--- PLACING ORDERS ---");
        Map<String, Integer> cart1 = Map.of("SKU-101", 1, "SKU-105", 2);
        warehouse.placeOrder(1001, "Alice Smith", cart1, false); // Standard

        Map<String, Integer> cart2 = Map.of("SKU-102", 1, "SKU-103", 1);
        warehouse.placeOrder(1002, "Bob VIP", cart2, true); // Express (Should jump ahead in queue)

        Map<String, Integer> cart3 = Map.of("SKU-104", 1);
        warehouse.placeOrder(1003, "Charlie Express", cart3, true); // Express

        // 3. Fulfill Orders from Priority Queue
        System.out.println("\n--- ORDER FULFILLMENT (PRIORITY QUEUE) ---");
        warehouse.fulfillNextOrder(); // Should fulfill Bob VIP (Express)
        warehouse.fulfillNextOrder(); // Should fulfill Charlie Express (Express)
        warehouse.fulfillNextOrder(); // Should fulfill Alice Smith (Standard)

        // 4. Analytics & Audit Trail
        warehouse.printAnalytics();
        warehouse.printAuditLogs();
        warehouse.printInventorySummary();
    }
}
