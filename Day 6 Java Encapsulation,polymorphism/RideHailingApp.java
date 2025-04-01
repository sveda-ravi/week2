interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String location;


    public Vehicle(String vehicleId, String driverName, double ratePerKm, String location) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.location = location;
    }
    public String getVehicleId() {
        return vehicleId;
    }


    public String getDriverName() {
        return driverName;
    }


    public double getRatePerKm() {
        return ratePerKm;
    }


    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }


    protected String getLocation() {
        return location;
    }


    protected void setLocation(String location) {
        this.location = location;
    }
    public String getVehicleDetails() {
        return String.format("Vehicle ID: %s | Driver: %s | Rate/km: ₹%.2f", vehicleId, driverName, ratePerKm);
    }


    public abstract double calculateFare(double distance);
}
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }


    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }


    @Override
    public String getCurrentLocation() {
        return getLocation();
    }


    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }


    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }


    @Override
    public String getCurrentLocation() {
        return getLocation();
    }


    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}


// Subclass: Auto
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }


    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }


    @Override
    public String getCurrentLocation() {
        return getLocation();
    }


    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}
public class RideHailingApp {
    public static void processRides(Vehicle[] vehicles, double distance) {
        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            System.out.printf("Fare for %.2f km: ₹%.2f\n", distance, v.calculateFare(distance));
            System.out.println("----------------------------------");
        }
    }


    public static void main(String[] args) {
        Vehicle[] rides = {
                new Car("C101", "Alice", 12.0, "Downtown"),
                new Bike("B202", "Bob", 5.0, "Uptown"),
                new Auto("A303", "Charlie", 8.0, "Midtown")
        };
        ((GPS) rides[0]).updateLocation("Airport");
        ((GPS) rides[1]).updateLocation("City Center");
        ((GPS) rides[2]).updateLocation("Railway Station");
        processRides(rides, 10.0);
    }
}
