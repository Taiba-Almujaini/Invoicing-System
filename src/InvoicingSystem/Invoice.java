package InvoicingSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static InvoicingSystem.InvoicingShopSystem.scanner;
import static InvoicingSystem.InvoicingShopSystem.shop;

public class Invoice {
    Integer id;
     Integer invoiceNumber;
     String customerName;
     String phoneNumber;
     Date invoiceDate;
     List<Item> items;
     Double totalAmount;
    Double paidAmount;

    private static Integer nextInvoiceNumber = 1;  // Static variable to track next invoice ID

    public Invoice(String customerName, String phoneNumber) {
        this.id = null;
        this.invoiceNumber = nextInvoiceNumber++; // Assign unique invoice number
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.paidAmount = 0.0;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNumber=" + invoiceNumber +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                '}';
    }
    //Method to add  items and update the total amount
    public void addItem(Item item) {
        items.add(item);
        totalAmount += item.getUnitPrice() * item.getQuantity();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {

        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {

        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<Item> getItems() {

        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaidAmount() {

        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {

        this.paidAmount = paidAmount;
    }
    public double getBalance() {

        return totalAmount - paidAmount;
    }
    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getUnitPrice() * item.getQuantity();
        }
        return total;
    }
    //Method to create new invoices
    public static void createNewInvoice() {

        System.out.println("Enter Invoice Header Details:");

        // Validate customer name
        String customerName;
        do {
            System.out.print("Enter customer name: ");
            customerName = scanner.nextLine().trim();
            if (!Validation.isValidString(customerName)) {
                System.out.println("Customer name cannot be empty. Please try again.");
            }
        } while (!Validation.isValidString(customerName));

        // Validate phone number
        String phoneNumber;
        do {
            System.out.print("Enter customer phone number: ");
            phoneNumber = scanner.nextLine().trim();
            if (!Validation.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number format. Please enter 8 digit number.");
            }
        } while (!Validation.isValidPhoneNumber(phoneNumber));
            // Create a new Invoice object
            Invoice newInvoice = new Invoice(customerName, phoneNumber);
            shop.displayAllItems();

            // Add items to the invoice
            boolean addingItems = true;
            while (addingItems) {
                System.out.print("Enter item ID to add to the invoice (0 to finish): ");
                int itemId = scanner.nextInt();

                if (itemId == 0) {
                    addingItems = false;
                } else {
                    Item item = shop.findItemById(itemId);
                    if (item != null) {
                        newInvoice.addItem(item);
                        System.out.println("Item added: " + item.getName());
                    } else {
                        System.out.println("Item not found with ID: " + itemId);
                    }
                }
            }

            // Add the new invoice to the shop
            shop.addInvoice(newInvoice);
            System.out.println("Invoice created successfully.");
        }


    }

