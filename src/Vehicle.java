class Vehicle {
    private String brand;
    private int speed;
    private int distanceTraveled;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        this.distanceTraveled = 0;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void updateDistance(int speed) {
        // Update the distance traveled based on speed
        distanceTraveled += speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", distanceTraveled=" + distanceTraveled +
                '}';
    }
}