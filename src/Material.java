import java.time.LocalDate;

public abstract class Material {
    public String id;
    public String name;
    public LocalDate manufacturingDate;
    public int cost;

    public Material() {
        id = null;
        name = null;
        manufacturingDate = null;
        cost= 0;
    }

    public Material(String _id, String _name,
                    LocalDate _manufacturingDate, int _cost) {
        id = _id;
        name = _name;
        manufacturingDate = _manufacturingDate;
        cost = _cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract double getAmount();

    public abstract LocalDate getExpiryDate();
}
