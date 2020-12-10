package dto;

public class AddressEpam {
    public String country;
    public String city;
    public String postcode;
    public String streetName;
    public String streetNumber;

    public AddressEpam(String country, String city, String postcode, String streetName, String streetNumber) {
        this.country = country;
        this.city = city;
        this.postcode = postcode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

}
