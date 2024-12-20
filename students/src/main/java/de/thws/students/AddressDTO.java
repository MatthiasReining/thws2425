package de.thws.students;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

    @NotBlank
    public String street;
    @NotBlank
    public String housenumber;

    // only numbers
    @NotBlank
    public String zip;

    @NotBlank
    public String city;

}
