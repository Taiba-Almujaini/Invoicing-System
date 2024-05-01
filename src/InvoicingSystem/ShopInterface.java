package InvoicingSystem;

import java.util.List;

public interface ShopInterface {

    void loadDefaultItems();

    void loadDefaultInvoices();

    void setInvoiceHeader();
    void addNewItem();
    void deleteItem();
    void changeItemPrice();
    void reportAllItems();

    Item findItemById(Integer itemId);

    void addInvoice(Invoice invoice);
    List<Invoice> getAllInvoices();

    void changeShopName();
    void displayAllItems();

    List<Item> getItems();

    void generateStatisticsReport();
    void handleAllInvoicesReport();
    void handleSearchInvoices();

    void displayInvoiceDetails(Invoice invoice);
}
