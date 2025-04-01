interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}


abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;


    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }


    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    public String getType() {
        return type;
    }


    public double getRentalRate() {
        return rentalRate;
    }


    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }


    public abstract double calculateRentalCost(int days);


    public void displayVehicle() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate + " per day");
    }
}


class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;


    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }


    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 50; // Flat service charge for car
    }


    public double calculateInsurance() {
        return 500.0;
    }


    public String getInsuranceDetails() {
        return "Car Policy #" + insurancePolicyNumber + " ($500/year)";
    }
}


class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;


    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }


    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }


    public double calculateInsurance() {
        return 200.0;
    }


    public String getInsuranceDetails() {
        return "Bike Policy #" + insurancePolicyNumber + " ($200/year)";
    }
}


class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;


    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }


    public double calculateRentalCost(int days) {
        return getRentalRate() * days + (days * 100); // Additional daily logistics fee
    }


    public double calculateInsurance() {
        return 800.0;
    }


    public String getInsuranceDetails() {
        return "Truck Policy #" + insurancePolicyNumber + " ($800/year)";
    }
}
public class VehicleRentalSystem {
    public static void processRentals(Vehicle[] vehicles, int days) {
        for (Vehicle v : vehicles) {
            v.displayVehicle();
            double rentalCost = v.calculateRentalCost(days);
            System.out.printf("Rental Cost for %d days: $%.2f\n", days, rentalCost);


            if (v instanceof Insurable) {
                Insurable insurable = (Insurable) v;
                System.out.println("Insurance Details: " + insurable.getInsuranceDetails());
                System.out.printf("Insurance Cost: $%.2f\n", insurable.calculateInsurance());
            }


            System.out.println("-----------------------------");
        }
    }


    public static void main(String[] args) {
        Vehicle[] fleet = {
                new Car("CAR123", 100.0, "CAR-INS-001"),
                new Bike("BIKE456", 40.0, "BIKE-INS-002"),
                new Truck("TRUCK789", 150.0, "TRUCK-INS-003")
        };


        processRentals(fleet, 5);
    }
}
