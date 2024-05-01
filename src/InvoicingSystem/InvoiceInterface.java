package InvoicingSystem;

import java.util.List;

public interface InvoiceInterface {
    Integer getInvoiceNumber();
    String getCustomerName();

    String getPhoneNumber();

    // Get the list of items included in the invoice
    List<Item> getItems();

    Double getBalance();
    Double calculateTotal();

    void addItem(Item item);

}
