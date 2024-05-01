package InvoicingSystem;

public interface ItemInterface {


    Integer getId();

    String getName();

    double getUnitPrice();

    void setUnitPrice(double unitPrice);

    void setUnitPrice(Double newPrice);

    int getQuantity();


    void setQuantity(Integer quantity);
}



