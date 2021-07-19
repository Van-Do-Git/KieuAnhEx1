import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
        super();
        weight = 0;
    }

    public Meat(String _id, String _name, LocalDate _manufacturingDate, int _cost, double _weight) {
        super(_id, _name, _manufacturingDate, _cost);
        weight = _weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate timeCheck = LocalDate.now();
        if (timeCheck.isAfter(getExpiryDate()) || timeCheck.isBefore(manufacturingDate)) {
            throw new Error("is underfile");
        } else if (timeCheck.plusDays(3).isAfter(getExpiryDate()))
            return getAmount() * 0.5;
        else if (timeCheck.plusDays(5).isAfter(getExpiryDate()))
            return getAmount() * 0.7;
        else return getAmount() * 0.9;
    }

    public static void main(String[] args) {
        Meat checken1 = new Meat("1", "meat1", LocalDate.of(2021, 7, 13), 50000, 20);
        Meat checken2 = new Meat("1", "meat1", LocalDate.of(2021, 7, 15), 50000, 20);
        Meat checken3 = new Meat("1", "meat1", LocalDate.of(2021, 7, 18), 50000, 20);
        System.out.println(checken1.getRealMoney());
        System.out.println(checken2.getRealMoney());
        System.out.println(checken3.getRealMoney());
    }
}
