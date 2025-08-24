package X_ConsoleBasedProject.Project;


// kaun sa customer kaun sa car rent pe lega....

public class Rental {

//     class is also a type of Object data type
//     Object jo hai obj type ka hai

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
