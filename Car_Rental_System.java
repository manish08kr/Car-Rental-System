package X_ConsoleBasedProject1.CarRentalSystem;

// kis trh se store krega data ko

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car_Rental_System {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public Car_Rental_System() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCars(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not Available for rent");
        }
    }

    public void returnCar(Car car) {
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("car didn't have rented");
        }
        car.returnCar();
    }

    public void menu() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("========== Car Rental System ===============");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");

            System.out.print("Enter your Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("========= Rent a Car ===========");
                    System.out.print("Enter your name : ");
                    String CusName = sc.nextLine();

                    System.out.println("Available Car");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                        }
                    }
                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carID = sc.nextLine();

                    System.out.print("for how many days you want : ");
                    int rentalDays = sc.nextInt();
                    sc.nextLine();

                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), CusName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carID) && car.isAvailable()) {
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar != null) {
                        double totalPrice = selectedCar.calculatePrice(rentalDays);

                        System.out.println("============ Rental Information ================");
                        System.out.println("Customer ID : " + newCustomer.getCId());
                        System.out.println("Customer Name : " + newCustomer.getName());
                        System.out.println("Car : " + selectedCar.getCarId() + " " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.println("Rental Days : " + rentalDays);
                        System.out.printf("Total price $%.2f%n : " , totalPrice);

                        System.out.print("Confirm rental (Y/N) : ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("Car rented Successfully");
                        } else {
                            System.out.println("Rental Cancelled");
                        }
                    } else {
                        System.out.println("Invalid car selection or car not available for rent");
                    }
                    break;
                case 2:
                    System.out.println("============ Return a Car ================");
                    System.out.print("Enter your  CarID : ");
                    String carId = sc.nextLine();

                    Car carToReturn = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && !car.isAvailable()) {
                            carToReturn = car;
                            break;
                        }
                    }
                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }
                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("car returned Successfully by " + customer.getName());
                        } else {
                            System.out.println("car was not rented or rental information is wrong");
                        }
                    } else {
                        System.out.println("Invalid CarId or car was not rented");
                    }
                    break;
                case 3:
                    System.out.println("\nThank you for using the Car Rental System!");
                    return;
                default:
                    System.out.println("Invalid choice! please enter a valid choice");
            }
            System.out.println();
        }
    }
}

