import java.util.ArrayList;

public class CashRegister {
    public static double getTotalCostOfOfferings(ArrayList<Offering> o){
        double total = 0;
        for (Offering offering : o){
            total += offering.getTotalCost();
        }
        return total;
    }
}
