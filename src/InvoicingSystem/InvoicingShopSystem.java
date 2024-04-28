package InvoicingSystem;

import java.util.*;

public class InvoicingShopSystem {
    public static Scanner scanner = new Scanner(System.in);
    private static Menu menuManager = new Menu(scanner);
    public static Shop shop = new Shop("new shop");

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            int choice = menuManager.displayMainMenuAndGetChoice();
            menuManager.trackMenuSelection(choice);

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
                    menuManager.displayProgramStatistics();
                    break;
                case 8:
                    if (menuManager.confirmExit()) {
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

    private static void handleShopSettings() {
        boolean backToMain = false;
        while (!backToMain) {
            int choice = menuManager.displayShopSettingsMenuAndGetChoice();
            switch (choice) {
                case 1:
                    loadDefaultData();
                    break;
                case 2:
                    shop.changeShopName();
                    break;
                case 3:
                    shop.setInvoiceHeader();
                    break;
                case 4:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleManageShopItems() {
        boolean backToMain = false;
        while (!backToMain) {
            int choice = menuManager.displayManageShopItemsMenuAndGetChoice();
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

    private static void handleCreateNewInvoice() {
        Invoice.createNewInvoice();
    }

    private static void handleStatisticsReport() {
        shop.generateStatisticsReport();
    }

    private static void handleAllInvoicesReport() {
        shop.handleAllInvoicesReport();
    }

    private static void handleSearchInvoices() {
        shop.handleSearchInvoices();
    }

    private static void loadDefaultData() {
        shop.loadDefaultItems();
        shop.loadDefaultInvoices();
        System.out.println("Default Data loaded successfully.");
    }
    }
















