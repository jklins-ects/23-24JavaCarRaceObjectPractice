import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MegaRace {
    private static ArrayList<Vehicle> vehicles; //class level variable - static because there is no instance
    private static Scanner input = new Scanner(System.in);

    public static final int INITIAL_SPEED_MIN = 95;
    public static final int INITIAL_SPEED_MAX = 105;
    public static final int DISTANCE_TO_FINISH = 500;
    public static final int MILLIDELAY = 1000;

    public static void main(String[] args) {
        vehicles = new ArrayList<>();
        String userIn;
        do {
            System.out.print("Enter V to add a vehicle, K to add a kart and G to start the race: ");
            userIn = input.nextLine().trim().toUpperCase();
            if(userIn.equals("V")){
                addVehicle();
            }if(userIn.equals("K")){
                addKart();
            }
        }while(!userIn.equals("G")); //note: using !string.equals("string"), not !=
        if(vehicles.size() >= 2){
            raceCars();
        }else{
            System.out.println("Not enough cars to race");
        }
    }

    public static void addVehicle(boolean isKart){
        String type;
        if(isKart){
            System.out.println("Adding Kart");
            System.out.print("Please enter the racer's name: ");
        }else{
            System.out.println("Adding vehicle");
            System.out.print("Please enter the vehicle type: ");
        }
        type = input.nextLine();
        System.out.print("Please enter the base speed (invalid input will be treated as 80): ");
        int speed = Utilities.parseInt(input.nextLine(), 80);
        if(isKart){
            vehicles.add(new Kart(type, speed));
        }else{
            vehicles.add(new Vehicle(type, speed));
        }

    }

    public static void addVehicle(){
        addVehicle(false);
    }

    public static void addKart(){
        addVehicle(true);
    }

    public static void raceCars(){
        while(checkForWinner() == null){
            setLapSpeeds();
            kartAttacks();
            updateDistances();
            printDistances();
            Utilities.pause(MILLIDELAY);
        }
        System.out.println(ConsoleColors.GREEN +  checkForWinner().getBrand() + " won the race!" + ConsoleColors.RESET);

    }

    public static void setLapSpeeds(){
        for (Vehicle v:vehicles
        ) {
            int lapSpeed = v.getSpeed() + ThreadLocalRandom.current().nextInt(-5, 5);
            v.setCurrentLapSpeed(lapSpeed);
        }
    }

    public static void kartAttacks(){
        for (Vehicle k:vehicles
        ) {
            if(k instanceof Kart){
                SpecialItem s = ((Kart) k).detailedAttack();
                int target;
                do{
                    target = ThreadLocalRandom.current().nextInt(vehicles.size());
                }while(vehicles.get(target) == k);
                Vehicle v =vehicles.get(target);
                int origspeed = v.getCurrentLapSpeed();
                v.setCurrentLapSpeed(v.getCurrentLapSpeed() - s.getDelay());
                System.out.println(s.getTextColor() + "The " + k.getBrand() + " slowed " + v.getBrand() + " by " +
                        s.getDelay() + " with a " + s.getItem() + " reducing the speed of " + origspeed + "mph to " + v.getCurrentLapSpeed() + "mph" + ConsoleColors.RESET);
            }
        }
    }

    public static void updateDistances(){
        for (Vehicle v: vehicles) {
            v.updateDistance(v.getCurrentLapSpeed());
        }
    }

    public static void printDistances(){
        for (Vehicle v: vehicles) {
            for(int i = 0; i < v.getDistanceTraveled(); i+= 10){
                System.out.print("-");
            }
            System.out.println(v.getBrand() + " (lap speed: " + v.getCurrentLapSpeed() + "; total distance: " + v.getDistanceTraveled() + ")");
        }
    }

    public static Vehicle checkForWinner(){
        Vehicle winner = null;
        for (Vehicle v:vehicles) {
            if(v.getDistanceTraveled() >= DISTANCE_TO_FINISH){
                if(winner == null || winner.getDistanceTraveled() < v.getDistanceTraveled()){
                    winner = v;
                }
            }
        }
        return winner;
    }

}
