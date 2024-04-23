package InvoicingSystem;

import java.util.*;

public class InvoicingShopSystem {
    private static Map<Integer, Integer> menuSelections = new HashMap<>();//for track menu selection
    static Shop shop=new Shop("new shop");
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {

            printMainMenu();
            int choice = getUserInput("Enter your choice: ");
            // Track menu selection dynamically
            // Increment the count of times each menu option is selected
            menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);// Update selection count

            switch (choice) {
                case 1:
                    handleShopSettings();
                    break;
                case 2:
                    handleManageShopItems();
                    break;
                case 3:
                    handleCreateNewInvoice();
                    break;
                case 4:
                    handleStatisticsReport();
                    break;
                case 5:
                    handleAllInvoicesReport();
                    break;
                case 6:
                    handleSearchInvoices();
                    break;
                case 7:
                    handleProgramStatistics();
                    break;
                case 8:
                     if (confirmExit()) {
                         running = false; // Exit the program
                     }
                     break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Exiting...");
    }
    // Display the main menu options
    private static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Shop Settings");
        System.out.println("2. Manage Shop Items");
        System.out.println("3. Create New Invoice");
        System.out.println("4. Report: Statistics");
        System.out.println("5. Report: All Invoices");
        System.out.println("6. Search Invoices");
        System.out.println("7. Program Statistics");
        System.out.println("8. Exit");
    }
    //Ask user to enter choice
    private static int getUserInput(String s) {
        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        return choice;

    }
    //**************** shop settings menu ***********************//
    private static void handleShopSettings() {
        boolean backToMain = false;
        // Loop to handle shop settings menu until user chooses to go back
        while (!backToMain) {
            System.out.println("\nShop Settings Menu:");
            System.out.println("1. Load Data (Items and Invoices)");
            System.out.println("2. Set Shop Name");
            System.out.println("3. Set Invoice Header");
            System.out.println("4. Go Back to Main Menu");

            int choice = getUserInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    loadDefaultData();
                    break;
                case 2:

                    setShopName();
                    break;
                case 3:
                    setInvoiceHeader();
                    break;
                case 4:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // Method to load default data (items and invoices) into the shop
    private static void loadDefaultData() {
        shop.loadDefaultItems();
        shop.loadDefaultInvoices();
        System.out.println("Default Data loaded successfully.");
    }
    // Method to change shop Name
    private static void setShopName() {
        shop.changeShopName();
    }
    //Method to set Invoice Header
    private static void setInvoiceHeader() {
        shop.setInvoiceHeader();
        // Retrieve and display the invoice header details
        System.out.println("\nInvoice Header Details:");
        System.out.println("Telephone: " + shop.getInvoiceHeader().get("Telephone"));
        System.out.println("Fax: " + shop.getInvoiceHeader().get("Fax"));
        System.out.println("Email: " + shop.getInvoiceHeader().get("Email"));
        System.out.println("Website: " + shop.getInvoiceHeader().get("Website"));


    }
    //**************** shop management menu ***********************//

    private static void handleManageShopItems() {

        boolean backToMain = false;

        while (!backToMain) {
            System.out.println("\nManage Shop Items Menu:");
            System.out.println("1. Add New Item");
            System.out.println("2. Delete Item");
            System.out.println("3. Change Item Price");
            System.out.println("4. Report All Items");
            System.out.println("5. Go Back to Main Menu");

            Integer choice = getUserInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    shop.addNewItem();
                    break;
                case 2:
                   shop.deleteItem();
                    break;
                case 3:
                    shop.changeItemPrice();
                    break;
                 case 4:
                      shop.reportAllItems();
                     break;
                case 5:
                     backToMain = true;
                     break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Method to create new invoice
   private static void handleCreateNewInvoice() {
        Invoice.createNewInvoice();
   }
    //Method to generate Statistics Report
    private static void handleStatisticsReport() {
        shop.generateStatisticsReport();
    }
   // Method to display all invoices report
    private static void handleAllInvoicesReport() {
        shop.handleAllInvoicesReport();
    }
    // Method for search invoices
    private static void handleSearchInvoices() {
        shop.handleSearchInvoices();
    }
   //Method to display program statics
    private static void handleProgramStatistics() {
        System.out.println("Program Statistics Menu:");
        for (Map.Entry<Integer, Integer> entry : menuSelections.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + ": " + entry.getValue() + " times selected");
        }
    }
   //  Prompts the user to confirm whether they want to exit the program.
    private static boolean confirmExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to exit? (yes/no)");
        String input = scanner.nextLine().trim().toLowerCase(); // Read user input and normalize
        scanner.close(); // Close the scanner to prevent resource leak

        return input.equals("yes");
    }
    }
















