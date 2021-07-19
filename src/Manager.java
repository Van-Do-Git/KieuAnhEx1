import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private List<Discount> listMaterial = new ArrayList<>();

    public int getSize() {
        return listMaterial.size();
    }

    private int size;

    public Manager() {
    }

    public List<Discount> getListMaterial() {
        return listMaterial;
    }

    public void setListMaterial(List<Discount> listMaterial) {
        this.listMaterial = listMaterial;
    }

    public void add(Discount material) {
        listMaterial.add(material);
    }

    public void addAll(List<Discount> _listMaterial) {
        listMaterial.addAll(_listMaterial);
    }

    public int search(String name) {
        int index = -1;
        for (int i = 0; i < listMaterial.size(); i++) {
            if (listMaterial.get(i).equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public void edit(int index) {
        Discount editMaterial = listMaterial.get(index);
        Scanner input = new Scanner(System.in);
        if (editMaterial instanceof CrispyFlour) {
            System.out.println("Input quantity are you want to reset");
            CrispyFlour _editMaterial = (CrispyFlour) editMaterial;
            _editMaterial.setQuantity(input.nextInt());
            listMaterial.set(index, _editMaterial);
        }
        if (editMaterial instanceof Meat) {
            System.out.println("Input weight are you want to reset");
            Meat _editMaterial = (Meat) editMaterial;
            _editMaterial.setWeight(input.nextDouble());
            listMaterial.set(index, _editMaterial);
        }
    }

    public void remove(int index) {
        listMaterial.remove(index);
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < listMaterial.size(); i++) {
            totalAmount += ((Material) listMaterial.get(i)).getAmount();
        }
        return totalAmount;
    }

    public double totalDiscount() {
        double totalDiscount = 0;
        for (int i = 0; i < listMaterial.size(); i++) {
            totalDiscount += listMaterial.get(i).getRealMoney();
        }
        return totalDiscount;
    }
}
