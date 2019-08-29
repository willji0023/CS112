import java.io.FileNotFoundException;

public class NumberHolderGreatest extends NumberHolder {

    public NumberHolderGreatest(String fileWithNumbers) throws FileNotFoundException {
        super.loadAllNumbersFrom(fileWithNumbers);
    }

    @Override
    public int reduce() {
        int greatest = 0;
        for (int i : super.numbers){
            if (i > greatest){
                greatest = i;
            }
        }
        return greatest;
    }
}