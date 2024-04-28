package InvoicingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static InvoicingSystem.InvoicingShopSystem.scanner;
import static InvoicingSystem.InvoicingShopSystem.shop;

public class Shop {
         Integer id;
         String shopName;
         private Map<String, String> invoiceHeader;
         List<Item> items;
         List<Invoice> invoices;

    public Shop(String shopName) {
            this.shopName = shopName;
            this.items = new ArrayList<>();
            this.invoices = new ArrayList<>();
            this.invoiceHeader =new HashMap<>(); // Initialize the ArrayList
        }
    // Method to load default items
    public void loadDefaultItems() {
        // Load default items into the items list
        items.add(new Item(3, "Milk", 0.80, 20));
        items.add(new Item(4, "Bread", 1.00, 30));
    }
   //Method to load default invoices
   public void loadDefaultInvoices() {
        // Load default invoices into the invoices list
        invoices.add(new Invoice("Ali", "96011123"));
        invoices.add(new Invoice("Ahmed", "99883399"));

        // Create a new invoice with items and add it to invoices
        Invoice nasserInvoice = new Invoice("Nasser", "94582984");
        nasserInvoice.addItem(new Item(1, "Apple", 0.99, 5));
        nasserInvoice.addItem(new Item(2, "Banana", 0.59, 3));
        invoices.add(nasserInvoice);
    }
   // Method to set invoice header
    public void setInvoiceHeader() {
        System.out.println("Set Invoice Header:");

        // Prompt for telephone number
        System.out.print("Enter telephone number: ");
        String telephone = scanner.nextLine().trim();
        if (!Validation.isValidPhoneNumber(telephone)) {
            System.out.println("Invalid telephone number format. Please enter a valid 8-digit phone number.");
            return; // Exit method if validation fails
        }
        invoiceHeader.put("Telephone", telephone);

        // Prompt for fax number
        System.out.print("Enter fax number: ");
        String fax = scanner.nextLine().trim();
        if (!Validation.isValidString(fax)) {
            System.out.println("Invalid fax number format. Please enter a valid number.");
            return; // Exit method if validation fails
        }
        invoiceHeader.put("Fax", fax);

        // Prompt for email address
        System.out.print("Enter email address: ");
        String email = scanner.nextLine().trim();
        if (!Validation.isValidEmail(email)) {
            System.out.println("Invalid email address format. Please enter a valid email address.");
            return; // Exit method if validation fails
        }
        invoiceHeader.put("Email", email);

        // Prompt for website URL
        System.out.print("Enter website URL: ");
        String website = scanner.nextLine().trim();
        if (!Validation.isValidURL(website)) {
            System.out.println("Invalid website URL format. Please enter a valid URL.");
            return; // Exit method if validation fails
        }
        invoiceHeader.put("Website", website);

        System.out.println("Invoice header set successfully.");
    }

