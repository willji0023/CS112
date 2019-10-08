import javax.swing.*;

public class Example1 {
    public static void willCrash(int x) {
        System.out.println("Value: " + x);
        willCrash(x+1);
        System.out.println("You will never see this");
    }

    public static int factorial(int x){
        if (x > 0)
            return x * factorial(x-1);
        else
            return 1;
    }

    public static int factorial2(int x){
        return x > 0 ? x * factorial2(x-1) : 1; // ternary operator (?)
    }

    public static void main(String[] args) {
        willCrash(0);
        String input = JOptionPane.showInputDialog("Enter a number. I will return it as a factorial");
        int fact = factorial(Integer.parseInt(input));
        JOptionPane.showMessageDialog(null, "Result: " + fact);

    }
}
