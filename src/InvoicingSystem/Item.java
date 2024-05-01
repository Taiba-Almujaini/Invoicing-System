package InvoicingSystem;

public class Item implements ItemInterface{
    Integer id;
    String name;
    Double unitPrice;
    Integer quantity;


    public Item(Integer id, String name, Double unitPrice, Integer quantity) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public void setUnitPrice(double unitPrice) {

    }

    @Override
    public void setUnitPrice(Double newPrice) {

        this.unitPrice = newPrice;
    }
    @Override
    public int getQuantity() {

        return quantity;
    }
 @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }





}
