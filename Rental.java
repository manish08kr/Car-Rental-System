package X_ConsoleBasedProject1.CarRentalSystem;

// Describe the relation between car and customer.............
// kaun sa customer kaun sa car rent pe lega....

class Rental {

//     class is also a type of Object data type
//     Object us class k type ka hota hai

    private Car car;
    private Customer customer;
    private int day;

    public Rental(Car car, Customer customer, int day) {
        this.car = car;
        this.customer = customer;
        this.day = day;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDay() {
        return day;
    }
}
