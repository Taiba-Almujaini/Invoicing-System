package InvoicingSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Menu {

    private Scanner scanner;
    private Map<Integer, Integer> menuSelections = new HashMap<>();
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int displayMainMenuAndGetChoice() {
        System.out.println("Main Menu:");
        System.out.println("1. Shop Settings");
        System.out.println("2. Manage Shop Items");
        System.out.println("3. Create New Invoice");
        System.out.println("4. Report: Statistics");
        System.out.println("5. Report: All Invoices");
        System.out.println("6. Search Invoices");
        System.out.println("7. Program Statistics");
        System.out.println("8. Exit");

        return getUserInput("Enter your choice: ");
    }

    public int displayShopSettingsMenuAndGetChoice() {
        System.out.println("\nShop Settings Menu:");
        System.out.println("1. Load Data (Items and Invoices)");
        System.out.println("2. Set Shop Name");
        System.out.println("3. Set Invoice Header");
        System.out.println("4. Go Back to Main Menu");

        return getUserInput("Enter your choice: ");
    }

    public int displayManageShopItemsMenuAndGetChoice() {
        System.out.println("\nManage Shop Items Menu:");
        System.out.println("1. Add New Item");
        System.out.println("2. Delete Item");
        System.out.println("3. Change Item Price");
        System.out.println("4. Report All Items");
        System.out.println("5. Go Back to Main Menu");

        return getUserInput("Enter your choice: ");
    }

    public boolean confirmExit() {
        System.out.println("Are you sure you want to exit? (yes/no)");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes");
    }

    private static int getUserInput(String s) {
        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        return choice;

    }

    public void trackMenuSelection(Integer choice) {
        menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);
    }

    public void displayProgramStatistics() {
        System.out.println("Program Statistics:");
        for (Map.Entry<Integer, Integer> entry : menuSelections.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + ": " + entry.getValue() + " times selected");
        }
    }
}

