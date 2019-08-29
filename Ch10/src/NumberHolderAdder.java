import java.io.FileNotFoundException;

public class NumberHolderAdder extends NumberHolder {

    public NumberHolderAdder(String fileWithNumbers) throws FileNotFoundException {
        super.loadAllNumbersFrom(fileWithNumbers);
    }
    @Override
    public int reduce() {
        int result =  0;
        for (int i : super.numbers){
            result += i;
        }
        return result;
    }
}
