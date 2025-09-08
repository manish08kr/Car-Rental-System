package X_ConsoleBasedProject1.CarRentalSystem;

//  Abstraction ..........
abstract class vehicle {
    private String brand;
    private String model;

    public vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

// Inheritance ...........
class Car extends vehicle {
    private String carId;
    private double basePrice; // per day
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePrice) {
        super(brand, model);
        this.carId = carId;
        this.basePrice = basePrice;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double calculatePrice(int daysRented) {
        return daysRented * basePrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {        // car ko rent pe chadha do
        isAvailable = false;
    }

    public void returnCar() {  // car return ho gya hai , to available ho gya hai ab
        isAvailable = true;
    }
}

// Polymorphism......

// EconomyCar.java
class EconomyCar extends Car {
    public EconomyCar(String carId, String brand, String model, double basePrice) {
        super(carId, brand, model, basePrice);
    }

    public double calculatedPrice(int daysRented) {
        return super.getBasePrice() * daysRented * 0.90;
    }
}

// SuvCar.java
class SuvCar extends Car {
    public SuvCar(String carId, String brand, String model, double basePrice) {
        super(carId, brand, model, basePrice);
    }

    public double calculatedPrice(int daysRented) {
        return super.getBasePrice() * daysRented * 1.20;
    }
}

// LuxuryCar.java
class LuxuryCar extends Car {
    public LuxuryCar(String carId, String brand, String model, double basePrice) {
        super(carId, brand, model, basePrice);
    }

    @Override
    public double calculatePrice(int daysRented) {
        return super.getBasePrice() * daysRented * 1.50;
    }
}
