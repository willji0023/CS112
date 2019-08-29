import java.util.ArrayList;

public class Demo3
{

    public static void crunch(ArrayList<Offering> o) {
        System.out.println("Adding up the following offerings:");
        for (Offering current : o) {
            System.out.println(current);
        }
        System.out.printf("Total for all: $%,.2f\n", CashRegister.getTotalCostOfOfferings(o));
        System.out.println("---------------------------------\n");
    }

    public static void main(String[] args)
    {
        ArrayList<Offering> offeringList = new ArrayList<>();

        offeringList.add(new Product("iPhone", 999));
        offeringList.add(new Product("Movie ticket", 12));
        crunch(offeringList);

        offeringList.add(new Product("Backpack", 25));
        offeringList.add(new Product("Toyota Corolla", 19000));
        crunch(offeringList);

        offeringList.add(new Service("Gardening", 15, 10));
        offeringList.add(new Service("House keeping", 20, 17));
        crunch(offeringList);

        offeringList.add(new Service("Data Entry", 10, 25));
        offeringList.add(new Service("Driver", 13, 3));
        crunch(offeringList);
    }
}
