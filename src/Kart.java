import java.util.Random;

public class Kart extends Vehicle{
    private static Random rand = new Random();
    private SpecialItem[] items = {new SpecialItem("Green Shell", 5),
            new SpecialItem("Banana", 3),
    new SpecialItem("Oil", 1)};
    public Kart(int speed){
        super("Mario Kart", speed);

    }

    public int attack(){
        return detailedAttack().getDelay();
    }
    public SpecialItem detailedAttack(){
        int idx = rand.nextInt(items.length);
        return items[idx];
    }
}
