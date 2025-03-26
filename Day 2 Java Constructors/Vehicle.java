public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 150.0;  // Class variable (fixed for all vehicles)

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration Fee updated to: $" + registrationFee);
    }

    // Main method to test
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Sveda Ravi", "Car");
        Vehicle v2 = new Vehicle("John Doe", "Motorcycle");

        System.out.println("Before updating registration fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
        System.out.println();

        // Update registration fee
        Vehicle.updateRegistrationFee(200.0);
        System.out.println();

        System.out.println("After updating registration fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
