public class TestScores {
    private String name;
    private double totalScore = 0;
    private int numScores = 0;

    public TestScores(String name){
        this.name = name;
    }

    public void addTestScore(double earned){
        numScores++;
        totalScore += earned;
    }

    public int getNumTestsTaken(){
        return numScores;
    }

    public double getAverage(){
        return (totalScore / numScores);
    }

    public String getName(){
        return name;
    }
}