    public Map<String, String> getInvoiceHeader() {
        return invoiceHeader;
    }
    //Method to add items to items list
    public void addNewItem()
        {
            // ask user to enter item ID and check validation
            System.out.print("Enter item ID: ");
            int id;
            while (true) {
                try {
                    id = Integer.parseInt(scanner.nextLine().trim());
                    if (Validation.isPositiveNumber(id)) {
                        break;
                    } else {
                        System.out.println("Invalid item ID. Please enter a positive integer.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid item ID. Please enter a valid integer.");
                }
            }

            // ask user to enter item name and check validation
            System.out.print("Enter item name: ");
            String name = scanner.nextLine().trim();
            if (!Validation.isValidString(name)) {
                System.out.println("Invalid item name. Please provide a non-empty name.");
                return;
            }

            //  // ask user to enter item price and check validation
            System.out.print("Enter unit price: ");
            double price;
            while (true) {
                try {
                    price = Double.parseDouble(scanner.nextLine().trim());
                    if (Validation.isPositiveNumber(price)) {
                        break;
                    } else {
                        System.out.println("Invalid unit price. Please enter a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid unit price. Please enter a valid number.");
                }
            }
            // ask user to enter item quantity and check validation
            System.out.print("Enter quantity: ");
            int quantity;
            while (true) {
                try {
                    quantity = Integer.parseInt(scanner.nextLine().trim());
                    if (Validation.isPositiveNumber(quantity)) {
                        break;
                    } else {
                        System.out.println("Invalid quantity. Please enter a positive integer.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity. Please enter a valid integer.");
                }
            }

            // All inputs are valid, create and add new item
            Item newItem = new Item(id, name, price, quantity);
            items.add(newItem);
            System.out.println("Item added successfully.");
        }
     // method for delete items
    public void deleteItem() {
        System.out.print("Enter Item ID to delete: ");
        int itemId;
        while (true) {
            try {
                itemId = Integer.parseInt(scanner.nextLine().trim());
                if (Validation.isPositiveNumber(itemId)) {
                    break;
                } else {
                    System.out.println("Invalid item ID. Please provide a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid item ID. Please enter a valid integer.");
            }
        }

        // Find the item to remove based on the provided ID
        Item itemToRemove = null;
        for (Item item : items) {
            if (item.getId() == itemId) {
                itemToRemove = item;
                break;
            }
        }

        // Check if item to remove was found
        if (itemToRemove != null) {
            items.remove(itemToRemove);
            System.out.println("Item with ID " + itemId + " deleted successfully.");
        } else {
            System.out.println("Item with ID " + itemId + " does not exist.");
        }
    }
    // method for change item price
    public void changeItemPrice() {

        System.out.print("Enter Item ID to change price: ");
        int itemId;
        while (true) {
            try {
                itemId = Integer.parseInt(scanner.nextLine().trim());
                if (Validation.isPositiveNumber(itemId)) {
                    break;
                } else {
                    System.out.println("Invalid item ID. Please provide a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid item ID. Please enter a valid integer.");
            }
        }

        System.out.print("Enter new price: ");
        double newPrice;
        while (true) {
            try {
                newPrice = Double.parseDouble(scanner.nextLine().trim());
                if (Validation.isPositiveNumber(newPrice)) {
                    break;
                } else {
                    System.out.println("Invalid price. Please provide a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid number.");
            }
        }

        // Search for the item with the specified ID and update its price
        boolean itemFound = false;
        for (Item item : items) {
            if (item.getId() == itemId) {
                item.setUnitPrice(newPrice);
                System.out.println("Price for item with ID " + itemId + " changed successfully.");
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            System.out.println("Item with ID " + itemId + " does not exist.");
        }
        }
    //Method to report all items
    public  void reportAllItems(){
            List<Item> items = shop.getAllItems();
            if (items.isEmpty()) {
                System.out.println("No items found.");
            } else {
                System.out.println("All Shop Items:");
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        }
    //Method to find items by itemId
   public Item findItemById(Integer itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item; // Return the item if found
            }
        }
        return null; // Return null if item with specified ID is not found
    }
   //Method to add invoice to invoices List
   public void addInvoice(Invoice invoice) {
            invoices.add(invoice); // Add a new invoice to the shop
    }
    // method for get all items
        public List<Item> getAllItems() {
            return items;
        }
    // method for get all invoices
    public List<Invoice> getAllInvoices() {
            return invoices;
        }
    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }
    public void changeShopName() {
        System.out.print("Enter new shop name: ");
        String newName = scanner.nextLine();
        if (Validation.isValidString(newName)) {
            shop.setShopName(newName);
            System.out.println("Shop name updated successfully.");
        } else {
            System.out.println("Invalid shop name. Please enter a valid name.");
        }
    }
//
    static void displayAllItems() {
        List<Item> items = shop.getAllItems();
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Available Items:");
            for (Item item : items) {
                System.out.println(item.getId() + ": " + item.getName() + " - $" + item.getUnitPrice());
            }
        }
    }

    public List<Item> getItems() {

            return items;
    }

    public void setItems(List<Item> items) {

        this.items = items;
    }

    public List<Invoice> getInvoices() {

        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {

        this.invoices = invoices;
    }//Method to generate statistics report
    public void generateStatisticsReport(){
        // Get statistics from the shop
        int itemCount = shop.getAllItems().size();
        int invoiceCount = shop.getAllInvoices().size();
        double totalSales = calculateTotalSales();

        // Display statistics
        System.out.println("\nStatistics Report:");
        System.out.println("Number of Items: " + itemCount);
        System.out.println("Number of Invoices: " + invoiceCount);
        System.out.println("Total Sales: $" + totalSales);
    }
    //Method to calculate total sales
    private static double calculateTotalSales() {
        List<Invoice> invoices = shop.getAllInvoices();
        double totalSales = 0.0;

        for (Invoice invoice : invoices) {
            totalSales += invoice.calculateTotal();
        }
        return totalSales;
    }
   //Method to display all invoices report
    public void handleAllInvoicesReport() {
        System.out.println("\nAll Invoices Report:");
        if (invoices.isEmpty()) {
            System.out.println("No invoices found.");
        } else {
            for (Invoice invoice : invoices) {
                System.out.println("-----------------------------------");
                System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
                System.out.println("Customer: " + invoice.getCustomerName());
                System.out.println("Number of Items: " + invoice.getItems().size());
                System.out.println("Total Amount: $" + invoice.calculateTotal());
                System.out.println("Balance: $" + invoice.getBalance());
                System.out.println("-----------------------------------");
            }
        }
    }
    //Method for search invoices by invoice number
    public void handleSearchInvoices() {
        System.out.println("\nSearch Invoices:");
        // Validate and prompt user to enter invoice number
        int invoiceNumber;
        do {
            System.out.print("Enter invoice number to search: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid invoice number.");
                scanner.next(); // Clear invalid input
            }
            invoiceNumber = scanner.nextInt();
        } while (invoiceNumber <= 0);

        // Flag to track if the invoice was found
        boolean found = false;
        // Search for the invoice with the specified invoice number
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceNumber() == invoiceNumber) {
                found = true;
                displayInvoiceDetails(invoice);
                break;
            }
        }
        // If invoice was not found, display appropriate message
        if (!found) {
            System.out.println("Invoice with number " + invoiceNumber + " not found.");
        }
    }
   //Method to display all invoice details
    private void displayInvoiceDetails(Invoice invoice) {
        System.out.println("\nInvoice Details:");
        System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
        System.out.println("Customer Name: " + invoice.getCustomerName());
        System.out.println("Phone Number: " + invoice.getPhoneNumber());

        // Display items in the invoice
        System.out.println("Items:");
        List<Item> items = invoice.getItems();
        for (Item item : items) {
            System.out.println("- " + item.getName() + " (Qty: " + item.getQuantity() + ", Unit Price: $" + item.getUnitPrice() + ")");
        }

        System.out.println("Total Amount: $" + String.format("%.2f", invoice.calculateTotal()));
        System.out.println("Balance: $" + String.format("%.2f", invoice.getBalance()));
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", items=" + items +
                ", invoices=" + invoices +
                '}';
    }
}

