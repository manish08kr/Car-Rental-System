package X_ConsoleBasedProject1.CarRentalSystem;

public class Main {
    public static void main(String[] args) {

        Car car1 = new EconomyCar("C001", "Toyota", "Camry", 60.0);
        Car car2 = new SuvCar("C002", "Honda", "Accord", 70.0);
        Car car3 = new LuxuryCar("C003", "Mahindra", "Thar", 150.0);

        Car_Rental_System rentalSystem = new Car_Rental_System();
        rentalSystem.addCars(car1);
        rentalSystem.addCars(car2);
        rentalSystem.addCars(car3);

        rentalSystem.menu();
    }
}
