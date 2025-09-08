package X_ConsoleBasedProject1.CarRentalSystem;

class Customer {
    private String cId;
    private String name;

    public Customer(String cId, String name) {
        this.cId = cId;
        this.name = name;
    }

    public String getCId() {
        return cId;
    }

    public String getName() {
        return name;
    }
}
