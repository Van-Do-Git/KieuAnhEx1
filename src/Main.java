import javafx.scene.paint.Material;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Material meat1 = new Meat("1", "meat1", LocalDate.of(2021, 7, 11), 50000, 20);
        Discount meat2 = new Meat("2", "meat2", LocalDate.of(2021, 7, 12), 55000, 18);
        Discount meat3 = new Meat("3", "meat3", LocalDate.of(2021, 7, 13), 45000, 30);
        Discount meat4 = new Meat("4", "meat4", LocalDate.of(2021, 7, 14), 65000, 25);
        Discount meat5 = new Meat("5", "meat5", LocalDate.of(2021, 7, 15), 56000, 24);
        Discount crip1 = new CrispyFlour("1", "crip1", LocalDate.of(2020, 9, 17), 15000, 15);
        Discount crip2 = new CrispyFlour("1", "crip1", LocalDate.of(2020, 12, 17), 18000, 18);
        Discount crip3 = new CrispyFlour("1", "crip1", LocalDate.of(2020, 8, 17), 20000, 18);
        Discount crip4 = new CrispyFlour("1", "crip1", LocalDate.of(2021, 4, 17), 19000, 19);
        Discount crip5 = new CrispyFlour("1", "crip1", LocalDate.of(2021, 6, 17), 17000, 17);
        Discount[] list = {meat1,meat2,meat3,meat4,meat5,crip1,crip2,crip3,crip4,crip5};
        List<Discount> _list= Arrays.asList(list);
        Manager vanDx = new Manager();
        vanDx.setListMaterial(_list);
        System.out.println("Chua chiet khau : "+vanDx.totalAmount());
        System.out.println("Da chiet khau : "+vanDx.totalDiscount());
        System.out.println("Chenh lech : "+(vanDx.totalAmount()- vanDx.totalDiscount()));
    }
}
