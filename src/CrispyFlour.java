
import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private int quantity;

    public CrispyFlour() {
        super();
        quantity=0;
    }

    public CrispyFlour(String _id, String _name,
                       LocalDate _manufacturingDate,
                       int _cost, int _quantity) {
        super(_id, _name, _manufacturingDate, _cost);
        quantity = _quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate timeCheck= LocalDate.now();
        if (timeCheck.isAfter(getExpiryDate()))
            return 0;
        else if (timeCheck.plusMonths(2).isAfter(getExpiryDate()))
            return getAmount() * 0.6;
        else if (timeCheck.plusMonths(4).isAfter(getExpiryDate()))
            return getAmount() * 0.8;
        else
            return getAmount() * 0.95;
    }

    public static void main(String[] args) {
        CrispyFlour crip1 = new CrispyFlour("1", "crip1", LocalDate.of(2020, 7, 20), 50000, 20);
        CrispyFlour crip2 = new CrispyFlour("1", "crip1", LocalDate.of(2020, 12, 17), 50000, 20);
        CrispyFlour crip3 = new CrispyFlour("1", "crip1", LocalDate.of(2021, 3, 17), 50000, 20);
        System.out.println(crip1.getExpiryDate());
        System.out.println(crip1.getRealMoney());
        System.out.println(crip2.getExpiryDate());
        System.out.println(crip2.getRealMoney());
        System.out.println(crip3.getExpiryDate());
        System.out.println(crip3.getRealMoney());
    }
}
