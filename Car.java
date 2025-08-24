package X_ConsoleBasedProject.Project;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePrice; // per day
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePrice) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePrice = basePrice;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int daysRented) {
        return daysRented * basePrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {  // rent pe le liya hai
        isAvailable = false;
    }

    public void returnCar() { // car return ho gya hai , to available ho gya hai ab
        isAvailable = true;
    }


}
