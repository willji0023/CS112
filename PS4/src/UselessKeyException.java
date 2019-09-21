public class UselessKeyException extends Exception {
    private int uselessKey;

    public UselessKeyException(int uselessKey){
        super("Error: Key is divisible by 26. That's a bad key!");
        this.uselessKey = uselessKey;
    }

    public int getUselessKey(){
        return uselessKey;
    }
}
