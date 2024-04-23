package InvoicingSystem;

public class Item {
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double newPrice) {

        this.unitPrice = newPrice;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }





}