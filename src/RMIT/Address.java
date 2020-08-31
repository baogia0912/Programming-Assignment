package RMIT;

public class Address {
    private String houseNumber;
    private String streetName;

    public Address(String houseNumber, String streetName) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
